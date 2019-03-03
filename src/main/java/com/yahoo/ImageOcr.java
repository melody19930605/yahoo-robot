package com.yahoo;

import com.alibaba.fastjson.JSON;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.net.URL;

public class ImageOcr {
    private static  ITesseract instance;
    public static void main(String[] args) throws Exception {
        /**
        for(int i=0;i<15;i++){
            String fileName = "xy"+i+".png";
            //System.err.println(getXY(fileName));
        }
        String city = getTask("biao_5_dhlw.png");
        city = city.replaceAll("\\n","");
        System.err.println("||"+city+"||");
        //getCity();
        //2倍的押镖任务识别的不错
        **/
        System.err.println("||"+getBiao("biao_11_qq.png")+"||");
    }

    public static String getBiao(String fileName){
        Long start = System.currentTimeMillis();
        String s =  getStringFromImage(fileName,"mybiao");
        Long cost = System.currentTimeMillis() - start;
        System.err.println(cost);
        return s;
    }

    public static String getTask(String fileName){
        return getCity(fileName);
    }

    public static String getCity(String fileName){
        Long start = System.currentTimeMillis();
        String s =  getStringFromImage(fileName,"chi_sim");
        s = s.replaceAll("\\n","");
        //s =  getStringFromImage(fileName,"mycity");
        Long cost = System.currentTimeMillis() - start;
        System.err.println(cost);
        return s;
    }

    public static String getXY(String fileName){
        Long start = System.currentTimeMillis();
        String s =  getStringFromImage(fileName,"myxy");;
        Long cost = System.currentTimeMillis() - start;
        //System.out.println("DEBUG:识别人物坐标,"+ JSON.toJSONString(s)+",耗时"+cost);
        return s;
    }


    private static String getStringFromImage(String fileName,String lanage){
        if(null==instance){
            instance = new Tesseract();
        }
        File imageFile = new File(fileName);
        instance.setLanguage(lanage);
        //instance.setDatapath("C:\\java_space\\yahoo-robot\\tessdata");//OK,也可以不设置
        String result = null;
        try {
            result = instance.doOCR(imageFile);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
