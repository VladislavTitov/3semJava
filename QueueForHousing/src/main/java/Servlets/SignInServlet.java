package Servlets;

import Factories.ServiceFactory;
import Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signin.jsp").forward(req, resp);
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

        UserService userService = ServiceFactory.getInstance().getUserService();

        if (user_name.equals("") || password.equals("") || !userService.isRegistered(user_name) || !userService.checkPassword(user_name, password)){
            resp.sendRedirect("/signin");
        }else{
            req.getSession().setAttribute("current_user", req.getParameter("email"));
            resp.sendRedirect("/queue");
        }

    }
}
