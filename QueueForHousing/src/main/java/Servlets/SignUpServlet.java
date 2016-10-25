package Servlets;

import Models.User;
import Services.UserService;
import Services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
        System.out.println("This is Registration!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("pass"));
        System.out.println(req.getParameter("pass-conf"));

        if (!req.getParameter("pass").equals(req.getParameter("pass-conf"))){
            /*req.getSession().setAttribute("equals", "false");
            req.getSession().setAttribute("email", req.getParameter("email"));*/
            resp.sendRedirect("/signup");
        }else {
            /*req.getSession().setAttribute("equals", true);*/
            UserService userService = new UserServiceImpl();
            if (userService.isRegistered(req.getParameter("email"))) {
                /*req.getSession().setAttribute("isregistered", true);*/
                resp.sendRedirect("/signup");
            } else {
               /* req.getSession().setAttribute("isregistered", false);*/
                userService.saveUser(new User(req.getParameter("email"), req.getParameter("pass")));
                resp.sendRedirect("/queue");
            }
        }
    }
}
