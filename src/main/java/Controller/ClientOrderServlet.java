package Controller;

import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ClientOrderServlet", value = "/ClientOrder-Servlet")
public class ClientOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        if (id == null) {
            response.sendRedirect("bootstrapcabinet-servlet");
        } else {
            request.getRequestDispatcher("clientorder.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String service1 = request.getParameter("service1");
        String service2 = request.getParameter("service2");
        String service3 = request.getParameter("service3");
        String service5 = request.getParameter("service5");
        String service6 = request.getParameter("service6");
        String service7 = request.getParameter("service7");
        String service8 = request.getParameter("service8");
        String service9 = request.getParameter("service9");
        String service10 = request.getParameter("service10");
        String service11 = request.getParameter("service11");
        String service12 = request.getParameter("service12");
        String service13 = request.getParameter("service13");
        String service14 = request.getParameter("service14");




        if (service1 != null) {
            session.setAttribute("serviceid",1);
            session.setAttribute("servicegroupid",1);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service2 != null) {
            session.setAttribute("serviceid",2);
            session.setAttribute("servicegroupid",1);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service3 != null) {
            session.setAttribute("serviceid",3);
            session.setAttribute("servicegroupid",1);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service5 != null) {
            session.setAttribute("serviceid",5);
            session.setAttribute("servicegroupid",1);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service6 != null) {
            session.setAttribute("serviceid",6);
            session.setAttribute("servicegroupid",1);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service7 != null) {
            session.setAttribute("serviceid",7);
            session.setAttribute("servicegroupid",1);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service8 != null) {
            session.setAttribute("serviceid",8);
            session.setAttribute("servicegroupid",2);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service9 != null) {
            session.setAttribute("serviceid",9);
            session.setAttribute("servicegroupid",2);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service10 != null) {
            session.setAttribute("serviceid",10);
            session.setAttribute("servicegroupid",2);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service11 != null) {
            session.setAttribute("serviceid",11);
            session.setAttribute("servicegroupid",2);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service12 != null) {
            session.setAttribute("serviceid",12);
            session.setAttribute("servicegroupid",2);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service13 != null) {
            session.setAttribute("serviceid",13);
            session.setAttribute("servicegroupid",3);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }
        if (service14 != null) {
            session.setAttribute("serviceid",14);
            session.setAttribute("servicegroupid",3);
            response.sendRedirect("ClientChoseMaster-Servlet");
        }

        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
        }
    }
}
