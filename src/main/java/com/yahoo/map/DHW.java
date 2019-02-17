package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class DHW {
    public static void dhw(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到傲来国
        if (MyCityEnum.AL.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(491, 530);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            if(1==1){
                //TODO 找车夫
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }
        //龙宫，找虾米
        if (MyCityEnum.LG.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(603, 361);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            //选中城门守卫
            myMousePoint.setLocation(858, 590);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            //说话传送
            myMousePoint.setLocation(329, 479);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            //关闭对话框
            myMousePoint.setLocation(785, 445);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
