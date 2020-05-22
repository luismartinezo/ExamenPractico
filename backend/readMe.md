# Configuracion

## Backend

Existe dos metodos para la ejecucion del servidor Backend en Spring Boot, pero en este caso se correra con el IDE Eclipse.

- En Eclipse importar el proyecto SpringBoot que se encuentra dentro de la ruta `/examenPractico/backend/`
- Click derecho sobre el proyecto y vamos a `Gradle -> Refresh Gradle Project` para descargar las dependencias que contiene el proyecto.
- Click derecho sobre el proyecto y vamos a `Run As -> 3 Spring Boot App` este correra el server en la ruta `http://localhost:8080`

## Estructura de Carpetas

![scaffolding](https://github.com/luismartinezo/examenPractico/blob/master/backend/src/main/resources/assets/img/back.png?raw=true)

### Archivo application.properties

Es necesario cnfigurar algunos parametros en este archivo para la conexion a la base de datos tales como:

- spring.datasource.url=jdbc:sqlserver://´NOMBREHOST´;databaseName=mandomedio
- spring.datasource.username=usuario
- spring.datasource.password=contraseña

Nota: En caso de tener inconvenientes con la conexion a la base de datos y se visualiza el siguiente error:
´com.microsoft.sqlserver.jdbc.SQLServerException: The TCP/IP connection to the host localhost, port 1433 has failed.
Error: Connection refused: connect. Verify the connection properties,
check that an instance of SQL Server is running on the host and accepting TCP/IP connections at the port,
and that no firewall is blocking TCP connections to the port.´
[Consultar el siguiente enlace](https://dzone.com/articles/configuring-spring-boot-for-microsoft-sql-server)
