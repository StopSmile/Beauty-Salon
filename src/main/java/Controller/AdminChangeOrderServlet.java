package Controller;

import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminChangeOrderServlet", value = "/AdminChangeOrder-Servlet")
public class AdminChangeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        request.setCharacterEncoding("UTF-8");
        try {
            String oid = (String) session.getAttribute("orderId");
            int orderId = Integer.parseInt(oid);
            request.setAttribute("orders", orderService.getOrdersByOrderId(orderId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 3) {
            request.getRequestDispatcher("adminchangeorder.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String orderId = request.getParameter("cancel");
        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
        }
        if (orderId != null) {
            session.setAttribute("orderId", orderId);
            response.sendRedirect("AdminChangeTimeSlot-Servlet");
        }
    }
}
