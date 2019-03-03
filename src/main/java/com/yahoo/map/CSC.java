package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class CSC {
    public static void cac(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //方寸山
        if (MyCityEnum.FCS.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(531, 308);//大约定位到游戏的62,18
            Point nextPoint = new Point( 587,85);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot,nextPoint);
        }
        Thread.sleep(1500);
    }
}
