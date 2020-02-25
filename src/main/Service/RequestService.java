package main.Service;

import main.Dao.RequestDao;
import main.models.Request;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/requests")
public class RequestService {
    private RequestDao RequestDao = new RequestDao();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Request create(Request request){
        return RequestDao.createRequest(request);
    }

    @DELETE
    @Path("/{requestId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("userId") int userId){
        return RequestDao.deleteById(userId) ? "deleted" : "not deleted";
    }
}
