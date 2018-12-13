package com.azoci.demo.webfluxdemo.handler;

import co.elastic.apm.api.CaptureTransaction;
import com.azoci.demo.webfluxdemo.domain.Person;
import com.azoci.demo.webfluxdemo.repository.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {
  private final PersonRepository repository;

  public PersonHandler(PersonRepository repository) {
    this.repository = repository;
  }

  @CaptureTransaction
  public Mono<ServerResponse> all(ServerRequest request) {
    Flux<Person> people = this.repository.findAll();
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(people, Person.class);
  }

  @CaptureTransaction
  public Mono<ServerResponse> byId(ServerRequest request) {
    String id = request.pathVariable("id");
    Mono<Person> person = this.repository.findById(id);
    return ServerResponse.ok().body(person, Person.class);
  }
}
