# Desarrollador

Este proyecto fue desarrollado por Juan Andrade con Back END 

	Lenguaje: Java
	FrameWork: Springh Boot
	Ide: Spring Tool Suite 4
	Bdd: MySql 

# Arquitectura del Proyecto

Este proyecto es una aplicacion desarrollada en Java Sprint 

-------------------------------------------------------------------
Modulo  Aplicaci�n Spring

	Controlladores   TextController
	Interfaces	IEmpleado
	Serivicios	IempleadoService (Servicios guardado, borrado)
	Modelos	Empleado - Employee (comuinicaci�n) - User
	Serrivice	Empleado Service (Funciones Internas)		
 -------------------------------------------------------------------      


# Seguridades

Las comunicaciones de este proyecto estan realizadas mediante API

La estructura de seguridad que existe en el aplicativo esta en este esquema
 
|---------------------- |				
|	listarEmpleados()	|
|		Auth B�sica		|
|						|
|	borrarEmpleados()	|
|		Auth B�sica		|
|						|	----------------->	Spring Boot + Implementaci�n (Basic Authentication)
|	crearEmpleados()	|
|		Auth B�sica		|
|						|
|-----------------------|
|	Servicio de Auth	|
|	Autentificar()		|
|		Auth B�sica		|
|-----------------------|

## Credenciales

	Las credenciales para poder recibir autorizaci�n de conexion del API estan en el SecurityConfig y son
	Usuario: user
	Password: password
	
	El token generado se encuentra almacenado dentro del proyecto

## Base de Datos

La base de datos se encuentra dentro del proyecto como empleado.sql



