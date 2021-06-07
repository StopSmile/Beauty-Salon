package Controller;

import entity.User;
import service.OrderService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MasterOrdersServlet", value = "/MasterOrders-Servlet")
public class MasterOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();


        OrderService orderService = new OrderService();
        request.setCharacterEncoding("UTF-8");
        try {
            User user = (User) session.getAttribute("user");
            int masterid = user.getId();
            request.setAttribute("orders", orderService.getOrdersForMaster(masterid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 4) {
            request.getRequestDispatcher("masterorders.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String orderId = request.getParameter("orderid");
        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
            return;
        }
        if (orderId != null) {
            OrderService orderService = new OrderService();
            int id = Integer.parseInt(orderId);
            try {
                orderService.upDateOrderStatus(id, 3);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            response.sendRedirect("MasterOrders-Servlet");

        }

    }
}
