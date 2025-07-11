package com.github.bruce_mig.reactive_user_management.repository;

import com.github.bruce_mig.reactive_user_management.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCassandraRepository<User, Integer> {

    @AllowFiltering
    Flux<User> findByAgeLessThan(int age);

    @AllowFiltering
    Mono<User> findByAddress(String address);
}
