# Movies API

Microservicio de pruebas que consume la API de Open Movie Database.

Utiliza:
* Maven
* Java 11
* Spring Boot 2
* Jasypt 2
* JUnit 5
* Cucumber 5
* ArchUnit

## Ejecución:

`./mvnw -Dpassword=<jasypt.encryption.password> spring-boot:run`

Jasypt es usado para encriptar la llave de OMDb API. Dicha encriptación se realizó como sigue: `java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.3/jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="<LLAVE_OMDB>" password=<jasypt.encryption.password> algorithm=PBEWithMD5AndDES`


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

## Ejecución SonarQube

```
./mvnw -Dpassword=<jasypt.encryption.password> clean package
./mvnw -Dpassword=<jasypt.encryption.password> sonar:sonar
```

Se asume que se tiene una instancia local de Sonar con la configuración por defecto.

## Ejecución PITest

```
./mvnw -Dpassword=<jasypt.encryption.password> clean package
```

PITest generará un reporte cuando se ejecuta la fase *Test* de Maven.

Ruta: springboot-movies/target/pit-reports/
