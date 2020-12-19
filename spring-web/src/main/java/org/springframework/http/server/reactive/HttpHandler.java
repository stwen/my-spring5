/*
 * Copyright 2002-2016 the original author or authors.
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

package org.springframework.http.server.reactive;

import reactor.core.publisher.Mono;

/**
 * Lowest level contract for reactive HTTP request handling that serves as a
 * common denominator across different runtimes.
 *
 * <p>Higher-level, but still generic, building blocks for applications such as
 * {@code WebFilter}, {@code WebSession}, {@code ServerWebExchange}, and others
 * are available in the {@link org.springframework.web.server} package.
 *
 * <p>Application level programming models such as annotated controllers and
 * functional handlers are available in the {@code spring-webflux} module.
 *
 * <p>Typically an {@link HttpHandler} represents an entire application with
 * higher-level programming models bridged via
 * {@link org.springframework.web.server.adapter.WebHttpHandlerBuilder
 * WebHttpHandlerBuilder}. Multiple applications at unique context paths can be
 * plugged in with the help of the {@link ContextPathCompositeHandler}.
 *
 * @author Arjen Poutsma
 * @author Rossen Stoyanchev
 * @see ContextPathCompositeHandler
 * @since 5.0
 */
public interface HttpHandler {

	/**
	 * Handle the given request and write to the response.
	 *
	 * @param request  current request
	 * @param response current response
	 * @return indicates completion of request handling
	 */
	Mono<Void> handle(ServerHttpRequest request, ServerHttpResponse response);

}