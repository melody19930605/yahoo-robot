package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class DTJW {
    public static void dtjw(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到长寿郊外
        if (MyCityEnum.CSJW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(261, 456);//大约定位到游戏的62,18
            //Point myPlayerPoint = new Point();
            //myPlayerPoint.setLocation(57, 8);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            myMousePoint.setLocation(517, 428);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            myMousePoint.setLocation(323, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //走到五庄观
        if (MyCityEnum.WZG.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(814, 430);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            myMousePoint.setLocation(992, 273);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //走到狮驼岭
        if (MyCityEnum.STL.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(261, 456);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            if(1==1){
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                return;
            }
            myMousePoint.setLocation(992, 273);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //走到魔王寨
        if (MyCityEnum.MWZ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(285, 381);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            if(1==1){
                java.awt.Toolkit.getDefaultToolkit().beep();
                return;
            }
            myMousePoint.setLocation(992, 273);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
