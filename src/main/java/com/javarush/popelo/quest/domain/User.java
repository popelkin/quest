package com.javarush.popelo.quest.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String username;
    private Integer currentPointId;
    private Integer quests = 0;
    private Integer points = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCurrentPointId() {
        return currentPointId;
    }

    public void setCurrentPointId(int currentPointId) {
        this.currentPointId = currentPointId;
    }

    public Integer getQuests() {
        return quests;
    }

    public void setQuests(int quests) {
        this.quests = quests;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
