TIW
===

Proyectos demo de la asignatura Tecnologías de Internet para la web

## Parte EJB

1. Añadido proyecto **pruebaEJB** y **pruebaEJBClient**.
2. Es un servicio que permite acceder a los DAOs JPA creados anteriormente y recibir datos de un servlet para guardar y actualizar  **usuarios**

## Parte JMS

1. Añadida clase **EscribeEnQueue** en el proyecto web _prueba_. Esta clase recibe un objeto _Direccion_ por parte del servlet y envia dicho objeto a una cola definida previamente en el servidor.
2. Añadida clase **PruebaMDB** en el proyecto _pruebaweb2_. Esta clase implementa el interfaz _MessageListener_ y escucha la llegada de nuevos objetos a la cola del servidor, cuando recibe un objeto direccion busca un objeto _usuario_ en la base de datos con el servicio _EJB_ creado anteriormente,  le une la _direccion_ y vuelve a usar el servicio para actualizar el usuario en la base de datos.

**NOTAS:** 
* El _MDB_ no debe llevar slash "/" en la propiedad _destination_
* Todos los dominios deben implementar el interfaz _Serializable_ que pertenece al paquete _java.io_
* El **connectionFactory** del servidor se llama **jms/_tiwConnectionFactory**
* La cola en el servidor se llama **jms/pedido**
* Para que funcione correctamente la clase _EscribeEnQueue_ es necesario usar _CDI_ y por lo tanto incluir un fichero **beans.xml** vacio en el directorio **WEB-INF**

## Parte RESTFul

1. añadidos proyectos **BancoEAR** y **BancoWeb**
2. **NOTA:** a la hora de crear el proyecto con eclipse **NO** usar las plantillas de Glassfish, usar las genericas de eclipse.
3. Es mejor usar un _proyecto web dinamico_ y posteriormente añadirle los facets de RESTFul
4. **NOTA II:** Tras crear el proyecto _REST_ es necesario cambiar en el **web.xml** el servlet propuesto por este otro:

		org.glassfish.jersey.servlet.ServletContainer

URLs de acceso tras el despliegue:

* Para getText() -- [http://localhost:8080/BancoWeb2/resources/pasarela/](http://localhost:8080/BancoWeb2/resources/pasarela/ )
* Para getDatos() -- [http://localhost:8080/BancoWeb2/resources/pasarela/23/palabra](http://localhost:8080/BancoWeb2/resources/pasarela/23/palabra)  
* **NOTA:** Para el resto de URLs mirar el codigo de la clase _PasarelaService_