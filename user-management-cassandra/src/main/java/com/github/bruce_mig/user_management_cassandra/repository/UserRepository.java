package com.github.bruce_mig.user_management_cassandra.repository;

import com.github.bruce_mig.user_management_cassandra.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface UserRepository extends CassandraRepository<User, Integer> {

    @Query("SELECT * FROM migeri.users WHERE age>?0 ALLOW FILTERING")
    List<User> findByAgeGreaterThan(int age);
}
