package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;
import com.yahoo.util.SearchPointUtil;

import java.awt.*;

public class DTJW {
    public static void dtjw(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到长寿郊外
        if (MyCityEnum.CSJW.equals(myCityEnum)) {
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.CSJW.toString(),true,null,null);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.DTJW_CSJW_TD.toString(),false,"imgsource/dtjw_xrz.png",null);
            RobotMain.myMoveTo(robot,myMousePoint);
            java.awt.Toolkit.getDefaultToolkit().beep();
            Thread.sleep(500000);
            RobotMain.findNpc(robot, myMousePoint, 80, 140);
            RobotMain.myMoveAndClick(robot, null);
            Thread.sleep(500);
            //对话传送
            myMousePoint.setLocation(312, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //走到五庄观
        if (MyCityEnum.WZG.equals(myCityEnum)) {
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.WZG.toString(),true,null,null);
            Point nextPoint = new Point(992, 349);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //走到狮驼岭
        if (MyCityEnum.STL.equals(myCityEnum)) {
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.STL.toString(),true,null,null);
            Point nextPoint = new Point(74,524);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //走到魔王寨
        if (MyCityEnum.MWZ.equals(myCityEnum)) {
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.MWZ.toString(),true,null,null);
            Point nextPoint = new Point(363, 114);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }


        //走到盘丝岭
        if (MyCityEnum.PSL.equals(myCityEnum)) {
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.PSL.toString(),true,null,null);
            Point nextPoint = new Point(524, 85);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }
        Thread.sleep(1500);
    }
}
