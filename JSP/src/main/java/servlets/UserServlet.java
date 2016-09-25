package servlets;

import dao.JdbcUserDaoImpl;
import dao.User;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JdbcUserDaoImpl userDao = new JdbcUserDaoImpl();
        req.setAttribute("userlist", userDao.findAll());
        System.out.println(userDao.findAll().size());
        for (User user :
                userDao.findAll()) {
            System.out.println(user);
        }
        getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
        /*PrintWriter pw = resp.getWriter();
        for (User user :
                userDao.findAll()) {
            pw.println("<p>" + user.toString() + "</p>");
        }*/
    }
}
