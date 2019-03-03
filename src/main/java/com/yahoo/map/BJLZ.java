package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class BJLZ {
    public static void bjlz(Robot robot, MyCityEnum myCityEnum) throws Exception {
        if (MyCityEnum.CSJW.equals(myCityEnum)) {
            //TODO 找到地遁鬼
            Point myMousePoint = new Point();
            myMousePoint.setLocation(609, 563);//大约定位到游戏的62,18

            Point nextPoint = new Point(705, 604);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);

            //对话传送
            myMousePoint.setLocation(325, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        Thread.sleep(1500);

    }
}
