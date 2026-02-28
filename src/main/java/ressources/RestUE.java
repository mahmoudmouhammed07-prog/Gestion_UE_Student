package ressources;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/UE")
public class RestUE {

    UniteEnseignementBusiness UEB = new UniteEnseignementBusiness();

    // 🔹 POST
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUE(UniteEnseignement ue) {

        if (UEB.addUniteEnseignement(ue)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // 🔹 GET
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<UniteEnseignement> getAll() {
        return UEB.getAll();
    }
}