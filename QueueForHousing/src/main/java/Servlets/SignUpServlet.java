package Servlets;

import Factories.ServiceFactory;
import Models.User;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
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
        String passConf = req.getParameter("pass-conf");

        UserService userService = ServiceFactory.getInstance().getUserService();

        if (user_name.equals("") || password.equals("") || passConf.equals("") || !password.equals(passConf) || userService.isRegistered(user_name)){
            resp.sendRedirect("/signup");
        }else{
            userService.saveUser(new User(user_name, password));
            req.getSession().setAttribute("current_user", user_name);
            resp.sendRedirect("/queue");
        }







        /*if (!req.getParameter("pass").equals(req.getParameter("pass-conf"))){
            resp.sendRedirect("/signup");
        }else {
            UserService userService = ServiceFactory.getInstance().getUserService();
            if (userService.isRegistered(req.getParameter("email"))) {
                resp.sendRedirect("/signup");
            } else {
                userService.saveUser(new User(req.getParameter("email"), req.getParameter("pass")));
                resp.sendRedirect("/queue");
            }
        }*/
    }
}
