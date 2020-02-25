package main.Service;

import main.Dao.RequestDao;
import main.models.Request;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/requests")
public class RequestService {
    private RequestDao RequestDao = new RequestDao();
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Request> getAllUsers_Json() {
//        return RequestDao.getUsers();
//    }
//    @GET
//    @Path("/{userId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public User getUser(@PathParam("userId") Integer userId) {
//        return RequestDao.getUserById(userId);
//    }

//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public Request updateUser(User user){
//        return RequestDao.updateUser(user);
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Request create(Request request){
        return RequestDao.createRequest(request);
    }

//    @DELETE
//    @Path("/{userId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String delete(@PathParam("userId") int userId){
//        return RequestDao.deleteById(userId) ? "deleted" : "not deleted";
//    }
}
