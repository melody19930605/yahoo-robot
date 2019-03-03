package com.yahoo.util;

import com.alibaba.fastjson.JSON;
import com.yahoo.RobotMain;
import com.yahoo.model.MyCityEnum;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class SearchPointUtil {
    public static Point getPointOnMiniMap(Robot robot,String target,boolean isMiniMap,String img,Rectangle screenRect) throws Exception{
        Point battlePoint = null;
        int x = 0;
        int y = 0;
        if("CFBJ_HUA".equals(target)){
            x =300;
            y=244;
        }else if("CFBJ_IN".equals(target)){
            x =80;
            y=-55;
        }else if("CFBJ_OUT".equals(target)){
            x = -10;
            y = 10;
        }else  if("DHW_AL_CF".equals(target)){
            x = -106;
            y = -40;
        } else if("BATTLE_USER".equals(target)){
            x = 0;
            y=0;
        }else if("BIAOYIN".equals(target)){
            x = 10;
            y=10;
        }else if(MyCityEnum.DTJW_CSJW_TD.getCity().equals(target)){
            x = 133;
            y= 233;
        }else if(MyCityEnum.DTGJ_DTJW.getCity().equals(target)){
            x = -92;
            y= 65;
        }else if(MyCityEnum.DHW_XB.getCity().equals(target)){
            x = -80;
            y= 190;
        }else if(MyCityEnum.CF_GJ.getCity().equals(target)){
            x = 0;
            y=105;
        }else if(MyCityEnum.CSJW.getCity().equals(target)){
            x = -313;
            y= 60 ;
        }else if(MyCityEnum.STL.getCity().equals(target)) {
            x = -347;
            y= 18 ;

        }else if(MyCityEnum.MWZ.getCity().equals(target)) {
            x = -299;
            y = -30 ;
        }else if(MyCityEnum.PSL.getCity().equals(target)) {
            x = 131;
            y = -27 ;
        }else if(MyCityEnum.WZG.getCity().equals(target)) {
            x = 216;
            y = 8 ;
        }else{
            return null;
        }
        int loop =0;
        if(isMiniMap){
            RobotMain.opMiniMap(robot,0);
        }else{
            RobotMain.opMiniMap(robot,1);
            robot.keyPress(KeyEvent.VK_ALT);
            RobotMain.getRandomSleep();
            robot.keyPress(KeyEvent.VK_H);
            RobotMain.getRandomSleep();
            robot.keyRelease(KeyEvent.VK_H);
            RobotMain.getRandomSleep();
            robot.keyRelease(KeyEvent.VK_ALT);
            //按下键盘F9
            robot.keyPress(KeyEvent.VK_F9);
            RobotMain.getRandomSleep();
            robot.keyRelease(KeyEvent.VK_F9);
        }

        if(StringUtils.isEmpty(img)){
            img = "imgsource/dtjw_miao.png";
        }
        while(null==battlePoint){
            loop++;
            if(loop>3){
                break;
            }
            if(null==screenRect){
                screenRect = new Rectangle(0, 0, 1030, 829);
            }
            BufferedImage searchImg = robot.createScreenCapture(screenRect);
            //MyImageUtil.zoomImageAndSave(searchImg, 1, "wocao"+new Random().nextInt(), "png");
            BufferedImage warImg = ImageIO.read(new File(img));
            battlePoint = ImgCmpUtil.isImageContain(searchImg, warImg);
            if(null==battlePoint){
                continue;
            }
            battlePoint.setLocation(battlePoint.x+x,battlePoint.y+y);
            System.err.println(JSON.toJSONString(battlePoint)+"loop"+loop+"findfindfindfindfindfindfind");
            if(null!=battlePoint){
                break;
            }
            battlePoint = ImgCmpUtil.isImageContain(searchImg, warImg);

        }
        return battlePoint;
    }
}
