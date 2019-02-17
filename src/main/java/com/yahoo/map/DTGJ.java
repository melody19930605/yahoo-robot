package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class DTGJ {
    public static void dtgj(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到大唐境外
        if (MyCityEnum.DTJW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(298, 549);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            myMousePoint.setLocation(85, 330);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }

        //走到普陀山
        if (MyCityEnum.PTS.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(527,567);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            //myMousePoint.setLocation(85, 330);
            //myMoveAndClick(robot, myMousePoint);
        }


    }
}
