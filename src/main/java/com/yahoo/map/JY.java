package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.InputEvent;

public class JY {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void jy(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走向东海湾
        if (MyCityEnum.DHW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(757, 509);//大约定位到游戏的267,29
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(267, 29);
            Point nextPoint = new Point(939, 462);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }
        Thread.sleep(1500);
    }
}
