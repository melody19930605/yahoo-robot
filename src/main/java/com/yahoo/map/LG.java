package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class LG {
    public static void lg(Robot robot, MyCityEnum myCityEnum) throws Exception {
        Point myMousePoint = new Point();
        myMousePoint.setLocation( 532,423);//大约定位到游戏的267,29
        Point nextPoint = new Point( 596,326);
        RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
        RobotMain.myMoveAndClick(robot,nextPoint);
        Thread.sleep(1500);
    }

}
