package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.InputEvent;

public class JY {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void jy(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走向东海湾
        if (MyCityEnum.DHW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(757, 509);//大约定位到游戏的267,29
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(267, 29);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint);
            //走到东海湾
            //TODO 其实应该尝试多种走法。因为人物会在一个区域
            myMousePoint.setLocation(939, 452);
            RobotMain.myMoveTo(robot, myMousePoint);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            RobotMain.getRandomSleep();
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        /**
        if (MyCityEnum.JNYW.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(253, 553);//大约定位到游戏的267,29
            Point myPlayerPoint = new Point();
            myPlayerPoint.setLocation(6, 3);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint, myPlayerPoint, EntranceTypeEnum.NPC);
            //选中城门守卫
            myMousePoint.setLocation(351, 646);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            //说话传送
            myMousePoint.setLocation(329, 479);
            RobotMain.myMoveAndClick(robot, myMousePoint);
            //关闭对话框
            myMousePoint.setLocation(785, 445);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        **/
    }
}
