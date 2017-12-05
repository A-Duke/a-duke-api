[![Build Status](https://travis-ci.org/eva4j/eva4j-api.svg?branch=master)](https://travis-ci.org/eva4j/eva4j-api)
[![Coverage Status](https://coveralls.io/repos/eva4j/eva4j-api/badge.png)](https://coveralls.io/r/eva4j/eva4j-api)

# Motivation

## Eventual Atomicity (eva) for Cassandra

Scenario: user orders one item with price 100, so if all goes well:
 
- Stock amount is decreased by 1
- User balance is decreased by 100

If any operation fails previous operations must be `compensated`, e.g.:

1. Stock amount is decreased by 1
2. Now it is turned out that user balance is 90 and may not be decreased by 100
3. Stock amount is `compensated` by 1


Finally:

- `COMPLETED` must not coexist with any other status
- `NOT_STARTED` must follow `NOT_STARTED` or `FAILED`

Transaction final status: `COMPLETED` if all operations have `CEOMPLETED` status, `FAILED` otherwise


# Usage

How to use this

# Under the Hood

How it works: interactions of core classes/modules

# Links

https://stackoverflow.com/questions/47631686/what-is-cassandra-static-fields-sense
https://stackoverflow.com/questions/47354241/cassandra-and-aggregated-data
https://books.google.ru/books?id=bh8_0FD3qgQC&pg=PA60