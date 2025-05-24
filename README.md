# Bicycle Management

## Project Intention

Project created to study System Design, Domain Driven Design and testing with the Spring Boot framework.

Since this is a study project, I made the following exceptions to the rationale of layers in the project structure in
the context of applying DDD:

- In the domain layer, I allow the use of `org.springframework.data.domain.PageRequest` and
  `org.springframework.data.domain.Page`. They are useful for defining paginated queries to repositories, which is a
  common pattern.
- Throughout the project, I use annotations from the `org.springframework.stereotype` package. They help reduce the
  number of configuration classes.

## The challenge

The challenge (challenge.txt) was created by AI (ChatGPT). The prompt was "create a backend software engineering
challenge aimed at system design with advanced topics".