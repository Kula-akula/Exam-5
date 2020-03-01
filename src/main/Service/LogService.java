package main.Service;

import main.Dao.LogDao;
import main.models.Log;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/logs")
public class LogService {
    private LogDao logDao = new LogDao();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Log> getAllUsers_Json() {
        return logDao.getLogs();
    }
//    @GET
//    @Path("/{userId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Log getLogById (@PathParam("logId") Integer userId) {
//        return logDao.getUserById(userId);
//    }

//    @PUT
//    @Produces(MediaType.APPLICATION_JSON)
//    public User updateUser(User user){
//        return logDao.updateUser(user);
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Log create(Log log){
        return logDao.createLog(log);
    }

    @DELETE
    @Path("/{logId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("logId") int userId){
        return logDao.deleteById(userId) ? "deleted" : "not deleted";
    }
}
