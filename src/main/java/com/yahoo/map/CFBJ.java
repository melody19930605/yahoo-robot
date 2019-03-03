package com.yahoo.map;

import com.yahoo.ImageOcr;
import com.yahoo.RobotMain;
import com.yahoo.model.MyBiaoTargetEnum;
import com.yahoo.model.MyCityEnum;
import com.yahoo.util.BiaoUtil;
import com.yahoo.util.MyImageUtil;
import com.yahoo.util.SearchPointUtil;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static com.yahoo.RobotMain.*;

public class CFBJ {
    /**
     * 初始坐标0,0
     * @throws Exception
     * @xnparam robot
     */
    public static void cfbj(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //领取任务
        if(null==biaoTarget){
            MyBiaoTargetEnum temp = getBiaoStr(robot);
            if(null!=temp){
                biaoTarget = getBiaoStr(robot);
                return;
            }
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,"CFBJ_HUA",false,"imgsource/cfbj_hua.png",null);
            RobotMain.myMoveAndClick(robot,myMousePoint);
            Point userPoint = new Point(42,18);
            RobotMain.playerGoToPointByXY(robot, myMousePoint,userPoint,null);

            myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,"CFBJ_HUA",false,"imgsource/cfbj_hua.png",null);
            myMousePoint = new Point(myMousePoint.x-90,myMousePoint.y-50);
            RobotMain.myMoveAndClick(robot,myMousePoint);

            RobotMain.myMoveAndClick(robot,new Point(422,565));
            RobotMain.myMoveAndClick(robot,new Point(462,503));

            //右键关闭当前弹框
            robot.mousePress(InputEvent.BUTTON3_MASK);
            RobotMain.getRandomSleep();
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
            //获取任务
            biaoTarget = getBiaoStr(robot);
            return;
        }else{
            //走到长安
            Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,"CFBJ_OUT",false,"imgsource/cfbj_out.png",null);
            RobotMain.myMoveAndClick(robot,myMousePoint);
        }
        Thread.sleep(1500);
    }


    public static MyBiaoTargetEnum getBiaoStr(Robot robot){
        Point point = new Point(870,190);
        Rectangle screenRect = new Rectangle(point.x, point.y, 165, 70);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        cityImage = MyImageUtil.getColorPicture(cityImage,Color.RED,Color.BLACK);
        MyImageUtil.zoomImageAndSave(cityImage, 1, "currentBiao", "png");
        String biao = ImageOcr.getCity("currentBiao.png");
        System.err.println("@@"+biao+"!!!!!!!!!!!!!!!!!!!!!!");
        return  BiaoUtil.transBiao(biao);
    }
}
