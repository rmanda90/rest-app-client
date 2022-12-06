# rest-app-client

A Microservice with Spring Boot Declarative REST Client, Eureka and OpenFeign.

This is a distributed microservices, and only for db operations from other front end react application along with micrservice model.

## DB Model(ERD) :

Example considered to build a application for a college with below use cases

1. Many departments which can offer any number of courses. -> <b> OneToMany </b>
2. Many instructors can work in a department and an instructor can work only in one department. For each department there is a Head. -> <b> ManyToOne </b>
3. An instructor can be head of only one department. <b> OneToOne </b>
4. Each instructor can take any number of courses, but course can be taken by only one instructor. <b> ManyToOne </b>
5. A student can enrol for any number of courses and each course can have any number of students. <b> ManyToMany </b>

### <b> We can see all the above definitions in real time Please go through below link</b>
## <a href="https://github.com/rmanda90/rest-app-client/tree/master/src/main/java/com/mpk/samples/restappclient/entity">Visit ERD Entities!</a>

### This rest-app-client is communicating with other microservices programs used are these:

1. Project: <a href="https://github.com/rmanda90/stub-runner">stub-runner  - Eureka Client</a> on port 8091
   - This is a microservice that is running on port 8091 and exposed as eureka client and connecting using with feign client.
   - The purpose of this service is to load our newly created tables with some random data with proper relations in mind.
   - Run this application it will automatically register in eureka server.
   - to use this with rest-app-client http://localhost:8093/mock <b>/mock</b> is the end point it will take you to this service.

2. Project: <a href="https://github.com/rmanda90/discovery-server">discovery-server - Eureka Server</a> on Port: 8761