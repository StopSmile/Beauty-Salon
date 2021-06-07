package Controller;

import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminActiveOrdersServlet", value = "/AdminActiveOrders-Servlet")
public class AdminActiveOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("orders", orderService.getAllActiveOrders());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 3) {
            request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String orderIdCancel = request.getParameter("cancel");
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
                request.setAttribute("orders", orderService.getAllActiveOrders());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);

        }
        if (orderIdChange != null) {
            session.setAttribute("orderId", orderIdChange);
            response.sendRedirect("AdminChangeOrder-Servlet");
        }
    }
}
