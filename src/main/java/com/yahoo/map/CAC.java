package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;
import com.yahoo.model.MyLocation;
import com.yahoo.util.SearchPointUtil;

import java.awt.*;

public class CAC {
    public static void cac(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //江南野外
        if (MyCityEnum.JNYW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(781, 559);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(541, 4);
            Point nextPoint = new Point(913, 780);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //秦琼府
        if (MyCityEnum.QQF.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(336, 489);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(92, 78);
            Point nextPoint = new Point(375, 368);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //去往大唐国境
        if (MyCityEnum.DTGJ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(259, 556);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(19, 9);
            Point nextPoint = new Point(91, 778);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //车夫
        if (MyCityEnum.CF_GJ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(525, 525);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(281, 43);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint,null   );
            myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.CF_GJ.toString(),false,"imgsource/cac_cf.png",null);
            //RobotMain.myMoveTo(robot,myMousePoint);
            //java.awt.Toolkit.getDefaultToolkit().beep();
            //Thread.sleep(50000);
            RobotMain.findNpc(robot, myMousePoint, 140, 140);
            RobotMain.myMoveAndClick(robot, null);
            Thread.sleep(500L);
            //对话传送
            myMousePoint.setLocation(312, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //化生寺
        if (MyCityEnum.HSS.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation( 743,300);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(502, 270);
            Point nextPoint = new Point(755, 111);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //大唐官府
        if (MyCityEnum.DTGF.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation( 563,300);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(319, 270);
            Point nextPoint = new Point(249, 88);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        if (MyCityEnum.CFBJ.equals(myCityEnum)) {
            RobotMain.opInventory(robot,1);//关闭道具栏
            Point biaojuPoint = new Point(523,153);
            //MyLocation myLocation = RobotMain.getMyLocation(robot,0,1);
            //boolean isNearBiaoju = RobotMain.isNear(biaojuPoint,new Point(myLocation.getX(),myLocation.getY()),"user",5);
            //System.err.println(isNearBiaoju+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,"CFBJ_IN",false,"imgsource/cfbj_in.png",null);
            RobotMain.myMoveAndClick(robot,myMousePoint);
        }
        //防止切换场景
        Thread.sleep(1500);

    }
}
