package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class JNYW {
    public static void jnyw(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到建业
        if (MyCityEnum.JY.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(635, 452);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(143, 55);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            myMousePoint.setLocation(994, 450);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
