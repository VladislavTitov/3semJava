package Servlets;

import Factories.ServiceFactory;
import Services.QueueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QueueService queueService = ServiceFactory.getInstance().getQueueService();
        req.getSession().setAttribute("id", queueService.findId((String)req.getSession().getAttribute("current_user")));
        req.getSession().setAttribute("family", queueService.findFamily((String)req.getSession().getAttribute("current_user")));
        req.getSession().setAttribute("promotions", queueService.findPromotions((String)req.getSession().getAttribute("current_user")));

        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }
}
