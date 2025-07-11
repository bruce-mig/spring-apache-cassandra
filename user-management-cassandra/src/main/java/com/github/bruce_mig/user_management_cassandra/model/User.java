package com.github.bruce_mig.user_management_cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(keyspace = "migeri", value = "users")
public class User {

    @PrimaryKey
    private int id;
    private String name;
    private String address;
    private int age;

}
