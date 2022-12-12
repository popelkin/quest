package com.javarush.popelo.quest.servlet;

import com.javarush.popelo.quest.GameInitializer;
import com.javarush.popelo.quest.domain.Point;
import com.javarush.popelo.quest.domain.Quest;
import com.javarush.popelo.quest.domain.User;
import com.javarush.popelo.quest.repository.PointRepository;
import com.javarush.popelo.quest.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        GameInitializer initializer = new GameInitializer();
        ServletContext ctx = servletContextEvent.getServletContext();

        Repository<Integer, User> userRepository = new Repository<>();
        ctx.setAttribute("userRepository", userRepository);
        LOGGER.info("Created user repository: ", userRepository);

        PointRepository pointRepository = new PointRepository();
        for(Point point: initializer.getDefaultMap()) {
            pointRepository.save(point.getId(), point);
        }
        ctx.setAttribute("pointRepository", pointRepository);
        LOGGER.info("Created point repository: ", pointRepository);

        Repository<Integer, Quest> questRepository = new Repository<>();
        for (Quest quest : initializer.getDefaultQuests()) {
            questRepository.save(quest.getId(), quest);
        }
        ctx.setAttribute("questRepository", questRepository);
        LOGGER.info("Created quest repository: ", questRepository);
    }

}