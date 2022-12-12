package com.javarush.popelo.quest.service;

import com.javarush.popelo.quest.domain.Point;
import com.javarush.popelo.quest.domain.PointStatus;

public class PointService {

    /**
     *
     * @param pointId
     * @param userPoint
     * @return
     */
    public boolean isStartPoint(int pointId, Point userPoint) {
        return pointId < userPoint.getId() && userPoint.getStatus() != PointStatus.DEFAULT;
    }

    /**
     * @param point
     * @param userCurrentPointId
     * @return
     */
    public boolean isFinishPoint(Point point, int userCurrentPointId) {
        return point.getStatus() != PointStatus.DEFAULT && point.getId() != userCurrentPointId;
    }

    /**
     *
     * @param pointId
     * @param userPoint
     * @return
     */
    public boolean isValidPoint(int pointId, Point userPoint) {
        return !(pointId < userPoint.getId() || (pointId != userPoint.getId() && !userPoint.getChildrenPointID().contains(pointId)));
    }
}
