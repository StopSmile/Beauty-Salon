package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClientCabinetServlet", value = "/ClientCabinet-Servlet")
public class ClientCabinetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //request.getRequestDispatcher("clientcabinet.jsp").forward(request, response);

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        if (id == null) {
//            request.getRequestDispatcher("/bootstrap-servlet").forward(request, response);
            response.sendRedirect("bootstrapcabinet-servlet");
        } else {
            request.getRequestDispatcher("clientcabinet.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        System.out.println(logout);
        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            //session.setAttribute("id", null);
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }
}
