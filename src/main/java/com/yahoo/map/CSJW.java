package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class CSJW {
    public static void csjw(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //长寿村
        if (MyCityEnum.CSC.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(590, 315);
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myMousePoint, EntranceTypeEnum.DIRECT);
            myMousePoint.setLocation(547, 132);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        //天宫
        if (MyCityEnum.TG.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(376, 485);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myMousePoint, EntranceTypeEnum.DIRECT);
            if(1==1){
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
            //myMousePoint.setLocation(547, 132);
            //RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
