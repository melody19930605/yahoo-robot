package com.yahoo;

import com.alibaba.fastjson.JSON;
import com.yahoo.model.MyPoint;
import com.yahoo.util.MyImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DataCollectionMain {
    private static Object t = new Object();
    public static void main(String []args) throws Exception{
        //collectCity();
        collectTask();
        //collectRedPoint();
        //MyPoint myPoint = RobotMain.getMyRedPointOnMiniMap(new Robot());
        //System.err.println(JSON.toJSONString(myPoint));
        //collectWar();
        //collectClose();
        //collectWar();
        //RobotMain.getClosePointer(new Robot());
        //{"x":810,"y":361} 大唐境外的标准X
        //{"x":810,"y":361}

    }

    public static void collectRedPoint() throws Exception{
        Robot robot = new Robot();
        Point point = new Point(731, 490);
        Rectangle screenRect = new Rectangle(point.x, point.y, 5, 5);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        //cityImage = MyImageUtil.getBlackPicture(cityImage);
        MyImageUtil.zoomImageAndSave(cityImage, 1, "redPoint", "png");
    }

    public static void collectWar() throws Exception{
        Robot robot = new Robot();
        Point point = new Point(385, 280);
        Rectangle screenRect = new Rectangle(point.x, point.y, 44, 18);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        MyImageUtil.zoomImageAndSave(cityImage, 2, "currentWar111", "png");



    }

    public static void collectTask() throws Exception{
        Robot robot = new Robot();
        Point point = new Point(528, 355);
        Rectangle screenRect = new Rectangle(point.x, point.y, 162, 18);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        cityImage = MyImageUtil.getGrayPicture(cityImage);
        MyImageUtil.zoomImageAndSave(cityImage, 2, "currentTask", "png");
    }


    public static void collectClose() throws Exception{
        Robot robot = new Robot();
        Point point = new Point(810, 361);
        Rectangle screenRect = new Rectangle(point.x, point.y, 10, 10);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        //cityImage = MyImageUtil.getGrayPicture(cityImage);
        MyImageUtil.zoomImageAndSave(cityImage, 1, "currentClose", "png");
    }

    public static void collectCity() throws Exception{
        Robot robot = new Robot();
        Point point = new Point(29, 71);
        //point = new Point(526, 351);
        Rectangle screenRect = new Rectangle(point.x, point.y, 70, 16);
        //screenRect = new Rectangle(point.x, point.y, 162, 70);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        cityImage = MyImageUtil.getBlackPicture(cityImage);
        MyImageUtil.zoomImageAndSave(cityImage, 2, "currentCity", "png");
    }
}
