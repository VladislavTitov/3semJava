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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = ServiceFactory.getInstance().getUserService();

        if (userService.isRegistered(req.getParameter("email"))){
            req.getSession().setAttribute("current_user", req.getParameter("email"));
            resp.sendRedirect("/queue");
        }else {

            for (Map.Entry<String, String[]> entry: req.getParameterMap().entrySet()){
                for (String value :
                        entry.getValue()) {
                    System.out.println(entry.getKey() +  " " + value);
                }
            }

            if (req.getParameter("remember") == null){
                System.out.println("Remember == null");
            }

            resp.sendRedirect("/signin");
        }
    }
}
