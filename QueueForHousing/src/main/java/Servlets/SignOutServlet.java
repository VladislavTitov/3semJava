package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOutServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("current_user");
        Cookie cookie = new Cookie("qfhCookie", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect("/signin");
    }
}
