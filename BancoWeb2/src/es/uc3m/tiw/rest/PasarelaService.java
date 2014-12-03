package es.uc3m.tiw.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.uc3m.tiw.dominios.Usuario;
/**
 * La url de acceso sera: 
 * Para getText() -- http://localhost:8080/resources/generic/prueba 
 * Para getDatos() -- http://localhost:8080/resources/generic/prueba/23/david 

 * @author David Palomar
 *
 */
@Path("pasarela")
public class PasarelaService {
    
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public PasarelaService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Se invoca por GET la URL: http://localhost:8080/BancoWeb2/resources/pasarela/prueba
     * y devuelve "Todo OK"
     * @return Todo OK
     */
    @GET
    @Path("prueba")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        return "Todo OK";
    }
    /**
     * Ejemplo en el que se pasan los datos por GET y {@link PathParam}.
     * el primer parametro se convierte automaticamente a Integer 
     * a pesar de venir siempre en formato String mediante HTTP.
     * La URL sera: http://localhost:8080/BancoWeb2/resources/pasarela/prueba/10/hola
     * @param numero
     * @param palabra
     * @return  mensaje con los datos introducidos
     */
    @GET
    @Path("prueba/{numero}/{palabra}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDatos(@PathParam("numero")Integer numero,@PathParam("palabra")String palabra) {
        
        return "Los datos introducidos son: numero="+numero+" palabra= "+palabra;
    }
    /**
     * Ejemplo de uso de QUERY-STRING.
     * La url sera: http://localhost:8080/BancoWeb2/resources/pasarela/prueba/query?numero=10&palabra=hola
     * @param numero
     * @param palabra
     * @return mensaje con los datos introducidos
     */
    @GET
    @Path("prueba/query")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDatosPorQueryString(@QueryParam(value="numero") Integer numero,@QueryParam(value = "palabra") String palabra){
    	 return "Los datos introducidos por query-string son: numero="+numero+" palabra= "+palabra;
    }
    
    /**
     * Ejemplo en el que se accede por POST y se consume texto plano pero se devuelve un objeto {@link Usuario}
     * que es convertido a XML
     * La URL es: http://localhost:8080/BancoWeb2/resources/pasarela/usuario/10/david/xml
     * @param edad
     * @param nombre
     * @return documento XML del usuario
     */
    @POST
    @Path("usuario/{edad}/{nombre}/xml")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_XML)
    public Usuario devuelveXML(@PathParam("edad")Integer edad,@PathParam("nombre") String nombre){
    	return new Usuario(edad,nombre);
    }
    /**
     * Ejemplo en el que se accede por POST mediante un formulario pero se devuelve un objeto {@link Usuario}
     * que es convertido a JSON
     * La URL es: http://localhost:8080/BancoWeb2/resources/pasarela/usuario/10/david/json
     * @param edad
     * @param nombre
     * @return documento JSON del usuario
     */
    @POST
    @Path("usuario/{edad}/{nombre}/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario devuelveJSON(@PathParam("edad")Integer edad,@PathParam("nombre") String nombre){
    	return new Usuario(edad,nombre);
    }

}