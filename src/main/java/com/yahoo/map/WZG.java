package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;
import com.yahoo.util.SearchPointUtil;

import java.awt.*;

public class WZG {
    public static void wzg(Robot robot, MyCityEnum myCityEnum) throws Exception {
        Point myMousePoint = new Point();
        myMousePoint.setLocation(525, 439);//大约定位到游戏的62,18
        Point nextPoint = new Point(616, 343);
        RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
        RobotMain.myMoveAndClick(robot, null);
        Thread.sleep(1500);
    }
}
