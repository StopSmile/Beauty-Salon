package Controller;

import entity.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BootsTrapCabinetServlet", value = "/bootstrapcabinet-servlet")
public class BootsTrapCabinetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        HttpSession session = request.getSession();
        Integer roleid = (Integer) session.getAttribute("roleid");
        if (roleid == null) {
            request.getRequestDispatcher("Bootstrapcabinet.jsp").forward(request, response);
        }
        if (roleid == 2) {
            response.sendRedirect("ClientCabinet-Servlet");
        }
        if (roleid == 4) {
            response.sendRedirect("MasterCabinet-Servlet");
        }
        if (roleid == 3) {
            response.sendRedirect("AdminCabinet-Servlet");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setCharacterEncoding("UTF-8");
        UserService userService = new UserService();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("Your login and pass: " + login + " " + password);

        String checkLogin = null;
        try {
            checkLogin = userService.checkLogin(login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (checkLogin == null) {
            String message = "Такий логін не зареєстрований";
            request.setAttribute("message", message);
            request.getRequestDispatcher("Bootstrapcabinet.jsp").forward(request, response);
        }
        if (checkLogin != null) {
            User user = new User();
            try {
                user = userService.getByLogin(checkLogin);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (user.getPassword().equals(password)) {
                if (user.getRoleId() == 2) {
                    session.setAttribute("user", user);
                    session.setAttribute("roleid", user.getRoleId());
                    response.sendRedirect("ClientCabinet-Servlet");
                }
                if (user.getRoleId() == 4) {
                    session.setAttribute("user", user);
                    session.setAttribute("roleid", user.getRoleId());
                    response.sendRedirect("MasterCabinet-Servlet");
                }
                if (user.getRoleId() == 3) {
                    session.setAttribute("user", user);
                    session.setAttribute("roleid", user.getRoleId());
                    response.sendRedirect("AdminCabinet-Servlet");
                }
            } else {
                String message = "Ви ввели неправильний пароль";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Bootstrapcabinet.jsp").forward(request, response);
            }
        }


    }
}
