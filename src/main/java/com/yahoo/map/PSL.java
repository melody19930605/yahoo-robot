package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class PSL {
    public static void psl(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //TODO 凌霄宝殿
        if (MyCityEnum.PSD.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(654, 342);//大约定位到游戏的62,18
            Point nextPoint = new Point(970, 325);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }
        Thread.sleep(1500);
    }
}
