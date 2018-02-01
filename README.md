[![Build Status](https://travis-ci.org/eva4j/eva4j-api.svg?branch=master)](https://travis-ci.org/eva4j/eva4j-api)
[![Coverage Status](https://coveralls.io/repos/eva4j/eva4j-api/badge.png)](https://coveralls.io/r/eva4j/eva4j-api)

<img src="docs/a-duke.png" width="300">

This project materializes few dreams in connection to Java database development:

- Eventual Atomicity for Cassandra
  - Scenario: transfer money between accounts, need two updates. If second update fails then first one must be `compensated`.
- History. All operations are tracked automatically
- Binary States/Operations. No tables anymore to keep states and operations, use pure Java objects instead (Cassandra/JDBC as storage)
- Simplicity
  - Everything above must be very simple in usage and testing
  - Tests do not work with database directly

# Usage

How to use this

# Under the Hood

How it works: interactions of core classes/modules

# Links

- Don't use In-Memory Databases (like H2) for Tests https://blog.philipphauer.de/dont-use-in-memory-databases-tests-h2/
- https://stackoverflow.com/questions/47655837/cassandra-filter-latest-rows-from-an-append-only-table
  - having billions of partitions per node will cause slow down repairs and compactions significantly.
  - but: https://stackoverflow.com/questions/30648479/choosing-a-partition-key-for-a-cassandra-table-how-many-is-too-many-partition
  - and http://grokbase.com/t/cassandra/user/14c555q5t3/pros-and-cons-of-lots-of-very-small-partitions-versus-fewer-larger-partitions 
- https://stackoverflow.com/questions/47631686/what-is-cassandra-static-fields-sense
- https://stackoverflow.com/questions/47354241/cassandra-and-aggregated-data
- https://books.google.ru/books?id=bh8_0FD3qgQC&pg=PA60

Miroservices

- https://stackoverflow.com/questions/39364466/how-to-dockerized-java-microservices-efficiently
  - Say you give each JVM a 2 GB heap and add 1 GB for docker+JVM, you are looking needing a 64 GB server to run 20 JVMs/dockers.
- https://developers.redhat.com/blog/2017/03/14/java-inside-docker/
- https://dzone.com/articles/how-to-decrease-jvm-memory-consumption-in-docker-u
- http://trustmeiamadeveloper.com/2016/03/18/where-is-my-memory-java/
  - What I can say as a conclusion? Well… never put words “java” and “micro” in the same sentence :) I'm kidding - just remember that dealing with memory in case of java, linux and docker is a bit more tricky thing than it seems at first.
- https://buoyant.io/2016/06/17/small-memory-jvm-techniques-for-microservice-sidecars/
  - In this post, we’ll describe how we reduced the memory footprint of linkerd, our JVM-based service mesh for cloud-native applications, by almost 80%—from 500mb to 105mb—by tuning the JVM’s runtime parameters. 
- https://stackoverflow.com/questions/38747525/spring-cloud-microservices-memory-usage
  -  And all of them consume over 350mb-500mb and sometimes crash, although they will not be used. I thought microservices should be lightweight. But with this memory usage
  - atomyj, atomagic.org, atomey (atomey.com), atomie, atomeye
