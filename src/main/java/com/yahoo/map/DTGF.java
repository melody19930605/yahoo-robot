package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DTGF {
    public static void dtgf(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到程咬金屋子
        if (MyCityEnum.CYJF.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(  480,456);
            Point nextPoint = new Point(460, 379);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }
        Thread.sleep(1500);
    }
}
