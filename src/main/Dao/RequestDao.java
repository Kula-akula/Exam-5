package main.Dao;

import main.models.Log;
import main.models.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDao {
    public Request createRequest(Request request) {
        LogDao logDao=new LogDao();
        Log log=new Log();
        String SQL = "insert into requests (name, birth_date, gender) values (?,?,?)";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, request.getName());
            statement.setInt(2, request.getBirthDate());
            statement.setString(3, request.getGender());
//            int affectedRows=statement.executeUpdate();
//            if (affectedRows==1){
//                try(ResultSet rs=statement.getGeneratedKeys()){
//                    if (rs.next()){
//                        System.out.println("Serial number of created log is "+rs.getInt(1));
//                    }
//                }
//            }

            statement.executeUpdate();
            return request;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.setName(request.getName());
        log.setBirthDate(request.getBirthDate());
        log.setGender(request.getGender());
        logDao.createLog(log);
        return null;
    }

}
