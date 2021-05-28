package Controller;

import service.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BootsTrapOurServicesServlet", value = "/BootsTrapOurServices-Servlet")
public class BootsTrapOurServicesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceService serviceService = new ServiceService();
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("services", serviceService.getServices());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("BootsTrapOurServices.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
