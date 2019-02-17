package com.yahoo.util;

import com.alibaba.fastjson.JSON;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;

public class MyImageUtil {

    public static final int XY_W = 83;
    public static final int XY_H = 14;

    public static final int MAP_W = 1035;
    public static final int MAP_H = 833;


    public static final int MAP_START_X = 0;
    public static final int MAP_START_Y = 0;

    public static void zoomImageAndSave(BufferedImage bufImg,int size,String fileName,String suffix){
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(size, size), null);
        Image itemp = ato.filter(bufImg, null);
        File file = new File(fileName+"."+suffix);
        try {
            ImageIO.write((BufferedImage) itemp,suffix, file); //写入缩减后的图片
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 背景黑色话,文字保留白色
     * @param originalImage
     * @return
     */
    public static BufferedImage getBlackPicture(BufferedImage originalImage){
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int[] rgbArr = originalImage.getRGB(0, 0, width, height, null/*数组*/, 0, width);
        for(int i=0;i<rgbArr.length;i++){
            if(rgbArr[i]!=Color.white.getRGB()){
                rgbArr[i] = Color.BLACK.getRGB();
            }
        }
        originalImage.setRGB(0, 0, width, height, rgbArr, 0, width);
        return originalImage;
    }

    /**
     * 图片灰度处理
     * @param originalImage
     * @return
     */
    public static BufferedImage getGrayPicture(BufferedImage originalImage){
        BufferedImage grayPicture;
        int imageWidth = originalImage.getWidth();
        int imageHeight = originalImage.getHeight();

        grayPicture = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_3BYTE_BGR);
        ColorConvertOp cco = new ColorConvertOp(ColorSpace
                .getInstance(ColorSpace.CS_GRAY), null);
        cco.filter(originalImage, grayPicture);
        return grayPicture;
    }

    public static void main(String[] args) throws Exception{
        BufferedImage bufferedImage = ImageIO.read(new File("xy1.png"));
        zoomImageAndSave(bufferedImage,3,"xy11111","png");
    }
}
