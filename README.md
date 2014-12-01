TIW
===

Proyectos demo de la asignatura Tecnologías de Internet para la web

### DemoTIW
* Este proyecto muestra ejemplos de uso de los servlets y JPA incluidos en el mismo proyecto y empaquetados en un solo _war_.
* Tambien muestra el uso distintos _scopes_: request, session, contexto, etc. Asi como configuracion via web.xml y uso de _RequestDispatcher_
* Acceso tras el despliegue: http://localhost:8080/demoTIW/


### PruebaEAR

Conjunto de proyectos empaquetados en un _EAR_ y con especificacion **JEE 6** (Servlet 3.0 y JPA 2.0), contiene:

* 2 proyectos web (_prueba_ y _pruebaweb2_)
* 1 proyecto JPA empaquetado como proyecto de utilidad: _pruebaJPA_
* Toda la configuracion se hace por anotaciones estilo **servlet 3.0** sin web.xml
* Acceso tras el despliegue: http://localhost:8080/prueba/
