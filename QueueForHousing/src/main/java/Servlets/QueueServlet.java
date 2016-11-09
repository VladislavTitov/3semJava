package Servlets;

import Factories.ServiceFactory;
import Models.*;
import Services.QueueService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueueServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QueueService queueService = ServiceFactory.getInstance().getQueueService();
        if (queueService.checkRecorded((String) req.getSession().getAttribute("current_user"))){
            resp.sendRedirect("/success");
        }else {
            req.getRequestDispatcher("/queue.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QueueService queueService = ServiceFactory.getInstance().getQueueService();

        Father father = new Father.Builder()
                .setSurname(req.getParameter("father-surname"))
                .setName(req.getParameter("father-name"))
                .setPatronymic(req.getParameter("father-patronymic"))
                .build();
        Mother mother = new Mother.Builder()
                .setSurname(req.getParameter("mother-surname"))
                .setName(req.getParameter("mother-name"))
                .setPatronymic(req.getParameter("mother-patronymic"))
                .build();

        int childrenCount = Integer.parseInt(req.getParameter("children-count"));
        ArrayList<Child> children = new ArrayList<>();

        for (int i = 0; i < childrenCount; i++) {
            String surname = req.getParameter("child-surname["+ i +"]");
            String name = req.getParameter("child-name["+ i +"]");
            String patronymic = req.getParameter("child-patronymic["+ i +"]");
            if (!surname.equals("") && !name.equals("") && !patronymic.equals("")){
                children.add(new Child.Builder()
                        .setSurname(surname)
                        .setName(name)
                        .setPatronymic(patronymic)
                        .build()
                );
            }
        }

        Family family = new Family.Builder()
                .setFather(father)
                .setMother(mother)
                .setChildren(children)
                .build();

        Wishes wishes = new Wishes.Builder()
                .setDistrict(req.getParameter("district"))
                .setRoomsCount(Integer.parseInt(req.getParameter("rooms-count")))
                .setKindergarden(req.getParameter("kindergarten") != null)
                .setSchool(req.getParameter("school") != null)
                .build();

        Housing housing = new Housing.Builder()
                .setFamily(family)
                .setWishes(wishes)
                .setCondition(Integer.parseInt(req.getParameter("condition")))
                .build();

        Queue queue = queueService.givePromotions(new Queue.Builder()
                .setHousing(housing)
                .setDate(LocalDate.now())
                .build());

        queueService.save((String) req.getSession().getAttribute("current_user"), queue);

        resp.sendRedirect("/success");
    }
}
