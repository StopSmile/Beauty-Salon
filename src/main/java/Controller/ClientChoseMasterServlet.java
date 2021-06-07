package Controller;

import entity.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ClientChoseMasterServlet", value = "/ClientChoseMaster-Servlet")
public class ClientChoseMasterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 2) {
            UserService userService = new UserService();
            int servicegroupid = (Integer) session.getAttribute("servicegroupid");
            if (servicegroupid == 1) {
                try {
                    request.setAttribute("masters", userService.getMastersFirstGroup());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (servicegroupid == 2) {
                try {
                    request.setAttribute("masters", userService.getMastersSecondGroup());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (servicegroupid == 3) {
                try {
                    request.setAttribute("masters", userService.getMastersThirdGroup());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            request.getRequestDispatcher("clientchosemaster.jsp").forward(request, response);
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String masterid = request.getParameter("masterid");


        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
        }
        if (masterid != null) {
            session.setAttribute("masterid", masterid);
            response.sendRedirect("ClientChoseTimeSlot-Servlet");
        }

    }
}
