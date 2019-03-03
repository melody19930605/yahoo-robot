package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class FCS {
    public static void fcs(Robot robot, MyCityEnum myCityEnum) throws Exception {
        Point myMousePoint = new Point();
        myMousePoint.setLocation(542, 360);//大约定位到游戏的62,18
        Point nextPoint = new Point( 605,305);//大约定位到游戏的62,18
        RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
        RobotMain.myMoveAndClick(robot,nextPoint);
        Thread.sleep(1500);
    }
}
