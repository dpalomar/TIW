package es.uc3m.tiw.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/**
 * La url de acceso sera: 
 * Para getText() -- http://localhost:8080/resources/generic/prueba 
 * Para getDatos() -- http://localhost:8080/resources/generic/prueba/23/david 

 * @author David Palomar
 *
 */
@Path("generic")
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
     * Retrieves representation of an instance of PasarelaService
     * @return an instance of String
     */
    @GET
    @Path("prueba")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        return "Todo OK";
    }
    @GET
    @Path("prueba/{numero}/{palabra}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDatos(@PathParam("numero")Integer numero,@PathParam("palabra")String palabra) {
        
        return "Los datos introducidos son: numero="+numero+" palabra= "+palabra;
    }
    /**
     * PUT method for updating or creating an instance of PasarelaService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }

}