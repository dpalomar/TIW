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
