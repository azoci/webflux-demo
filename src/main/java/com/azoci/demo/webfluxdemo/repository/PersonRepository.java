package com.azoci.demo.webfluxdemo.repository;

import com.azoci.demo.webfluxdemo.domain.Person;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonRepository implements ReactiveCrudRepository<Person, String>{
  private final Map<String, Person> peopleMap = new ConcurrentHashMap<>();

  public PersonRepository() {
    peopleMap.put("1", new Person("park", 10));
    peopleMap.put("2", new Person("sohn", 20));
    peopleMap.put("3", new Person("nam", 30));
    peopleMap.put("4", new Person("jeon", 40));
    peopleMap.put("5", new Person("lee", 50));
  }

  @Override
  public <S extends Person> Mono<S> save(S s) {
    return null;
  }

  @Override
  public <S extends Person> Flux<S> saveAll(Iterable<S> iterable) {
    return null;
  }

  @Override
  public <S extends Person> Flux<S> saveAll(Publisher<S> publisher) {
    return null;
  }

  @Override
  public Mono<Person> findById(String s) {
    return Mono.justOrEmpty(peopleMap.get(s));
  }

  @Override
  public Mono<Person> findById(Publisher<String> publisher) {
    return null;
  }

  @Override
  public Mono<Boolean> existsById(String s) {
    return null;
  }

  @Override
  public Mono<Boolean> existsById(Publisher<String> publisher) {
    return null;
  }

  @Override
  public Flux<Person> findAll() {
    return Flux.fromIterable(peopleMap.values());
  }

  @Override
  public Flux<Person> findAllById(Iterable<String> iterable) {
    return null;
  }

  @Override
  public Flux<Person> findAllById(Publisher<String> publisher) {
    return null;
  }

  @Override
  public Mono<Long> count() {
    return null;
  }

  @Override
  public Mono<Void> deleteById(String s) {
    return null;
  }

  @Override
  public Mono<Void> deleteById(Publisher<String> publisher) {
    return null;
  }

  @Override
  public Mono<Void> delete(Person person) {
    return null;
  }

  @Override
  public Mono<Void> deleteAll(Iterable<? extends Person> iterable) {
    return null;
  }

  @Override
  public Mono<Void> deleteAll(Publisher<? extends Person> publisher) {
    return null;
  }

  @Override
  public Mono<Void> deleteAll() {
    return null;
  }
}
