# Spring Security

Topics:

1. Introduction to Spring Security
    - What is Spring Security?
    - Why is it important?
    - Key features and benefits
2. Authentication in Spring Security
    - User authentication concepts
    - Configuring authentication providers
    - Password encoding and hashing
    - Custom authentication logic
3. Authorization in Spring Security
    - Role-based access control
    - Method-level security
    - Expression-based access control
    - Custom authorization logic
4. Web Security in Spring Security
    - Securing web endpoints
    - Form-based authentication
    - Remember me authentication
    - CSRF protection
5. OAuth 2.0 with Spring Security
    - Introduction to OAuth 2.0
    - Configuring OAuth 2.0 clients and providers
    - Implementing secure API endpoints using OAuth 2.0
6. Advanced Topics
    - Single Sign-On (SSO)
    - Remember me functionality
    - Session management and concurrency control
    - Security best practices and common pitfalls
7. Hands-on Exercises and Demos
    - Walkthrough of sample applications
    - Implementing authentication and authorization
    - Securing REST APIs with OAuth 2.0
8. Q&A and Discussion
    - Open forum for questions and clarifications
    - Discussion on real-world use cases and challenges
  
Current status:

  - Spring Boot 3.x
  - Spring Security 6.2.1
  - HTTP Authorization implementation in place (.anyRequest().permitAll())
  - org.h2.Driver
  - data.sql & schema.sql
  - TODO: Data creation issues (temp workaround = DataInitializer)
  - ChuckNorrisControllerWebMvcTest gives isUnauthorized
  - ChuckNorrisControllerMvcTest gives 404 ?!
