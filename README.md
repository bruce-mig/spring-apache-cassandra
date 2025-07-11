# spring-apache-cassandra

## Overview 
This repository contains multiple projects using Apache Cassandra.

![cassandra](logo.png)

---

## Features

- **Local Apache Cassandra Cluster** setup with Docker Compose (both standalone and multi-node options)
- **Spring Boot integration** for CRUD operations with Apache Cassandra
- **Swagger UI** for testing API endpoints

---

## Prerequisites

- [Docker](https://www.docker.com/) & [Docker Compose](https://docs.docker.com/compose/)
- Java 17+ and Maven (for Spring Boot app)
- Optional: Astra DB, for a cloud based Cassandra cluster

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/bruce-mig/spring-apache-cassandra.git
cd spring-apache-cassandra
```

---
### 2. Set up Cassandra cluster

Start multi-node Pulsar cluster:  

`docker compose up -d`

Or, for standalone mode:  

`docker compose up cassandra-1 -d`

---
## Configure apache cassandra

The Cassandra Query Language (CQL) is very similar to SQL but suited for the JOINless structure of Cassandra. 
The CQL shell, or cqlsh, is one tool to use in interacting with the database. 
We’ll use it to configure the database.

```bash
docker exec -it cassandra-1 bin/bash

cqlsh

describe keyspaces;

CREATE KEYSPACE IF NOT EXISTS migeri WITH REPLICATION ={ 'class' : 'SimpleStrategy','replication_factor' : '1'};
```

### user-management-cassandra

Configure the cluster for the [user-management-cassandra](https://github.com/bruce-mig/spring-apache-cassandra/tree/main/user-management-cassandra) project as below.

```bash
use migeri;

CREATE TABLE IF NOT EXISTS users (id int PRIMARY KEY,name text,address text,age int);

# add index on columns to be filtered 
create index on users(age);

select * from users;
```

---

## Application Usage
#### 1. Build & Run Spring Boot App

```bash
cd <project-name>
./mvnw spring-boot:run
```

Api Docs
http://localhost:8080/swagger-ui/index.html#/

---

## Project Structure

- user-management-cassandra: Spring Boot project
- scripts: CQL Scripts 
- docker-compose.yaml: Docker Compose configurations

## References
[Apache Cassandra Documentation](https://cassandra.apache.org/doc/latest/)  
[Spring Data for Apache Cassandra](https://spring.io/projects/spring-data-cassandra)  

## License
This project is licensed under the [MIT License](LICENCE).

## Contributing
Contributions are welcome! Please open issues or submit pull requests for improvements or bug fixes.
