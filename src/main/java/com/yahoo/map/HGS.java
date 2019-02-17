package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class HGS {
    public static void hgs(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到北俱芦洲
        if (MyCityEnum.BJLZ.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(368, 346);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByXY(robot, myMousePoint, myMousePoint, EntranceTypeEnum.DIRECT);
            myMousePoint.setLocation(479, 469);
            RobotMain.myMoveAndClick(robot, myMousePoint);

            //对话传送
            myMousePoint.setLocation(325, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
    }
}
