# rest-app-client

A Microservice with Spring Boot Declarative REST Client, Eureka and OpenFeign.

This is a distributed microservices, and only for db operations from other front end react application along with micrservice model.

# DB Model(ERD) :

Example considered to build a application for a college with below use cases

1. Many departments which can offer any number of courses. -> <b> OneToMany </b>
2. Many instructors can work in a department and an instructor can work only in one department. For each department there is a Head. -> <b> ManyToOne </b>
3. An instructor can be head of only one department. <b> OneToOne </b>
4. Each instructor can take any number of courses, but course can be taken by only one instructor. <b> ManyToOne </b>
5. A student can enrol for any number of courses and each course can have any number of students. <b> ManyToMany </b>

*** We can see all the above definitions in real time Please gothrouhg below link ***
<a href="https://github.com/rmanda90/rest-app-client/tree/master/src/main/java/com/mpk/samples/restappclient/entity" target="_blank> ERD Implimentation </a>
