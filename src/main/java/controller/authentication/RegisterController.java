package controller.authentication;

import data_proccess.UserUtil;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    public static final String ERROR_PAGE = "jsp/wrongUser.jsp";
    public static final String LOGIN_PAGE = "jsp/login.jsp";
    private UserUtil util = new UserUtil();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password);

        if (util.entityExists(user)) {
            RequestDispatcher view = request.getRequestDispatcher(ERROR_PAGE);
            view.forward(request, response);
        } else {
            util.addEntity(user);
            RequestDispatcher view = request.getRequestDispatcher(LOGIN_PAGE);
            view.forward(request, response);
        }

    }
}