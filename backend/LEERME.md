# Configuracion

- Descomprimir archivo .zip
- Cargar proyecto en eclipse o Netbean
-

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
