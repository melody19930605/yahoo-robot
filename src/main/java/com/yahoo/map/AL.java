package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.InputEvent;

public class AL {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void al(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走向花果山
        if (MyCityEnum.HGS.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(678, 328);//大约定位到游戏的62,18
            Point nextPoint = new Point( 1000,130);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot,null);
        }
        if (MyCityEnum.NEC.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(299, 325);//大约定位到游戏的62,18

            Point nextPoint = new Point(76, 190);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }
        Thread.sleep(1500);
    }
}
