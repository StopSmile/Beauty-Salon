package db;

import entity.Service;
import entity.TimeSlot;
import entity.User;
import service.ServiceService;
import service.TimeSlotService;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {


//        ServiceService serviceService = new ServiceService();
//        List<Service>serviceList = serviceService.getMasterInfo("Jane");
//        for (Service x:serviceList) {
//            System.out.println(x);
//        }
        TimeSlotService timeSlotService = new TimeSlotService();

        List<TimeSlot> timeSlots = timeSlotService.getTimeSlots();
        for (TimeSlot x:timeSlots) {
            System.out.println(x);
        }



//        UserService userService = new UserService();
//        List<User> userList = userService.getMaster("Anna");
//        for (User x : userList) {
//            System.out.println(x);
//        }

//        UserService userService = new UserService();
//        String checkLogin = userService.checkLogin("StopSmile");
//        String checkLogin2 = userService.checkLogin("StopSmile2");
//        String checkEmail = userService.checkEmail("stopsmile1@gmail.com");
//        String checkEmail2 = userService.checkEmail("stopsmile2@gmail2.com");
//        System.out.println(checkLogin);
//        System.out.println(checkLogin2);
//        System.out.println(checkEmail);
//        System.out.println(checkEmail2);
//        User user = userService.getByLogin("123");
//        System.out.println(user);
//        System.out.println(userService.checkLogin("StopSmile"));
//        String str = userService.checkLogin("123");
//        System.out.println(str);
//        String str2 = userService.checkLogin("StopSmile");
//        System.out.println(str2);
//        User user = userService.getByLogin("StopSmiles");
        //System.out.println(user.getLogin() + " " + user.getLogin());
//        if (user == null){
//            System.out.println("Вільний логін");
//        }
//        if (user != null){
//            System.out.println("Цей емейл зайнятий " + user.getEmail());
//        }
//        System.out.println(user);
//        if (user == null){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }
//
//        DBManager dbManager = DBManager.getInstance();
//        dbManager.getConnection();
//        dbManager.insertUser(user);
    }
}
