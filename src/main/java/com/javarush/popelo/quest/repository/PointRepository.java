package com.javarush.popelo.quest.repository;

import com.javarush.popelo.quest.domain.Pipe;
import com.javarush.popelo.quest.domain.Point;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PointRepository extends Repository<Integer, Point>{

    public Map<Integer, String> fetchNextPoints(Integer currentPointId) {
        return this.repository
                .get(currentPointId)
                .getPipes()
                .stream()
                .map(Pipe::getPointId)
                .collect(Collectors.toMap(Function.identity(), id -> repository.get(id).getName()));
    }

    public Map<Integer, Point> getAll() {
        return this.repository;
    }

}
