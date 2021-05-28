package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BootsTrapRegSeccessServlet", value = "/Bootstrapregsuccess-servlet")
public class BootsTrapRegSuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String message = "Ви успішно зареєструвались тепер ви можете увійти до свого облікового запису";
        session.setAttribute("message",message);
        response.sendRedirect("Bootstrapcabinet.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
