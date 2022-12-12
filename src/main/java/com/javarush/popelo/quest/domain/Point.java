package com.javarush.popelo.quest.domain;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class Point {
    private Integer id;
    private String name;

    @Builder.Default
    private PointStatus status = PointStatus.DEFAULT;

    @Builder.Default
    private List<Pipe> pipes = new ArrayList<>();

    public List<Pipe> getPipes() {
        return pipes;
    }

    public void addPipe(Pipe pipe) {
        this.pipes.add(pipe);
    }

    public PointStatus getStatus() {
        return status;
    }

    public void setStatus(PointStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLast() {
        return this.pipes.isEmpty();
    }

    public List<Integer> getChildrenPointID() {
        return this.getPipes()
                .stream()
                .map(Pipe::getPointId)
                .collect(Collectors.toList());
    }

}
