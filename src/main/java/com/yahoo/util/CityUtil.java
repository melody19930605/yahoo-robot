package com.yahoo.util;

import com.yahoo.model.MyCityEnum;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;

public class CityUtil {

    public static MyCityEnum transCity(String cityStr) {

        if ("建邺捕".equals(cityStr)
                || "津邺捕".equals(cityStr)
                || "建邺城".equals(cityStr)) {
            return MyCityEnum.JY;
        }
        if ("东悔湾".equals(cityStr)
                || "东诲湾".equals(cityStr)
                || "东悔湾 ‘".equals(cityStr)
                || "东海湾".equals(cityStr)) {
            return MyCityEnum.DHW;
        }
        if ("龙古".equals(cityStr)
                || "龙古口".equals(cityStr)
                ||"水晶莒".equals(cityStr)){
            return MyCityEnum.LG;
        }
        if ("长安城".equals(cityStr)) {
            return MyCityEnum.CAC;
        }
        if ("江南野外".equals(cityStr)) {
            return MyCityEnum.JNYW;
        }
        if ("太唐国境".equals(cityStr)
        ||"犬庸国璋".equals(cityStr)) {
            return MyCityEnum.DTGJ;
        }
        if ("太唐憧外".equals(cityStr)) {
            return MyCityEnum.DTJW;
        }
        if ("长寿郊外".equals(cityStr)) {
            return MyCityEnum.CSJW;
        }
        if ("奏琼府".equals(cityStr)) {
            return MyCityEnum.QQF;
        }
        if ("化生寺".equals(cityStr)) {
            return MyCityEnum.HSS;
        }
        if ("傲耒国".equals(cityStr)) {
            return MyCityEnum.AL;
        }
        if ("女儿村".equals(cityStr)) {
            return MyCityEnum.NEC;
        }
        if ("昔陀山".equals(cityStr)) {
            return MyCityEnum.PTS;
        }
        if ("太唐莒府".equals(cityStr)) {
            return MyCityEnum.DTGF;
        }
        if ("盘丝岭".equals(cityStr)) {
            return MyCityEnum.PSL;
        }
        if ("狮 驼 岭".equals(cityStr)) {
            return MyCityEnum.STL;
        }
        if ("老雕洞".equals(cityStr)) {
            return MyCityEnum.LDD;
        }
        if ("藏经阁".equals(cityStr)) {
            return MyCityEnum.CJG;
        }
        if ("盘丝洞".equals(cityStr)) {
            return MyCityEnum.PSD;
        }
        if ("程咬金府".equals(cityStr)) {
            return MyCityEnum.CYJF;
        }
        if ("长风镖局".equals(cityStr)) {
            return MyCityEnum.CFBJ;
        }
        if("旺慕".equals(cityStr)){
            return MyCityEnum.MWZ;
        }
        if("花果山".equals(cityStr)){
            return MyCityEnum.HGS;
        }
        if("北俱芦洲".equals(cityStr)){
            return MyCityEnum.BJLZ;
        }
        if("长寿村".equals(cityStr)){
            return MyCityEnum.CSC;
        }
        if("万寸山".equals(cityStr)
        ||"方寸山".equals(cityStr)){
            return MyCityEnum.FCS;
        }
        if("潮 音 洞".equals(cityStr)){
            return MyCityEnum.CYD;
        }
        if("五庄观".equals(cityStr)){
            return MyCityEnum.WZG;
        }
        //灵台莒
        //地府
        return null;
    }
}
