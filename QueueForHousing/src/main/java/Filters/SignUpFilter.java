package Filters;

import Dao.UserDao;
import Factories.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*if (((HttpServletRequest)servletRequest).getSession().getAttribute("current_user") != null){
            servletRequest.getRequestDispatcher("/queue").forward(servletRequest, servletResponse);
        }else {
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            String userName;
            Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
            String token = null;
            for (Cookie cookie : cookies) {
                if ("qfhCookie".equals(cookie.getName())){
                    token = cookie.getValue();
                }
            }
            if (token != null){
                userName = userDao.isExistToken(token);
                ((HttpServletRequest)servletRequest).getSession().setAttribute("current_user", userName);
                ((HttpServletResponse)servletResponse).sendRedirect("/queue");
            }else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }*/
    }

    @Override
    public void destroy() {

    }
}
