# Search-Facade

Technologies being used :
Spring Boot, Spring Data Mongo, Embedded MongoDB , Maven.

--------------------------------------------------------------------------------------------------------------------------
 
Functionalities Implemented:
 
Dynamic Filter functionality is implemented using MongoTemplate.
 
--------------------------------------------------------------------------------------------------------------------------
 
How to Use the application:
Once the Spring boot application is started, go to postman and provide this get request http://localhost:6868/events/search/.
You will get all the records from mongoDB.
If you apply the filter which can be sent as request param to the rest controller, you will get the filtered results.
As of now only two filters have  implemented. Please find the below sample request.

localhost:6868/events/search?
                                                 filter1={ "attribute": "type", "operator": "eq", "value": "LOGIN" }"&
                                                 filter2={ "attribute": "user", "operator": "eq", "value": "user1@sample.io" }"
