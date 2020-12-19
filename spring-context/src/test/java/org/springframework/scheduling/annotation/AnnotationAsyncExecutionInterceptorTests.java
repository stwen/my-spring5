/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.scheduling.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Unit tests for {@link AnnotationAsyncExecutionInterceptor}.
 *
 * @author Chris Beams
 * @since 3.1.2
 */
public class AnnotationAsyncExecutionInterceptorTests {

	@Test
	@SuppressWarnings("unused")
	public void testGetExecutorQualifier() throws SecurityException, NoSuchMethodException {
		AnnotationAsyncExecutionInterceptor i = new AnnotationAsyncExecutionInterceptor(null);
		{ // method level
			class C {
				@Async("qMethod")
				void m() {
				}
			}
			assertThat(i.getExecutorQualifier(C.class.getDeclaredMethod("m")), is("qMethod"));
		}
		{ // class level
			@Async("qClass")
			class C {
				void m() {
				}
			}
			assertThat(i.getExecutorQualifier(C.class.getDeclaredMethod("m")), is("qClass"));
		}
		{ // method and class level -> method value overrides
			@Async("qClass")
			class C {
				@Async("qMethod")
				void m() {
				}
			}
			assertThat(i.getExecutorQualifier(C.class.getDeclaredMethod("m")), is("qMethod"));
		}
		{ // method and class level -> method value, even if empty, overrides
			@Async("qClass")
			class C {
				@Async
				void m() {
				}
			}
			assertThat(i.getExecutorQualifier(C.class.getDeclaredMethod("m")), is(""));
		}
		{ // meta annotation with qualifier
			@MyAsync
			class C {
				void m() {
				}
			}
			assertThat(i.getExecutorQualifier(C.class.getDeclaredMethod("m")), is("qMeta"));
		}
	}

	@Async("qMeta")
	@Retention(RetentionPolicy.RUNTIME)
	@interface MyAsync {
	}
}
