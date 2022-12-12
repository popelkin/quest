package com.javarush.popelo.quest.servlet;

import com.javarush.popelo.quest.domain.Point;
import com.javarush.popelo.quest.domain.PointStatus;
import com.javarush.popelo.quest.domain.User;
import com.javarush.popelo.quest.repository.PointRepository;
import com.javarush.popelo.quest.service.PointService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PointServlet", value = "/point")
public class PointServlet extends HttpServlet {
    private PointRepository pointRepository = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext servletContext = config.getServletContext();
        pointRepository = (PointRepository) servletContext.getAttribute("pointRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int userCurrentPointId = user.getCurrentPointId();
        Point userPoint = pointRepository.getById(userCurrentPointId);
        int pointId = Integer.parseInt(request.getParameter("p"));
        Point point = pointRepository.getById(pointId);
        PointService pointService = new PointService();
        request.setAttribute("title",  point.getName().replaceAll("<[^>]*>", " "));

        if (pointService.isStartPoint(pointId, userPoint)) {
            pointId = 1;
            userCurrentPointId = 1;
            userPoint = pointRepository.getById(userCurrentPointId);
        }

        if (pointService.isFinishPoint(point, userCurrentPointId)) {
            int points = point.getStatus() == PointStatus.WIN ? 1 : -1;

            user.setQuests(user.getQuests() + 1);
            user.setPoints(user.getPoints() + points);
        }

        if (!pointService.isValidPoint(pointId, userPoint)) {
            request.setAttribute("message", "Некорректное ID шага!");

            request.getRequestDispatcher("error").forward(request, response);

            return;
        }

        user.setCurrentPointId(pointId);

        List<Integer> children = pointRepository.fetchNextPoints(pointId)
                .keySet()
                .stream()
                .collect(Collectors.toList());

        request.setAttribute("children", children);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/point.jsp")
                .forward(request, response);
    }

}
