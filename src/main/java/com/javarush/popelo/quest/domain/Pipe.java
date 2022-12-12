package com.javarush.popelo.quest.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pipe {
    private Integer pointId;

    public Integer getPointId() {
        return pointId;
    }
}
