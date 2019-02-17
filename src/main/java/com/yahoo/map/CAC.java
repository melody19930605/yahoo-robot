package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class CAC {
    public static void cac(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //江南野外
        if (MyCityEnum.JNYW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(781, 559);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(541, 4);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.DIRECT);
            myMousePoint.setLocation(913, 780);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //秦琼府
        if (MyCityEnum.QQF.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(336, 489);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(92, 78);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.DIRECT);
            myMousePoint.setLocation(375, 368);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //去往大唐国境
        if (MyCityEnum.DTGJ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(259, 556);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(19, 9);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.DIRECT);
            myMousePoint.setLocation(91, 778);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //车夫
        if (MyCityEnum.CF_GJ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(525, 525);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(281, 43);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.NPC);
            Point cheFuPoint = new Point(360, 372);
            RobotMain.findNpc(robot, cheFuPoint, 108, 140);
            RobotMain.myMoveAndClick(robot, null);
            //对话传送
            myMousePoint.setLocation(312, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            //关闭对话框
            //myMousePoint.setLocation(785, 445);
            //myMoveAndClick(robot,myMousePoint);
        }

        //化生寺
        if (MyCityEnum.HSS.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation( 743,300);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(502, 270);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.NPC);
            myMousePoint.setLocation(755, 111);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //大唐官府
        if (MyCityEnum.DTGF.equals(myCityEnum)) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            /**
            Point myMousePoint = new Point();
            myMousePoint.setLocation( 743,300);//大约定位到游戏的62,18
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(502, 270);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.NPC);
            myMousePoint.setLocation(755, 111);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            **/
        }




    }
}
