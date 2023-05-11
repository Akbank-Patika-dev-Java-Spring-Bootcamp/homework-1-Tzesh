# Patika.dev - Akbank Spring Bootcamp Homework 1

We were asked to create a simple REST API for a country management system. The API should be able to create, read, update and delete countries. Long story short, CRUD operations.
Country model should have the following fields:
- id
- name
- president

While creating dto classes we should use mapstruct library. We should also use lombok library to avoid boilerplate code.

We were free to choose any database we want. I used H2 database. I also used Swagger to document the API.

## How to run
Clone the repository and run the following commands in the root directory of the project.

```bash
cd AkbankSpringBootHW1
mvn clean compile
mvn spring-boot:run
```

After running these commands, you should see something like this in your terminal:

![Image of the mvn spring-boot:run](https://imgur.com/sS5IhxK.png)

After running the commands, you can access the API using swagger-ui. Go to http://localhost:8080/api/v1/swagger-ui/index.html in your browser.

![Image of the swagger-ui](https://imgur.com/4PrjgED.png)