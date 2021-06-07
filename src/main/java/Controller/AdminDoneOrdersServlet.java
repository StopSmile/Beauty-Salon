package Controller;

import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminDoneOrdersServlet", value = "/AdminDoneOrders-Servlet")
public class AdminDoneOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        try {
            request.setAttribute("orders", orderService.getAllDoneOrders());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 3) {
            request.getRequestDispatcher("admindoneorders.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String paid = request.getParameter("paid");

        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
            return;
        }

        if (paid != null) {
            OrderService orderService = new OrderService();
            int orderId = Integer.parseInt(paid);
            try {
                orderService.upDateOrderStatus(orderId, 4);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                request.setAttribute("orders", orderService.getAllDoneOrders());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("admindoneorders.jsp").forward(request, response);

        }

    }
}
