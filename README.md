# Movies API

Microservicio de pruebas que consume la API de Open Movie Database.

Utiliza:
* Maven
* Java 11
* Spring Boot 2
* Jasypt 2
* JUnit 5
* Cucumber 5

## Ejecución:

`./mvnw -Dpassword=<jasypt.encryption.password> spring-boot:run`



## JUnit 5

```
JUnit 5 = JUnit Platform (La base para ejecutar los tests) +
          JUnit Jupiter (Combinación de un nuevo modelo de programación y extensión) +
          JUnit Vintage (Soporte JUnit 4)
```          
Platform y Jupiter vienen incluídos en *spring-boot-starter-test*

## Ejecución de los tests:
 
`./mvnw -Dpassword=<jasypt.encryption.password> test`
 
Si se desea realizar *debug* de los test (unitarios o de integración):

`./mvnw -Dpassword=<jasypt.encryption.password>  -Dmaven.surefire.debug test`

Luego en el IDE *escuchar* el puerto 5005. En IntelliJ: Edit Configurations -> + -> Remote -> Ok.
