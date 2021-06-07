package Controller;


import service.ServiceService;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BootsTrapOurMastersServlet", value = "/bootstrapourmasters-servlet")
public class BootsTrapOurMastersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("masters", userService.getMasters());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("BootsTrapOurMasters.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        ServiceService serviceService = new ServiceService();
        request.setCharacterEncoding("UTF-8");
        String sortByNameUp = request.getParameter("nameUp");
        String sortByNameDown = request.getParameter("nameDown");
        String sortRateUp = request.getParameter("rateUp");
        String sortRateDown = request.getParameter("rateDown");
        String selectMaster = request.getParameter("master");
        if (sortByNameUp != null) {
            try {
                request.setAttribute("masters", userService.getSortedMastersByNameUp());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("BootsTrapOurMasters.jsp").forward(request, response);
        }
        if (sortByNameDown != null) {
            try {
                request.setAttribute("masters", userService.getSortedMastersByNameDown());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("BootsTrapOurMasters.jsp").forward(request, response);
        }
        if (sortRateUp != null) {
            try {
                request.setAttribute("masters", userService.getSortedMastersByRatingUp());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("BootsTrapOurMasters.jsp").forward(request, response);
        }
        if (sortRateDown != null) {
            try {
                request.setAttribute("masters", userService.getSortedMastersByRatingDown());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("BootsTrapOurMasters.jsp").forward(request, response);
        }
        if (selectMaster != null) {
            try {
                request.setAttribute("masters", userService.getMaster(selectMaster));
                request.setAttribute("masters2", serviceService.getMasterInfo(selectMaster));
                request.setAttribute("name", "Назва послуги");
                request.setAttribute("name2", "Ціна");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("BootsTrapOurMasters.jsp").forward(request, response);
        }

    }
}
