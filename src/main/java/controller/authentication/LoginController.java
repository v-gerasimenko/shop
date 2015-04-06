package controller.authentication;

import data_proccess.UserUtil;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    public static final String MENU_USER_PAGE = "jsp/menuUser.jsp";
    public static final String MENU_ADMIN_PAGE = "jsp/menuAdmin.jsp";
    public static final String ERROR_PAGE = "jsp/wrongValidation.jsp";
    public static final String ATTRIBUTE = "name";
    private UserUtil util = new UserUtil();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (util.entityExists(util.getByLoginAndPassword(username, password))) {
            User user = util.getByLoginAndPassword(username, password);

            if (user.getRole().equals("admin")) {

                RequestDispatcher view = request.getRequestDispatcher(MENU_ADMIN_PAGE);
                HttpSession session = request.getSession(true);

                session.setAttribute(ATTRIBUTE, username);
                view.forward(request, response);
            } else {

                RequestDispatcher view = request.getRequestDispatcher(MENU_USER_PAGE);
                HttpSession session = request.getSession(true);

                session.setAttribute(ATTRIBUTE, username);
                view.forward(request, response);
            }
        } else {
            RequestDispatcher view = request.getRequestDispatcher(ERROR_PAGE);
            view.forward(request, response);
        }

    }
}

