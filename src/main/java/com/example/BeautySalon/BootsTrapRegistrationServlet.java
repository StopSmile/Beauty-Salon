package com.example.BeautySalon;

import logic.BootsTrapUser;
import logic.UserDAO;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        try {
            UserDAO userDAO = UserDAO.getInstance();
            BootsTrapUser bootsTrapUser = new BootsTrapUser(firstName,lastName,login,password,email);
            System.out.println(bootsTrapUser.getLogin() + " " + bootsTrapUser.getEmail());
            userDAO.InsertUser(bootsTrapUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("Bootstrapregsuccess-servlet");


    }
}
