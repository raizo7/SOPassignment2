package microservice65;

import java.io.IOException;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/Students")
public class ServiceEndpoints {
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(RegisterRequest c) throws IOException{
		Microservice65Service microservice65Service = new Microservice65Service();
		return microservice65Service.register(c);
	}
	
	@POST
	@Path("/enrol")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response enrol(ModuleRequest c) throws IOException{
		Microservice65Service microservice65Service = new Microservice65Service();
		return microservice65Service.enrol(c);
	}
	
	
}