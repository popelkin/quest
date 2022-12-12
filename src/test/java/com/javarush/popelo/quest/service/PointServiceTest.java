package com.javarush.popelo.quest.service;

import com.javarush.popelo.quest.domain.Pipe;
import com.javarush.popelo.quest.domain.Point;
import com.javarush.popelo.quest.domain.PointStatus;
import com.javarush.popelo.quest.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PointServiceTest {

    @Mock
    Point point;
    @Mock
    PointService pointService;
    @Spy
    User user;

    @BeforeEach
    void setup() {
        /*point = Point.builder()
                .id(2)
                .name("Локация")
                .build();

        point.addPipe(Pipe.builder().pointId(2).build());
        point.addPipe(Pipe.builder().pointId(3).build());*/

        pointService = new PointService();
    }

    @Test
    void isStartPointTrue() {
        int pointId = 1;
        Point point = Point.builder()
                .id(10)
                .name("Локация")
                .status(PointStatus.WIN)
                .build();

        assertTrue(pointService.isStartPoint(pointId, point));
    }

    @Test
    void isStartPointFalse() {
        int pointId = 2;
        Point point = Point.builder()
                .id(1)
                .name("Локация")
                .status(PointStatus.WIN)
                .build();

        assertFalse(pointService.isStartPoint(pointId, point));
    }

    @Test
    void isFinishPointTrue() {
        int pointId = 12;
        Point point = Point.builder()
                .id(11)
                .name("Локация")
                .status(PointStatus.WIN)
                .build();

        assertTrue(pointService.isFinishPoint(point, pointId));
    }

    @Test
    void isFinishPointFalse() {
        int pointId = 10;
        Point point = Point.builder()
                .id(9)
                .name("Локация")
                .status(PointStatus.DEFAULT)
                .build();

        assertFalse(pointService.isFinishPoint(point, pointId));
    }

    @Test
    void isValidPointTrue() {
        int pointId = 3;
        Point point = Point.builder()
                .id(2)
                .name("Локация")
                .status(PointStatus.DEFAULT)
                .build();
        point.addPipe(Pipe.builder().pointId(3).build());
        point.addPipe(Pipe.builder().pointId(4).build());

        assertTrue(pointService.isValidPoint(pointId, point));
    }

    @Test
    void isValidPointFalse() {
        int pointId = 8;
        Point point = Point.builder()
                .id(2)
                .name("Локация")
                .status(PointStatus.DEFAULT)
                .build();
        point.addPipe(Pipe.builder().pointId(3).build());
        point.addPipe(Pipe.builder().pointId(4).build());

        assertFalse(pointService.isValidPoint(pointId, point));
    }

}