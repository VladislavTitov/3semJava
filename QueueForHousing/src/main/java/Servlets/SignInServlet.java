package Servlets;

import Factories.ServiceFactory;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        req.getSession().setMaxInactiveInterval(120);
    }


    /**
     * boolean remember is needed
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getParameter("email");
        String password = req.getParameter("pass");
        boolean remember = req.getParameter("remember") != null;

        UserService userService = ServiceFactory.getInstance().getUserService();

        if (user_name.equals("admin@mail.ru") && password.equals("321")){
            req.getSession().setAttribute("current_user", "admin");
            resp.sendRedirect("/admin");
        }else if (user_name.equals("") || password.equals("") || !userService.isRegistered(user_name) || !userService.checkPassword(user_name, password)){
            resp.sendRedirect("/signin");
        }else{
            if (remember){
                Cookie cookie = userService.generateCookies();
                cookie.setMaxAge(15*60);
                userService.saveToken(user_name, cookie.getValue());
                resp.addCookie(cookie);
            }
            req.getSession().setAttribute("current_user", req.getParameter("email"));
            resp.sendRedirect("/queue");
        }

    }
}
