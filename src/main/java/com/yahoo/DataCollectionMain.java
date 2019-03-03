package com.yahoo;

import com.alibaba.fastjson.JSON;
import com.yahoo.util.ImgCmpUtil;
import com.yahoo.util.MyImageUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class DataCollectionMain {
    private static Object t = new Object();
    public static void main(String []args) throws Exception{
        Robot robot = new Robot();
        //collectTmpImg();
        //findImg(robot);
        test();
    }




    public static void test() throws Exception{
        BufferedImage ori = ImageIO.read(new File("xxxx59007891.png"));
        BufferedImage replaceImage = MyImageUtil.getColorPicture(ori,Color.RED,Color.BLACK);
        MyImageUtil.zoomImageAndSave(replaceImage, 1, "xxxx-red", "png");
        String s = ImageOcr.getCity("xxxx-red.png");
        System.err.println(s);

    }


    public static void collectTmpImg() throws Exception{
        Robot robot = new Robot();
        Point point = new Point(870,190);
        Rectangle screenRect = new Rectangle(point.x, point.y, 165, 70);
        BufferedImage cityImage = robot.createScreenCapture(screenRect);
        MyImageUtil.zoomImageAndSave(cityImage, 1, "xxxx"+new Random().nextInt(), "png");
    }

    public static void findImg(Robot robot) throws Exception{
        //293,72
        long start = System.currentTimeMillis();
        Point point = new Point(0, 0);
        Rectangle screenRect = new Rectangle(point.x, point.y, 1030, 829);
        BufferedImage searchImg = robot.createScreenCapture(screenRect);
            BufferedImage warImg = ImageIO.read(new File("imgsource/cfbj_hua.png"));
        Point battlePoint = ImgCmpUtil.isImageContain(searchImg, warImg);
        System.err.println(System.currentTimeMillis()-start);
        System.err.println(JSON.toJSONString(battlePoint));
    }


}
