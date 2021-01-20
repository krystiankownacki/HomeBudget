# HomeBudget

Simple Spring Boot 2 application with PostgreSQL database. Application helps to keep the home budget.

### Allowed operations:
* Recharge an existing register with given amount 
* Transfer given amount between two existing registers
* Get current balance of all registers

### Demo requests
Can be found in `/demo` catalogue on a main path.

## How to build
App and database is dockerized. Only thing you should do is run:
`docker-compose build` inside `/docker` folder on a main path.

## How to run
Run `docker-compose up` in `/docker` folder on a main path.