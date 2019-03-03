package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class HGS {
    public static void hgs(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到北俱芦洲
        if (MyCityEnum.BJLZ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(368, 346);//大约定位到游戏的62,18
            Point nextPoint = new Point(479, 469);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);

            //对话传送
            myMousePoint.setLocation(325, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        Thread.sleep(1500);
    }
}
