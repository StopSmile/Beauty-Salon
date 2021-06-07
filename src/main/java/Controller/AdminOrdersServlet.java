package Controller;

import entity.User;
import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminOrdersServlet", value = "/AdminOrders-Servlet")
public class AdminOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("orders", orderService.getAllOrders());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 3) {
            request.getRequestDispatcher("adminorders.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String orderIdCancel = request.getParameter("cancel");
        String orderIdPaid = request.getParameter("paid");
        String orderIdChange = request.getParameter("change");
        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
            return;
        }
        if (orderIdCancel != null) {
            OrderService orderService = new OrderService();
            int cancel = Integer.parseInt(orderIdCancel);
            try {
                orderService.upDateOrderStatus(cancel, 2);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                request.setAttribute("orders", orderService.getAllOrders());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("adminorders.jsp").forward(request, response);

        }
        if (orderIdPaid != null) {
            OrderService orderService = new OrderService();
            int paid = Integer.parseInt(orderIdPaid);
            try {
                orderService.upDateOrderStatus(paid, 4);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                request.setAttribute("orders", orderService.getAllOrders());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("adminorders.jsp").forward(request, response);

        }
        if (orderIdChange != null) {
            session.setAttribute("orderId", orderIdChange);
            response.sendRedirect("AdminChangeOrder-Servlet");
        }
    }
}
