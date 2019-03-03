package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class PTS {
    public static void pts(Robot robot, MyCityEnum myCityEnum) throws Exception {
        if (MyCityEnum.CYD.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(348, 342);//大约定位到游戏的62,18
            Point nextPoint = new Point(140, 93);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }
        Thread.sleep(1500);
    }
}
