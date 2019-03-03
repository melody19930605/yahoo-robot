package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class NEC {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void nec(Robot robot, MyCityEnum myCityEnum) throws Exception {
        Point myMousePoint = new Point();
        myMousePoint.setLocation(402, 348);
        Point nextPoint = new Point(258, 337);
        RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
        RobotMain.myMoveAndClick(robot, null);
        Thread.sleep(2000);
    }
}
