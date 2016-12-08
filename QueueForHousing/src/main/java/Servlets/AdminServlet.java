package Servlets;

import Dao.AdminDao;
import Factories.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDao adminDao = DaoFactory.getInstance().getAdminDao();
        PrintWriter writer = resp.getWriter();
        ResultSet rs = adminDao.selectQueue();
        resp.setContentType("text/html;charset=UTF-8");
        writer.print("<tr><th>№ Queue</th><th>№ family</th><th>№ housing</th><th>Application date</th><th>Promotions</th><th>Out of queue</th>" +
                "<th>First of queue</th></tr>");
        try {
            while (rs.next()){
                writer.print("<tr>");
                writer.print("<td>" + rs.getInt("queue_id")+ "</td>");
                writer.print("<td>" + rs.getInt("family_id") + "</td>");
                writer.print("<td>" + rs.getInt("housing_id") + "</td>");
                writer.print("<td>" + rs.getDate("date_application") + "</td>");
                writer.print("<td>" + rs.getBoolean("promotions") + "</td>");
                writer.print("<td>" + rs.getBoolean("out_of_queue") + "</td>");
                writer.print("<td>" + rs.getBoolean("first_of_queue") + "</td>");
                writer.print("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
