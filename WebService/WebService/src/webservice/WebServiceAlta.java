package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import entities.Alta;
import entities.Cola;

@Path("datos")
public class WebServiceAlta {
	
	
	@POST
	@Consumes({"application/json"})
	@Produces({"application/json"})
	public Response altaDatos(Alta p) {

		System.out.println("Altas:" + p.toString());
		Cola.saveAlta(p);

		//Si el objeto JSON pasado se guarda para subirse, el web service retorna un OK
		if(Cola.saveAlta(p)) {			
			return Response.status(Response.Status.CREATED).entity("OK").build();
		}
		//Sino, devuelve un KO
		else {
			return Response.status(Response.Status.CONFLICT).entity("KO").build();

		}
	}

}
