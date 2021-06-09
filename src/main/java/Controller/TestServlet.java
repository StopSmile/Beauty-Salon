package Controller;

import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TestServlet", value = "/Test-Servlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();

        int page1 = 1;
        int page2 = 2;
        int page3 = 3;

        int limit = 10;
        int offset = 0;
        if (request.getParameter("page") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            if (page == 1) {
                try {
                    request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, offset));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("page1", page1);
                request.setAttribute("page2", page2);
                request.setAttribute("page3", page3);
                session.setAttribute("sPage", 1);
                session.setAttribute("offset", 0);
                request.getRequestDispatcher("test2.jsp").forward(request, response);

            }
            if (page == 2) {
                offset = 10;
                try {
                    request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, offset));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("page1", page1);
                request.setAttribute("page2", page2);
                request.setAttribute("page3", page3);
                session.setAttribute("sPage", 2);
                session.setAttribute("offset", 10);
                request.getRequestDispatcher("test2.jsp").forward(request, response);
            }
            if (page == 3) {
                offset = 20;
                try {
                    request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, offset));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("page1", page1);
                request.setAttribute("page2", page2);
                request.setAttribute("page3", page3);
                session.setAttribute("sPage", 3);
                session.setAttribute("offset", 20);
                request.getRequestDispatcher("test2.jsp").forward(request, response);
            }
            if (page == 100) {
                offset = (Integer) session.getAttribute("offset");
                offset = offset + 10;
                try {
                    request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, offset));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                int sPage = (Integer) session.getAttribute("sPage");
                page1 = page1 + sPage - 1;
                page2 = page2 + sPage - 1;
                page3 = page3 + sPage - 1;
                request.setAttribute("page1", page1);
                request.setAttribute("page2", page2);
                request.setAttribute("page3", page3);
                session.setAttribute("sPage", sPage + 1);
                session.setAttribute("offset", offset);
                request.getRequestDispatcher("test2.jsp").forward(request, response);
            }
            if (page == 0) {
                offset = (Integer) session.getAttribute("offset");
                int sPage = (Integer) session.getAttribute("sPage");
                System.out.println(sPage);
                if (offset == 0 || sPage ==2) {
                    try {
                        request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, 0));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    session.setAttribute("sPage", 1);
                    session.setAttribute("offset", offset);
                    request.setAttribute("page1", page1);
                    request.setAttribute("page2", page2);
                    request.setAttribute("page3", page3);
                    response.sendRedirect("Test-Servlet");
                    return;
                }
                System.out.println(offset);
                offset = offset - 10;
                try {
                    request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, offset));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                page1 = page1 + sPage - 3;
                page2 = page2 + sPage - 3;
                page3 = page3 + sPage - 3;
                request.setAttribute("page1", page1);
                request.setAttribute("page2", page2);
                request.setAttribute("page3", page3);
                session.setAttribute("sPage", sPage - 1);
                session.setAttribute("offset", offset);
                request.getRequestDispatcher("test2.jsp").forward(request, response);
            }
        } else {
            try {
                request.setAttribute("orders", orderService.getAllOrdersForPagination(limit, offset));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("page1", page1);
            request.setAttribute("page2", page2);
            request.setAttribute("page3", page3);
            session.setAttribute("offset", offset);
            session.setAttribute("sPage", 1);
            request.getRequestDispatcher("test2.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


