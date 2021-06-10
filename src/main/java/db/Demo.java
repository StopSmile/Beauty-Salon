package db;


import service.OrderService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Demo {

    public static Date pareStringToDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sql = null;
        try {
            java.util.Date parsed = format.parse(date);
            sql = new java.sql.Date(parsed.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public static void main(String[] args) throws SQLException, IOException, InterruptedException, ParseException {

//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                EmailSender.sendEmail("stopsmile2@gmail.com");
//            }
//        };
//        timer.schedule(timerTask,3000);
//        OrderService orderService = new OrderService();
//       String email = orderService.getEmailByOrderId(55);
//       System.out.println(email);

    }
}







//        Properties properties = System.getProperties();
//        properties.setProperty("smtp.gmail.com", host);
//
//        Session session = Session.getDefaultInstance(properties); // default session
//
//        try {
//            MimeMessage message = new MimeMessage(session); // email message
//
//            message.setFrom(new InternetAddress(from)); // setting header fields
//
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            message.setSubject("Test Mail from Java Program"); // subject line
//
//            // actual mail body
//            message.setText("You can send mail from Java program by using mail API, but you need" +
//                    "couple of more JAR files e.g. smtp.jar and activation.jar");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("Email Sent successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }


//        UserService userService = new UserService();
//        int masterId = userService.getGetMasterIdByOrderId(33);
//        System.out.println(masterId);
//
//
//        OrderService orderService = new OrderService();
//        List<OrdersForMaster> list = orderService.getAllOrdersForPagination(20,0);
//
//        for (OrdersForMaster x: list){
//            System.out.println(x + "chek new git");
//        }

//        java.sql.Date sqlDate = ClientChoseTimeSlotServlet.pareStringToDate("2021-06-07");
//
//        java.util.Date date = new java.util.Date();
//        java.sql.Date nowDate = new java.sql.Date(date.getTime());
//        System.out.println("Прийшла ця дата = " +sqlDate + " А це сьогоднішня дата = " + nowDate);
//        System.out.println(sqlDate.after(nowDate));
//        System.out.println(date);
//        if (sqlDate.before(nowDate)){
//            System.out.println("before");
//        }
//        if (sqlDate.after(nowDate)){
//            System.out.println("after");
//        }
//        System.out.println(sqlDate.compareTo(nowDate));


//        OrderService orderService = new OrderService();
//        List<Order> list = orderService.getOrdersByMasterAndActiveStatus(3,1);
//
//        for (Order x:list){
//            System.out.println(x);
//        }
//        ServiceService serviceService = new ServiceService();
//        List<Service>serviceList = serviceService.getMasterInfo("Jane");
//        for (Service x:serviceList) {
//            System.out.println(x);
//        }
//        TimeSlotService timeSlotService = new TimeSlotService();
//
//        List<TimeSlot> timeSlots = timeSlotService.getTimeSlots();
//        for (TimeSlot x:timeSlots) {
//            System.out.println(x);
//        }


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
//    }
//}
