package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;
import com.yahoo.model.MyNPCEnum;
import com.yahoo.model.MyPoint;
import com.yahoo.util.SearchPointUtil;

import java.awt.*;

public class DHW {
    public static void dhw(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到傲来国
        if (MyCityEnum.AL.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(491, 530);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyNPCEnum.DHW_AL_CF.toString(),false,"imgsource/dhw_szz.png",null);
            //RobotMain.myMoveTo(robot, myMousePoint);
            //java.awt.Toolkit.getDefaultToolkit().beep();
            //Thread.sleep(10000L);
            RobotMain.findNpc(robot, myMousePoint, 270, 70);
            RobotMain.myMoveAndClick(robot, null);
            //对话传送
            myMousePoint.setLocation(312, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        //龙宫，找虾米
        if (MyCityEnum.LG.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(603, 361);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.DHW_XB.toString(),false,"imgsource/dhw_ys.png",null);
            //RobotMain.myMoveTo(robot,myMousePoint);
            //java.awt.Toolkit.getDefaultToolkit().beep();
            //Thread.sleep(500000);
            RobotMain.findNpc(robot, myMousePoint, 80, 80);
            RobotMain.myMoveAndClick(robot, null);
            //对话传送
            myMousePoint.setLocation(312, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        Thread.sleep(1500);
    }
}
