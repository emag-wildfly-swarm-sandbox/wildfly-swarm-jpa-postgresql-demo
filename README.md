# wildfly-swarm-jpa-postgresql-demo

WildFly Swarm JPA PostgreSQL Fraction Demo

## Usage

###  Run the app

``` sh
$ ./mvnw clean wildfly-swarm:run
```

### Access protected API

``` sh
$ curl localhost:8080 | jq .
[
  {
    "id": 0,
    "name": "Penny",
    "password": "password1",
    "role": "admin"
  }
]
```