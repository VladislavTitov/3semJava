package Filters;

import Dao.UserDao;
import Factories.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class QueueFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getSession().getAttribute("current_user") == null){
            UserDao userDao = DaoFactory.getInstance().getUserDao();
            String userName;
            Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
            String token = null;
            for (Cookie cookie : cookies) {
                if ("qfhCookie".equals(cookie.getName())){
                    token = cookie.getValue();
                }
            }if (token != null){
                userName = userDao.isExistToken(token);
                ((HttpServletRequest)servletRequest).getSession().setAttribute("current_user", userName);
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                servletRequest.getRequestDispatcher("/signin").forward(servletRequest, servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
