package main;

import main.Dao.RequestDao;
import main.models.Request;

public class Main {
    public static void main(String[] args) {
        Request request=new Request();
        request.setName("Ivanov");
        request.setBirthDate(1995);
        request.setGender("Male");
        RequestDao requestDao=new RequestDao();
        requestDao.createRequest(request);
    }
}
