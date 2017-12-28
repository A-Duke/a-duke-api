[![Build Status](https://travis-ci.org/eva4j/eva4j-api.svg?branch=master)](https://travis-ci.org/eva4j/eva4j-api)
[![Coverage Status](https://coveralls.io/repos/eva4j/eva4j-api/badge.png)](https://coveralls.io/r/eva4j/eva4j-api)

# Motivation

This project materializes few dreams

## Eventual Atomicity (eva) for Cassandra

`eva` + `cassandra` = two girls

Scenario: user orders one item with price 100, so if all goes well:
 
- Stock item balance is decreased by 1
- User money balance is decreased by 100

If any operation fails previous operations must be `compensated`, e.g.:

- Stock balance is decreased by 1
- Now it is turned out that user balance is 90 and may not be decreased by 100
- Stock amount is `compensated` by 1

Thus `eventual transactions` do not fully revert operations but compensate them, so if operation is compensated two operations will be eventually visible

In this example `stock` and `user`  are `stateful` objects, state of any object can be changed by applying operations

## Operation History

- If someone changes stock item price it should be kept in history
- Same for user profile modifications
- In other words we should remember any state modification

## Binary States/Operations

- State/operation may be too complex to be explained as a database record
- Even if they can be explained, structures can be changed in time
- Binary eliminates the need to maintain database structures - all is kept as it comes to database
- Binary may even represents complex structures in third and above normal forms

## States vs Views vs Aggregates

- Each view record represents one state/operation/transaction record (e.g. `users ordered by name` or `users whose balance more than 100k`)
- Each aggregate record represents one or few operations/states (e.g. "sales per month")
- Views and aggregates are completely separated from states/operations and calculated after them
- Above means that even if user is created it is not possible to directly issue queries like "select name from users"
  - User state is kept as a binary object, database knows nothing about `name`
  - View `users ordered by name` which has `name` field should be created and calculated separately (quite like cassandra `materialized view`)
  
## Easy Tests

- Operation just converts one state to another, no need to have/emulate database to store sates to test operation 
- Still it may be needed to mock some views/aggregates, but that's pretty easy

## Easy Things

Everything above should be very easy to implement and use 

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