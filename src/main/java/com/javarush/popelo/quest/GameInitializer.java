package com.javarush.popelo.quest;

import com.javarush.popelo.quest.domain.Pipe;
import com.javarush.popelo.quest.domain.Point;
import com.javarush.popelo.quest.domain.PointStatus;
import com.javarush.popelo.quest.domain.Quest;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    public List<Point> getDefaultMap() {
        List<Point> points = new ArrayList<>();
        int counter = 1;
        
        Point point1 = Point.builder()
                .id(counter++)
                .name("Ты потерял память.<br /><strong>Принять вызов НЛО?</strong>")
                .build();
        points.add(point1);

        Point point2 = Point.builder()
                .id(counter++)
                .name("Принять вызов")
                .build();
        points.add(point2);

        Point point3 = Point.builder()
                .id(counter++)
                .name("Отклонить вызов")
                .build();
        points.add(point3);

        Point point4 = Point.builder()
                .id(counter++)
                .name("Ты принял вызов.<br />Поднимешься на мостик?")
                .build();
        points.add(point4);

        Point point5 = Point.builder()
                .id(counter++)
                .name("Ты отклонил вызов.<br /><strong>Поражение</strong>")
                .status(PointStatus.FAIL)
                .build();
        points.add(point5);

        Point point6 = Point.builder()
                .id(counter++)
                .name("Подняться на мостик")
                .build();
        points.add(point6);

        Point point7 = Point.builder()
                .id(counter++)
                .name("Отказаться подниматься на мостик")
                .build();
        points.add(point7);

        Point point8 = Point.builder()
                .id(counter++)
                .name("Ты поднялся на мостик.<br />Ты кто?")
                .build();
        points.add(point8);

        Point point9 = Point.builder()
                .id(counter++)
                .name("Ты не пошел на переговоры.<br /><strong>Поражение</strong>")
                .status(PointStatus.FAIL)
                .build();
        points.add(point9);

        Point point10 = Point.builder()
                .id(counter++)
                .name("Рассказать правду о себе")
                .build();
        points.add(point10);

        Point point11 = Point.builder()
                .id(counter++)
                .name("Солгать о себе")
                .build();
        points.add(point11);

        Point point12 = Point.builder()
                .id(counter++)
                .name("Тебя вернули домой.<br /><strong>Победа</strong>")
                .status(PointStatus.WIN)
                .build();
        points.add(point12);

        Point point13 = Point.builder()
                .id(counter++)
                .name("Твою ложь разоблачили.<br /><strong>Поражение</strong>")
                .status(PointStatus.FAIL)
                .build();
        points.add(point13);

        point1.addPipe(Pipe.builder().pointId(point2.getId()).build());
        point1.addPipe(Pipe.builder().pointId(point3.getId()).build());

        point2.addPipe(Pipe.builder().pointId(point4.getId()).build());

        point3.addPipe(Pipe.builder().pointId(point5.getId()).build());

        point4.addPipe(Pipe.builder().pointId(point6.getId()).build());
        point4.addPipe(Pipe.builder().pointId(point7.getId()).build());

        point7.addPipe(Pipe.builder().pointId(point9.getId()).build());

        point6.addPipe(Pipe.builder().pointId(point8.getId()).build());

        point8.addPipe(Pipe.builder().pointId(point11.getId()).build());
        point8.addPipe(Pipe.builder().pointId(point10.getId()).build());

        point11.addPipe(Pipe.builder().pointId(point13.getId()).build());

        point10.addPipe(Pipe.builder().pointId(point12.getId()).build());

        return points;
    }

    public List<Quest> getDefaultQuests() {
        List<Quest> quests = new ArrayList<>();

        quests.add(Quest.builder()
                .id(1)
                .text("Звёздный путь")
                .build());

        return quests;

    }

}
