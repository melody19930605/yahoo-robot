package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class DF {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void df(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走向东海湾
        if (MyCityEnum.SLD.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(299, 325);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
        }
        Thread.sleep(1500);
    }
}
