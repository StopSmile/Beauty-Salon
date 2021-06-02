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
        String id = (String) session.getAttribute("id");
        System.out.println(id);
        if (id == null) {
            request.getRequestDispatcher("Bootstrapcabinet.jsp").forward(request, response);
        } else {
            response.sendRedirect("ClientCabinet-Servlet");
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
                if (user.getRoleId() == 2){
                    session.setAttribute("user", user);
                    session.setAttribute("id",String.valueOf(user.getId()));
                    response.sendRedirect("ClientCabinet-Servlet");
                }
            } else {
                String message = "Ви ввели неправильний пароль";
                request.setAttribute("message", message);
                request.getRequestDispatcher("Bootstrapcabinet.jsp").forward(request, response);
            }
        }


    }
}
