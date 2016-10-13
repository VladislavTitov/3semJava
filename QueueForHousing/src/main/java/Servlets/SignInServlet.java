package Servlets;

import Dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println("This is SignInServlet, which work 3 times!!!    ");
        resp.getWriter().println(userDao.find(""));
    }
}
