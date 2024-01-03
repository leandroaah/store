# SpringBoot-BDD-Java
# Objective :
Developed a simple aplication which provides an end point rest of consultation such that:
Accept as input parameters: date, product identifier, brand identifier.
Return as output data: product identifier, brand identifier, price list, application dates and final price to be applied.

# Tools / libraries used :

1. Java
2. Spring Boot
3. Cucumber
4. Lombok
5. Mapstruct
6. H2Database
7. Swagger


# Steps to start :

1. Clone / Download the project into your local
2. Open the Command prompt and navigat to project location
3. Execute the following Maven command's
    - mvn clean :- To clean the maven repo
    - mvn compile :- To compile project
    - mvnw spring-boot:run:- To deploy app in local
4. (Optional) Search and run (src.test.minsa.test.store)StoreApplicationTests class :- To execute cucumber test


# Examples request to end point :

   - import postman collection: store_collection.json
   - curl 'http://localhost:8080/api/store/price?date=2020-06-14T09:00:00&productId=35455&brandId=1'
   - curl 'http://localhost:8080/api/store/price?date=2020-06-14T15:00:00&productId=35455&brandId=1'
   - curl 'http://localhost:8080/api/store/price?date=2020-06-15T05:00:00&productId=35455&brandId=1'
   - Swagger: http://localhost:8080/swagger-ui/index.html