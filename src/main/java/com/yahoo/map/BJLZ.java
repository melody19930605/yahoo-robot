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
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myMousePoint, EntranceTypeEnum.DIRECT);
            myMousePoint.setLocation(705, 604);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            //对话传送
            myMousePoint.setLocation(325, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
