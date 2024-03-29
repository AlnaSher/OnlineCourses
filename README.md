<h1> Platform for online courses </h1>
<h1> Description</h1>
  This project provides information about online courses and their lessons for users.
<h1> Sonarcloud </h1>

You can evaluate the quality of the code 
[here](https://sonarcloud.io/summary/overall?id=AlnaSher_OnlineCourses).
  
<h1> Used technologies: </h1>
<li>Maven</li>
<li>Java 17</li>
<li>Spring Boot 3.2.3</li>
<li>PostgreSQL</li>
<h1> Installation and use </h1>

  1. Clone the repository.
  2. Connect to a database.
  3. Configure the `application.properties` as shown below
     ```
      spring.datasource.url=jdbc:postgresql://localhost:5432/CoursesDB
      spring.datasource.username=postgres
      spring.datasource.password=ggggg
      spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.open-in-view=false
     ```
  5. Run the application.
  6. Make a request.
<h1>Example of response</h1>

**Request**

`localhost:8080/api/v1/user/find/{id}`

**JSON response**

```
{
    "id": "1234",
    "name": "Helen"
}
```
