package Controller;

import service.TimeSlotService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ClientChoseTimeSlotServlet", value = "/ClientChoseTimeSlot-Servlet")
public class ClientChoseTimeSlotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        if (id == null) {
            response.sendRedirect("bootstrapcabinet-servlet");
        } else {
            TimeSlotService timeSlotService = new TimeSlotService();
            try {
                request.setAttribute("timeslots",timeSlotService.getTimeSlots());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("clientchosetimeslot.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
