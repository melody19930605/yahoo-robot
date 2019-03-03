package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CJG {
    public static void cjg(Robot robot, MyCityEnum myCityEnum) throws Exception {
        robot.keyPress(KeyEvent.VK_F9);
        RobotMain.getRandomSleep();
        robot.keyRelease(KeyEvent.VK_F9);
        Point point = new Point(446,398);
        RobotMain.myMoveAndClick(robot,point);
        point = new Point(290,504);
        RobotMain.myMoveAndClick(robot,point);
        //点击镖
        point = new Point(737,505);
        RobotMain.myMoveAndClick(robot,point);
        //给出去
        point = new Point(389,549);
        RobotMain.myMoveAndClick(robot,point);
        Thread.sleep(1500);
    }

}
