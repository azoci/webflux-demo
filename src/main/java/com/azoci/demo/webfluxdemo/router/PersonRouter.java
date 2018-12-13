package com.azoci.demo.webfluxdemo.router;

import com.azoci.demo.webfluxdemo.handler.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PersonRouter {

  @Bean
  public RouterFunction<ServerResponse> routes (PersonHandler handler) {
    return RouterFunctions
        .route(RequestPredicates.GET("/people"), handler::all)
        .andRoute(RequestPredicates.GET("/people/{id}"), handler::byId);
  }
}
