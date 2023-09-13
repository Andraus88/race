#  Race project in SpringBoot
by André Luiz Rausch de Souza

## _CHALLENGE WEEK XII - Spring Boot - Back-End Journey | AWS_

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/Andraus88/race)

This Project require of the student to develop a "Cars" RESTful API using the Spring Boot framework in Java 17 and SpringBoot 3.0.9 that connects to RabbitMQ to create a Queue of "Races" that is then recorded in a "History". In addition, it must implement data persistence in MongoDB, with documentation on Swagger and utilizing OpenFeign. Security is optional but recommended, docker-compose.yml is also highly recommended, 

It should have at least the microservices of:

- ms-cars
- ms-races
- ms-history

## Features

- ms-cars <IMPLEMENTED>:
Create a CRUD system for ms-cars, with brand, model, pilot and year.

- ms-races:
Create a Track to insert the Cars into.
Start the Race Queue in RabbitMQ and make a system for Cars to overtake Cars in front of them.

- ms-history:
- consume de queue from ms-races and save in MongoDB.


All endpoints and resources are clearly defined, with a consistent naming pattern.

Many tests are running, covering 85% of Lines. These tests include Controllers "/Put", all Servies "save", "getById", "getAll", "delete" and "update".
MongoDB is in use to save all Cars, Swagger is implemented for  documentation.

> Note: Due to personal constraints and unfamiliarity in utilization of RabbitMQ the ms-races and ms-history features are yet to be implemented.

```sh
The API is versioned 0.0.3-SNAPSHOT
```
