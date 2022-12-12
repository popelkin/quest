package com.javarush.popelo.quest.service;

import com.javarush.popelo.quest.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    /**
     * @param userName
     * @return
     */
    public boolean isUserNameCorrect(String userName) {
        userName = userName.trim();
        LOGGER.debug("User name: " + userName);

        return userName != null && !userName.equals("");
    }

    /**
     * @param userName
     * @return
     */
    public User createNewUser(String userName) {
        User user = new User();

        LOGGER.debug("User name: " + userName);

        if (!this.isUserNameCorrect(userName)) {
            throw new IllegalArgumentException("Incorrect Username");
        }

        user.setUsername(userName);
        user.setCurrentPointId(1);

        LOGGER.debug("New user is created");

        return user;
    }
}
