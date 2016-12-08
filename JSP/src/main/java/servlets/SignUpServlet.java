package servlets;

import dao.JdbcUserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is SignUpServlet!");
        /*while (req.getParameterNames().hasMoreElements()){
            System.out.println(req.getParameterNames().nextElement());
        }*/
        JdbcUserDaoImpl userDao = new JdbcUserDaoImpl();

        String user_name = req.getParameter("name");
        System.out.println("This is user_name: " + user_name);
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println(age);
        String city = req.getParameter("city");
        System.out.println(city);
        int id = userDao.addUser(user_name, age, city);

        resp.setContentType("text/plain");
        resp.getWriter().println(""+id);



    }
}
