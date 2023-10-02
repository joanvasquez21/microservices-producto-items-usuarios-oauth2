# Implementando Oauth2
Primeros pasos: 
1.- Agregamos la dependencia de Oauth2
```<dependency>
		<groupId>org.springframework.security.oauth</groupId>
			<artifactId>spring-security-oauth2</artifactId>
			<version>2.3.8.RELEASE</version>
		</dependency>```
Trabajamos con la version 2.4.13
```<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
       <version>2.4.13</version>
		<relativePath /> 
	</parent>```
En nuestro proyecto agregamos un nuevo paquete llamado "springboot-servicio-oauth"
y creamos la clase "AuthorizationServerConfig" extendiendose de "AuthorizationServerConfigurerAdapter"
La clase AuthorizationServerConfigurerAdapter tenemos que anotarle con  @Configuration y @EnableAutoConfiguration
# Para que se utiliza: esta clase se utiliza cuando estamos implementando un servidor de autorizacion Oauth2.
# Se encarga de: configurar la auntenticacion y la emision de tokens de accesos para que los clientes puedan acceder a recursos protegidos.

![image](https://github.com/joanvasquez21/microservices-producto-items-usuarios-oauth2/assets/70104624/3bdd5980-ca32-4b8e-939a-e6846a95d288)
