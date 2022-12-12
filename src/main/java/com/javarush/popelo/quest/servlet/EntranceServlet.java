package com.javarush.popelo.quest.servlet;

import com.javarush.popelo.quest.domain.User;
import com.javarush.popelo.quest.repository.Repository;
import com.javarush.popelo.quest.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "entranceServlet", value = "/entrance")
public class EntranceServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(EntranceServlet.class);
    private Repository<String, User> userRepository = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();

        userRepository = (Repository<String, User>) servletContext.getAttribute("userRepository");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("username");
        UserService userService = new UserService();
        HttpSession session = request.getSession();

        if (!userService.isUserNameCorrect(userName)) {
            request.setAttribute("message", "Некорректное имя!");
            LOGGER.debug("Incorrect name: " + userName);

            request.getRequestDispatcher("error").forward(request, response);

            return;
        }

        if (session.getAttribute("user") != null) {
            LOGGER.debug("User is null");
            response.sendRedirect("point");

            return;
        }

        User user;

        if (userRepository.isExists(userName)) {
            user = userRepository.getById(userName);

        } else {
            user = userService.createNewUser(userName);

            userRepository.save(userName, user);
        }

        session.setAttribute("user", user);
        response.sendRedirect("point?p=1");
    }
}
