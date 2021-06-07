package Controller;

import entity.Order;
import entity.User;
import service.OrderService;
import service.TimeSlotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ClientChoseTimeSlotServlet", value = "/ClientChoseTimeSlot-Servlet")
public class ClientChoseTimeSlotServlet extends HttpServlet {

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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        int roleid = (Integer) session.getAttribute("roleid");


        if (roleid == 2) {
            request.getRequestDispatcher("clientchosetimeslot.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        String timeslotid = request.getParameter("timeslotid");
        String datefromJSP = request.getParameter("date");
        String masteridfromJSP = (String) session.getAttribute("masterid");
        int masterid = Integer.parseInt(masteridfromJSP);


        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
            return;
        }
        if (!datefromJSP.isEmpty()) {
            java.sql.Date sqlDate = ClientChoseTimeSlotServlet.pareStringToDate(datefromJSP);
            java.util.Date date = new java.util.Date();
            java.sql.Date nowDate = new java.sql.Date(date.getTime());
            if (!sqlDate.after(nowDate) && !sqlDate.toString().equals(nowDate.toString())) {
                String message = "Оберіть будь-ласка сьогднішню або майбутню дату";
                request.setAttribute("message", message);
                request.getRequestDispatcher("clientchosetimeslot.jsp").forward(request, response);
                return;
            }
        }
        if (!datefromJSP.isEmpty()) {
            TimeSlotService timeSlotService = new TimeSlotService();
            Date date = ClientChoseTimeSlotServlet.pareStringToDate(datefromJSP);
            System.out.println(date);
            try {
                request.setAttribute("timeslots", timeSlotService.getTimeSlotsForMaster(masterid, date));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("masterid = " + masterid + " date = " + date);
            session.setAttribute("date", date);
            request.getRequestDispatcher("clientchosetimeslot.jsp").forward(request, response);
        }

        if (datefromJSP.isEmpty() && timeslotid == null) {
            String message = "Оберіть будь-ласка дату";
            request.setAttribute("message", message);
            request.getRequestDispatcher("clientchosetimeslot.jsp").forward(request, response);
        }

        if (timeslotid != null) {
            String datefromJSP1 = request.getParameter("date");
            System.out.println(datefromJSP1);
            User user = (User) session.getAttribute("user");
            int clientid = user.getId();

            int timeslotid1 = Integer.parseInt(timeslotid);
            java.sql.Date date1 = (java.sql.Date) session.getAttribute("date");
            int serviceid = (int) session.getAttribute("serviceid");
            int orderstatusid = 1;
            System.out.println("clientid : " + clientid + " masterdid : " + masterid + " timeslotid : " + timeslotid1 + " date : " + date1
                    + " serviceid : " + serviceid + " orderstatus : " + orderstatusid);

            Order order = new Order();
            order.setClientId(user.getId());
            order.setMasterId(masterid);
            order.setTimeSlotId(timeslotid1);
            order.setDate(date1);
            order.setServiceId(serviceid);
            order.setOrderStatusId(orderstatusid);
            OrderService orderService = new OrderService();
            try {
                orderService.addOrder(order);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            String message = "Ви успішно записались на послугу";
            request.setAttribute("message", message);
            request.getRequestDispatcher("clientcabinet.jsp").forward(request, response);

        }


    }
}

