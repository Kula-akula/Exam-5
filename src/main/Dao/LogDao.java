package main.Dao;

import main.models.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDao {


    public List<Log> getLogs() {
        List<Log> requests = new ArrayList<>();
        String SQL = "select * from logs";
        try (Connection connection = DB.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SQL)) {
            while(rs.next()) {
                requests.add(Log.builder()
                        .name(rs.getString("NAME"))
                        .birthDate(rs.getInt("BIRTH_DATE"))
                        .gender(rs.getString("GENDER"))
                        .createdDate(rs.getTimestamp("CREATED_DATE"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public Log getLogById(int id) {
        String SQL = "select * from logs where id = ?";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()){
                if (rs.next()) {
                    return Log.builder()
                            .name(rs.getString("NAME"))
                            .birthDate(rs.getInt("BIRTH_DATE"))
                            .gender(rs.getString("GENDER"))
                            .createdDate(rs.getTimestamp("CREATED_DATE"))
                            .build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Log createLog(Log log) {
        String SQL = "insert into logs (name, birth_date, gender,created_date) values (?,?,?,now())";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, log.getName());
            statement.setInt(2, log.getBirthDate());
            statement.setString(3, log.getGender());
//            int affectedRows=statement.executeUpdate();
//            if (affectedRows==1){
//                try(ResultSet rs=statement.getGeneratedKeys()){
//                    if (rs.next()){
//                        System.out.println("Serial number of created log is "+rs.getInt(1));
//                    }
//                }
//            }
            statement.executeUpdate();
            return log;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteById(int id) {
        String SQL = "delete from logs where id=?";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
