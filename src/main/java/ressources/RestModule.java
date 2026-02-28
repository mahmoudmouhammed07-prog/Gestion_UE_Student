package ressources;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/module")
public class RestModule {

    ModuleBusiness MB = new ModuleBusiness();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    public Response createModule(Module module) {

        if (MB.addModule(module)) {
            return Response.status(Response.Status.CREATED).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Module> getAllModules() {

        return MB.getAllModules();
    }
}