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
import java.util.Map;

public class QueueServlet extends HttpServlet{

    QueueService queueService;

    @Override
    public void init() throws ServletException {
        queueService = ServiceFactory.getInstance().getQueueService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (queueService.checkRecorded((String) req.getSession().getAttribute("current_user"))){
            resp.sendRedirect("/success");
        }else {
            req.getRequestDispatcher("/queue.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        if (req.getParameter("save") != null && req.getParameter("save").equals("true")){
            resp.getWriter().write("/success");

        }else if (req.getParameter("mode").equals("father")){

            System.out.println(req.getParameterMap().toString());
            resp.getWriter().print("father");
            resp.sendError(400);

        }else if (req.getParameter("mode").equals("mother")){

            System.out.println(req.getParameterMap().toString());
            resp.getWriter().print("mother");

        }else if (req.getParameter("mode").equals("children")){

            Map<String, String[]> map = req.getParameterMap();
            for (Map.Entry<String, String[]> entry: map.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue()[0]);
            }
            resp.getWriter().print("children");

        }else if (req.getParameter("mode").equals("others")){

            System.out.println("this is others");
            Map<String, String[]> map = req.getParameterMap();
            for (Map.Entry<String, String[]> entry: map.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue()[0]);
            }
            resp.getWriter().print("others");
        }else {

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
                String surname = req.getParameter("child-surname[" + i + "]");
                String name = req.getParameter("child-name[" + i + "]");
                String patronymic = req.getParameter("child-patronymic[" + i + "]");
                if (!surname.equals("") && !name.equals("") && !patronymic.equals("")) {
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
}
