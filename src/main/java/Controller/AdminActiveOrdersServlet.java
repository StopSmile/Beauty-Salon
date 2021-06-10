package Controller;

import service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminActiveOrdersServlet", value = "/AdminActiveOrders-Servlet")
public class AdminActiveOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderService orderService = new OrderService();
        request.setCharacterEncoding("UTF-8");
        try {
            request.setAttribute("orders", orderService.getAllActiveOrders());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int roleid = (int) session.getAttribute("roleid");

        if (roleid == 3) {
            int page1 = 1;
            int page2 = 2;
            int page3 = 3;

            int limit = 11;
            int offset = 0;

            if (request.getParameter("page") != null) {
                int page = Integer.parseInt(request.getParameter("page"));
                if (page == 1) {
                    if (session.getAttribute("sPage1") != null) {
                        int page1jsp = (Integer) session.getAttribute("sPage1");
                        if (page1jsp == 1) {
                            try {
                                request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, 0));
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            session.setAttribute("sPage", 1);
                            session.setAttribute("offset", 0);
                            session.setAttribute("sPage1", page1);
                            session.setAttribute("sPage2", page2);
                            session.setAttribute("sPage3", page3);
                            request.setAttribute("page1", page1);
                            request.setAttribute("page2", page2);
                            request.setAttribute("page3", page3);
                            response.sendRedirect("AdminActiveOrders-Servlet");
                            return;
                        }
                        try {
                            request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, (page1jsp * 11) - 11));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        request.setAttribute("page1", page1jsp - 1);
                        request.setAttribute("page2", page1jsp);
                        request.setAttribute("page3", page1jsp + 1);
                        session.setAttribute("sPage", page1jsp);
                        session.setAttribute("sPage1", page1jsp - 1);
                        session.setAttribute("sPage2", page1jsp);
                        session.setAttribute("sPage3", page1jsp + 1);
                        session.setAttribute("offset", (page1jsp * 11) - 11);
                        request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                        return;
                    }
                    try {
                        request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, offset));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    request.setAttribute("page1", page1);
                    request.setAttribute("page2", page2);
                    request.setAttribute("page3", page3);
                    session.setAttribute("sPage", 1);
                    session.setAttribute("sPage1", page1);
                    session.setAttribute("sPage2", page2);
                    session.setAttribute("sPage3", page3);
                    session.setAttribute("offset", 0);
                    request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);

                }
                if (page == 2) {
                    if (session.getAttribute("sPage2") != null) {
                        int page1jsp = (Integer) session.getAttribute("sPage2");
                        try {
                            request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, (page1jsp * 11) - 11));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        request.setAttribute("page1", page1jsp - 1);
                        request.setAttribute("page2", page1jsp);
                        request.setAttribute("page3", page1jsp + 1);
                        session.setAttribute("sPage", page1jsp);
                        session.setAttribute("sPage1", page1jsp - 1);
                        session.setAttribute("sPage2", page1jsp);
                        session.setAttribute("sPage3", page1jsp + 1);
                        session.setAttribute("offset", (page1jsp * 11) - 11);
                        request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                        return;
                    }
                    offset = 11;
                    try {
                        request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, offset));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    request.setAttribute("page1", page1);
                    request.setAttribute("page2", page2);
                    request.setAttribute("page3", page3);
                    session.setAttribute("sPage1", page1);
                    session.setAttribute("sPage2", page2);
                    session.setAttribute("sPage3", page3);
                    session.setAttribute("sPage", 2);
                    session.setAttribute("offset", offset);
                    request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                }
                if (page == 3) {
                    if (session.getAttribute("sPage3") != null) {
                        int page1jsp = (Integer) session.getAttribute("sPage3");
                        try {
                            request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, (page1jsp * 11) - 11));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        request.setAttribute("page1", page1jsp - 1);
                        request.setAttribute("page2", page1jsp);
                        request.setAttribute("page3", page1jsp + 1);
                        session.setAttribute("sPage", page1jsp);
                        session.setAttribute("sPage1", page1jsp - 1);
                        session.setAttribute("sPage2", page1jsp);
                        session.setAttribute("sPage3", page1jsp + 1);
                        session.setAttribute("offset", (page1jsp * 11) - 11);
                        request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                        return;
                    }
                    offset = 22;
                    try {
                        request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, offset));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    request.setAttribute("page1", page1);
                    request.setAttribute("page2", page2);
                    request.setAttribute("page3", page3);
                    session.setAttribute("sPage1", page1);
                    session.setAttribute("sPage2", page2);
                    session.setAttribute("sPage3", page3);
                    session.setAttribute("sPage", 3);
                    session.setAttribute("offset", offset);
                    request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                }
                if (page == 100) {
                    offset = (Integer) session.getAttribute("offset");
                    offset = offset + 11;
                    try {
                        request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, offset));
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
                    session.setAttribute("sPage1", page1);
                    session.setAttribute("sPage2", page2);
                    session.setAttribute("sPage3", page3);
                    session.setAttribute("sPage", sPage + 1);
                    session.setAttribute("offset", offset);
                    request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                }
                if (page == 0) {
                    offset = (Integer) session.getAttribute("offset");
                    int sPage = (Integer) session.getAttribute("sPage");
                    if (offset == 0 || sPage == 2) {
                        try {
                            request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, 0));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        session.setAttribute("sPage", 1);
                        session.setAttribute("offset", offset);
                        session.setAttribute("sPage1", page1);
                        session.setAttribute("sPage2", page2);
                        session.setAttribute("sPage3", page3);
                        request.setAttribute("page1", page1);
                        request.setAttribute("page2", page2);
                        request.setAttribute("page3", page3);
                        response.sendRedirect("AdminActiveOrders-Servlet");
                        return;
                    }
                    offset = offset - 11;
                    try {
                        request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, offset));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    page1 = page1 + sPage - 3;
                    page2 = page2 + sPage - 3;
                    page3 = page3 + sPage - 3;
                    request.setAttribute("page1", page1);
                    request.setAttribute("page2", page2);
                    request.setAttribute("page3", page3);
                    session.setAttribute("sPage1", page1);
                    session.setAttribute("sPage2", page2);
                    session.setAttribute("sPage3", page3);
                    session.setAttribute("sPage", sPage - 1);
                    session.setAttribute("offset", offset);
                    request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                }
            } else {
                try {
                    request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(limit, offset));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("page1", page1);
                request.setAttribute("page2", page2);
                request.setAttribute("page3", page3);
                session.setAttribute("sPage1", page1);
                session.setAttribute("sPage2", page2);
                session.setAttribute("sPage3", page3);
                session.setAttribute("offset", offset);
                session.setAttribute("sPage", 1);
                request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("bootstrapcabinet-servlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        String orderIdCancel = request.getParameter("cancel");
        String orderIdChange = request.getParameter("change");
        if (logout != null) {
            System.out.println("logout != null");
            session.invalidate();
            response.sendRedirect("bootstrapcabinet-servlet");
            return;
        }
        if (orderIdCancel != null) {
            OrderService orderService = new OrderService();
            int cancel = Integer.parseInt(orderIdCancel);
            try {
                orderService.upDateOrderStatus(cancel, 2);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            int page1jsp = (Integer) session.getAttribute("sPage");
            if (page1jsp == 1) {
                try {
                    request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(11, 0));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                request.setAttribute("page1", 1);
                request.setAttribute("page2", 2);
                request.setAttribute("page3", 3);
                session.setAttribute("sPage", 1);
                session.setAttribute("sPage1", 1);
                session.setAttribute("sPage2", 2);
                session.setAttribute("sPage3", 3);
                session.setAttribute("offset", 0);
                request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
                return;

            }

            try {
                request.setAttribute("orders", orderService.getAllOrdersWhereStatusActiveForPagination(11, (page1jsp * 11) - 11));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("page1", page1jsp - 1);
            request.setAttribute("page2", page1jsp);
            request.setAttribute("page3", page1jsp + 1);
            session.setAttribute("sPage", page1jsp);
            session.setAttribute("sPage1", page1jsp - 1);
            session.setAttribute("sPage2", page1jsp);
            session.setAttribute("sPage3", page1jsp + 1);
            session.setAttribute("offset", (page1jsp * 11) - 11);
            request.getRequestDispatcher("adminactiveorders.jsp").forward(request, response);
            return;

        }
        if (orderIdChange != null) {
            session.setAttribute("orderId", orderIdChange);
            response.sendRedirect("AdminChangeOrder-Servlet");
        }
    }
}
