# SpringBootDemo

Simple demonstration of spring boot micro service architecture and implementation.

I added the simple code first to demonstrate how I code spring-boot domain driven design micro services, then started adding features to demonstrate security, testing, liquibase and how it helps with developemnt and testing. My goal was to have a fully functional docker setup you could run that would have sqlServer, Rabbit, and the base configuration for each. I ran out of time on those efforts. Due to time constraints I went ahead and pushed up what I have as a coding exercise. 

This includes: 
 - Spring boot application with rest controllers
 - Core module encapsulating the service level code, object mappers, entities, and repositories for DB interaction.
 - Model module encapsulating the DTOs and Feign clients other applications would need for calling these endpoints in the API module.
 - Liquibase artifacts to build domains by schema (this requires some docker work for sqlServer)

This does not include:
 - Completed Auth implementation
 - More complex processing in the service layer
 - Unit tests
 - Completed Docker setup
 - Miro of the simple design provided

I need a good demo project in general, most of the projects on here are going on 10 years old. 
I will evolve this project to include the more advanced feature demonstration as time allows. 


