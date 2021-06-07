package Controller;

import service.OrderService;
import service.TimeSlotService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "AdminChangeTimeSlotServlet", value = "/AdminChangeTimeSlot-Servlet")
public class AdminChangeTimeSlotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        int roleid = (int) session.getAttribute("roleid");
        if (roleid == 3) {
            request.getRequestDispatcher("adminchangetimeslot.jsp").forward(request, response);
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
                request.getRequestDispatcher("adminchangetimeslot.jsp").forward(request, response);
                return;
            }
        }
        if (datefromJSP.isEmpty() && timeslotid == null) {
            String message = "Оберіть будь-ласка дату";
            request.setAttribute("message", message);
            request.getRequestDispatcher("adminchangetimeslot.jsp").forward(request, response);
        }
        if (!datefromJSP.isEmpty()) {
            TimeSlotService timeSlotService = new TimeSlotService();
            Date date = ClientChoseTimeSlotServlet.pareStringToDate(datefromJSP);
            String OrderId = (String) session.getAttribute("orderId");
            int id = Integer.parseInt(OrderId);
            int masterId = 0;
            UserService userService = new UserService();
            try {
                masterId = userService.getGetMasterIdByOrderId(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                request.setAttribute("timeslots", timeSlotService.getTimeSlotsForMaster(masterId, date));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(" date = " + date);
            session.setAttribute("masterId", masterId);
            session.setAttribute("date", date);
            request.getRequestDispatcher("adminchangetimeslot.jsp").forward(request, response);
        }

        if (timeslotid != null) {
            OrderService orderService = new OrderService();
            Date date = (java.sql.Date) session.getAttribute("date");
            String OrderId = (String) session.getAttribute("orderId");
            int orderIdInt = Integer.parseInt(OrderId);
            int timeSlotIdInt = Integer.parseInt(timeslotid);
            try {
                orderService.updateOrderTimeslotById(orderIdInt, timeSlotIdInt, date);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Змінити таймслот на цю дату = " + date + " на цей timeslotid = " + timeslotid + "це замволення oderId = " + orderIdInt);
            response.sendRedirect("AdminActiveOrders-Servlet");
        }
    }
}
