
# Spring boot basic structure

Spring boot project for beginner level


## Tech Stack

**Server:** Java, Java Spring boot, JPA, lombok,

**Database**: Mysql


## Installation

Clone project from github

```bash
  git clone git@github.com:Nathapons/spring-boot-basic-structure.git
  cd spring-boot-basic-structure
```

Set up application.yml. If you don't have please create the file in /src/main/resources

```bash
spring:
  datasource:
    url: jdbc:mysql://<your-database-host>:<your-database-port>/<your-database-name>
    username: <your-database-username>
    password: <your-database-password>

  jpa:
    show-sql: true
    generate-ddl: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
    hibernate:
      ddl-auto: update

server:
  port: <your-port>
```
## Running application

To run tests, run the following command

```bash
  mvn spring-boot:run
```

or

```bash
  mvn clean spring-boot:run
```

**Remark**: Please make sure your running at Demo1Application.java
## User API Reference

#### Get all users

```http
  GET /apis/v1/users
```

#### Get user by id

```http
  GET /api/user/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of user to fetch |

#### Create user

```http
  POST /api/users
```

| Request body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `first_name`      | `string` | **Required**. first name of user |
| `last_name`      | `string` | **Required**. last name of user |
| `age`      | `int` | **Required**. age of user |

#### Update user by id
```http
  PUT /api/user/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of user to fetch |

| Request body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `first_name`      | `string` | **Required**. first name of user |
| `last_name`      | `string` | **Required**. last name of user |
| `age`      | `int` | **Required**. age of user |

#### Delete user by id
```http
  DELETE /api/user/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of user to fetch |