package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.InputEvent;

public class HSS {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void hss(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到藏经阁
        if (MyCityEnum.CJG.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation( 562,424);
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(90, 54);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.NPC);
            myMousePoint.setLocation(597, 367);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
