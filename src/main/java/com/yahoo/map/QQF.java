package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.KeyEvent;

public class QQF {
    public static void toQQ(Robot robot, MyCityEnum myCityEnum) throws Exception {
        robot.keyPress(KeyEvent.VK_F9);
        RobotMain.getRandomSleep();
        robot.keyRelease(KeyEvent.VK_F9);
        Point myMousePoint = new Point();
        myMousePoint.setLocation(460, 440);//大约定位到游戏的62,18
        RobotMain.myMoveAndClick(robot, myMousePoint);
    }
}
