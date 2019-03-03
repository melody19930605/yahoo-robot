package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class STL {
    public static void stl(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //
        if (MyCityEnum.SWD.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(623, 511);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            if(1==1){
                java.awt.Toolkit.getDefaultToolkit().beep();
                return;
            }
            myMousePoint.setLocation(913, 780);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        if (MyCityEnum.EDW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(623, 511);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            if(1==1){
                java.awt.Toolkit.getDefaultToolkit().beep();
                return;
            }
            myMousePoint.setLocation(913, 780);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }


        if (MyCityEnum.YWD.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(343, 469);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            myMousePoint.setLocation(352, 376);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        Thread.sleep(1500);
    }
}
