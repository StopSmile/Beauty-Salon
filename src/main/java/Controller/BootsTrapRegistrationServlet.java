package Controller;

import entity.User;
import logic.UserDAO999;
import org.postgresql.util.PSQLException;
import service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BootsTrapRegistrationServlet", value = "/BootsTrapRegistration-Servlet")
public class BootsTrapRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("BootsTrapRegistration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserService userService = new UserService();
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int roleId = 2;

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRoleId(roleId);
        user.setServiceGroupId(0);
        user.setRating(0);


        String checkEmail = "";
        String checkLogin = "";
        try {
            checkEmail = userService.checkEmail(email);
            checkLogin = userService.checkLogin(login);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (checkEmail == null && checkLogin == null) {
            try {
                userService.addUser(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String message = "Ви успішно зарейструвались";
            request.setAttribute("message", message);
            request.getRequestDispatcher("Bootstrapcabinet.jsp").forward(request, response);
        }
        if (checkLogin != null && checkEmail != null) {
            String message = "Такий логін вже існує " + checkLogin + " Така пошта вже зареєстрована" + checkEmail;
            request.setAttribute("message", message);
            request.getRequestDispatcher("BootsTrapRegistration.jsp").forward(request, response);
        }
        if (checkEmail != null) {
            String message = "Така пошта вже зареєстрована " + checkEmail;
            request.setAttribute("message", message);
            request.getRequestDispatcher("BootsTrapRegistration.jsp").forward(request, response);
        }
        if (checkLogin != null) {
            String message = "Такий логін вже існує " + checkLogin;
            request.setAttribute("message", message);
            request.getRequestDispatcher("BootsTrapRegistration.jsp").forward(request, response);
        }



    }
}
