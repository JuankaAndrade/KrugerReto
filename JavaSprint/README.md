# Desarrollador

Este proyecto fue desarrollado por Juan Andrade con Back END 

	Lenguaje: Java
	FrameWork: Springh Boot
	Ide: Spring Tool Suite 4
	Bdd: MySql 

# Arquitectura del Proyecto

Este proyecto es una aplicacion desarrollada en Java Sprint 

-------------------------------------------------------------------
Modulo  Aplicación Spring

	Controlladores   TextController
	Interfaces	IEmpleado
	Serivicios	IempleadoService (Servicios guardado, borrado)
	Modelos	Empleado - Employee (comuinicación) - User
	Serrivice	Empleado Service (Funciones Internas)		
 -------------------------------------------------------------------      


# Seguridades

Las comunicaciones de este proyecto estan realizadas mediante API

La estructura de seguridad que existe en el aplicativo esta en este esquema
 
|---------------------- |				
|	listarEmpleados()	|
|		Auth Básica		|
|						|
|	borrarEmpleados()	|
|		Auth Básica		|
|						|	----------------->	Spring Boot + Implementación (Basic Authentication)
|	crearEmpleados()	|
|		Auth Básica		|
|						|
|-----------------------|
|	Servicio de Auth	|
|	Autentificar()		|
|		Auth Básica		|
|-----------------------|

## Credenciales

	Las credenciales para poder recibir autorización de conexion del API estan en el SecurityConfig y son
	Usuario: user
	Password: password
	
	El token generado se encuentra almacenado dentro del proyecto

## Base de Datos

La base de datos se encuentra dentro del proyecto como empleado.sql



