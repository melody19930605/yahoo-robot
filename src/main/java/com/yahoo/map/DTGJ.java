package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;
import com.yahoo.util.ImgCmpUtil;
import com.yahoo.util.SearchPointUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class DTGJ {
    public static void dtgj(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走到大唐境外
        if (MyCityEnum.DF.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(349, 264);//大约定位到游戏的62,18
            Point nextPoint = new Point(555, 147);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //走到大唐境外
        if (MyCityEnum.DTJW.equals(myCityEnum)) {
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,MyCityEnum.DTGJ_DTJW.toString(),true,"imgsource/dtgj_jss.png",null);
            Point nextPoint = new Point(85, 330);
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
            RobotMain.myMoveAndClick(robot, null);
        }

        //走到普陀山
        if (MyCityEnum.PTS.equals(myCityEnum)) {
            Point myMousePoint = new Point();
            myMousePoint.setLocation(527,567);//大约定位到游戏的62,18
            RobotMain.playerGoToPointByRedPoint(robot, myMousePoint,null);
            //找一下土地老儿身边仙人掌的坐标。点过去
            robot.keyPress(KeyEvent.VK_F9);
            RobotMain.getRandomSleep();
            robot.keyRelease(KeyEvent.VK_F9);
            Rectangle screenRect = new Rectangle(0,0,600,400);
            BufferedImage searchImg = robot.createScreenCapture(screenRect);
            BufferedImage xrzImg = ImageIO.read(new File("imgsource/pts_syz.png"));
            Point mousePoint = ImgCmpUtil.isImageContain(searchImg, xrzImg);
            Point startPoint =  new Point(mousePoint.x+270,mousePoint.y+180);
            RobotMain.findNpc(robot, startPoint, 250, 250);
            RobotMain.myMoveAndClick(robot, null);
            //对话传送
            myMousePoint.setLocation(312, 480);
            RobotMain.myMoveAndClick(robot, myMousePoint);
        }
        Thread.sleep(1500);

    }
}
