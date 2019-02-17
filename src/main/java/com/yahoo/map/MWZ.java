package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class MWZ {
    public static void mwz(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //TODO 走到魔王洞
        if (MyCityEnum.CSJW.equals(myCityEnum)) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
            /**
            Point myMousePoint = new Point();
            myMousePoint.setLocation(609, 563);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myMousePoint, EntranceTypeEnum.DIRECT);

            myMousePoint.setLocation(705, 604);
            RobotMain.myMoveAndClick(robot, myMousePoint);

            //对话传送
            myMousePoint.setLocation(325, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
             **/
        }
    }
}
