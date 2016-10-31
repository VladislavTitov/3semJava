package Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class QueueFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getSession().getAttribute("current_user") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            ((HttpServletRequest)servletRequest).getRequestDispatcher("/signin").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
