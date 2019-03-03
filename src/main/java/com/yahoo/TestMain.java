package com.yahoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class TestMain {
    private final static Logger logger = LoggerFactory.getLogger(TestMain.class);
    private static Object t = new Object();
    public static void main(String []args) throws Exception{
        logger.info("sssssssssssssssssssss");
        playVoice();
        //Point point = SearchPointUtil.getPointOnMiniMap(new Robot(), MyCityEnum.CF_GJ.toString(),false,"imgsource/cac_cf.png");
        //System.err.println(JSON.toJSONString(point));
        /**
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(500L);
                    }catch (Exception e){

                    }

                        System.err.println("thread1~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
        };
        thread1.start();
        int i = 0;
        while(true){
            i++;
            Thread.sleep(500L);
            if(i%5==0){
                System.err.println(i+"##############");
                thread1.interrupt( );
            }else if(i%8==0){
                System.err.println(i+"##############");
                thread1.start();
            }
        }
        **/
    }


    public static void playVoice() throws Exception{
        // 创建音乐文件输入流对象
        File f = new File("9026.mp3");
        AudioClip aau = Applet.newAudioClip(f.toURL());;
        aau.play();//循环播放 aau.play() 单曲 aau.stop()停止播放
    }
}
