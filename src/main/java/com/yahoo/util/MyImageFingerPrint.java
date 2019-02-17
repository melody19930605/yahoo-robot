package com.yahoo.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * 均值哈希实现图像指纹比较
 *
 * @author guyadong
 */
public final class MyImageFingerPrint {
    /**
     * 图像指纹的尺寸,将图像resize到指定的尺寸，来计算哈希数组
     */
    private static final int HASH_SIZE = 16;
    /**
     * 保存图像指纹的二值化矩阵
     */
    private final byte[] binaryzationMatrix;

    public MyImageFingerPrint(byte[] hashValue) {
        if (hashValue.length != HASH_SIZE * HASH_SIZE) {
            throw new IllegalArgumentException(String.format("length of hashValue must be %d", HASH_SIZE * HASH_SIZE));
        }
        this.binaryzationMatrix = hashValue;
    }

    public MyImageFingerPrint(String hashValue) {
        this(toBytes(hashValue));
    }

    public MyImageFingerPrint(BufferedImage src) {
        this(hashValue(src));
    }

    private static byte[] hashValue(BufferedImage src) {
        BufferedImage hashImage = resize(src, HASH_SIZE, HASH_SIZE);
        byte[] matrixGray = (byte[])toGray(hashImage).getData().getDataElements(0, 0, HASH_SIZE, HASH_SIZE, null);
        return binaryzation(matrixGray);
    }

    /**
     * 从压缩格式指纹创建{@link MyImageFingerPrint}对象
     *
     * @param compactValue
     * @return
     */
    public static MyImageFingerPrint createFromCompact(byte[] compactValue) {
        return new MyImageFingerPrint(uncompact(compactValue));
    }

    public static boolean validHashValue(byte[] hashValue) {
        if (hashValue.length != HASH_SIZE) { return false; }
        for (byte b : hashValue) {
            if (0 != b && 1 != b) { return false; }
        }
        return true;
    }

    public static boolean validHashValue(String hashValue) {
        if (hashValue.length() != HASH_SIZE) { return false; }
        for (int i = 0; i < hashValue.length(); ++i) {
            if ('0' != hashValue.charAt(i) && '1' != hashValue.charAt(i)) { return false; }
        }
        return true;
    }

    public byte[] compact() {
        return compact(binaryzationMatrix);
    }

    /**
     * 指纹数据按位压缩
     *
     * @param hashValue
     * @return
     */
    private static byte[] compact(byte[] hashValue) {
        byte[] result = new byte[(hashValue.length + 7) >> 3];
        byte b = 0;
        for (int i = 0; i < hashValue.length; ++i) {
            if (0 == (i & 7)) {
                b = 0;
            }
            if (1 == hashValue[i]) {
                b |= 1 << (i & 7);
            } else if (hashValue[i] != 0) {
                throw new IllegalArgumentException("invalid hashValue,every element must be 0 or 1");
            }
            if (7 == (i & 7) || i == hashValue.length - 1) {
                result[i >> 3] = b;
            }
        }
        return result;
    }

    /**
     * 压缩格式的指纹解压缩
     *
     * @param compactValue
     * @return
     */
    private static byte[] uncompact(byte[] compactValue) {
        byte[] result = new byte[compactValue.length << 3];
        for (int i = 0; i < result.length; ++i) {
            if ((compactValue[i >> 3] & (1 << (i & 7))) == 0) { result[i] = 0; } else { result[i] = 1; }
        }
        return result;
    }

    /**
     * 字符串类型的指纹数据转为字节数组
     *
     * @param hashValue
     * @return
     */
    private static byte[] toBytes(String hashValue) {
        hashValue = hashValue.replaceAll("\\s", "");
        byte[] result = new byte[hashValue.length()];
        for (int i = 0; i < result.length; ++i) {
            char c = hashValue.charAt(i);
            if ('0' == c) { result[i] = 0; } else if ('1' == c) { result[i] = 1; } else {
                throw new IllegalArgumentException("invalid hashValue String");
            }
        }
        return result;
    }

    /**
     * 缩放图像到指定尺寸
     *
     * @param src
     * @param width
     * @param height
     * @return
     */
    private static BufferedImage resize(Image src, int width, int height) {
        BufferedImage result = new BufferedImage(width, height,
            BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = result.getGraphics();
        try {
            g.drawImage(src.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        } finally {
            g.dispose();
        }
        return result;
    }

    /**
     * 计算均值
     *
     * @param src
     * @return
     */
    private static int mean(byte[] src) {
        long sum = 0;
        // 将数组元素转为无符号整数
        for (byte b : src) { sum += (long)b & 0xff; }
        return (int)(Math.round((float)sum / src.length));
    }

    /**
     * 二值化处理
     *
     * @param src
     * @return
     */
    private static byte[] binaryzation(byte[] src) {
        byte[] dst = src.clone();
        int mean = mean(src);
        for (int i = 0; i < dst.length; ++i) {
            // 将数组元素转为无符号整数再比较
            dst[i] = (byte)(((int)dst[i] & 0xff) >= mean ? 1 : 0);
        }
        return dst;

    }

    /**
     * 转灰度图像
     *
     * @param src
     * @return
     */
    private static BufferedImage toGray(BufferedImage src) {
        if (src.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            return src;
        } else {
            // 图像转灰
            BufferedImage grayImage = new BufferedImage(src.getWidth(), src.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);
            new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null).filter(src, grayImage);
            return grayImage;
        }
    }

    @Override
    public String toString() {
        return toString(true);
    }

    /**
     * @param multiLine 是否分行
     * @return
     */
    public String toString(boolean multiLine) {
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        for (byte b : this.binaryzationMatrix) {
            buffer.append(0 == b ? '0' : '1');
            if (multiLine && ++count % HASH_SIZE == 0) { buffer.append('\n'); }
        }
        return buffer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyImageFingerPrint) {
            return Arrays.equals(this.binaryzationMatrix, ((MyImageFingerPrint)obj).binaryzationMatrix);
        } else { return super.equals(obj); }
    }

    /**
     * 与指定的压缩格式指纹比较相似度
     *
     * @param compactValue
     * @return
     * @see #compare(MyImageFingerPrint)
     */
    public float compareCompact(byte[] compactValue) {
        return compare(createFromCompact(compactValue));
    }

    /**
     * @param hashValue
     * @return
     * @see #compare(MyImageFingerPrint)
     */
    public float compare(String hashValue) {
        return compare(new MyImageFingerPrint(hashValue));
    }

    /**
     * 与指定的指纹比较相似度
     *
     * @param hashValue
     * @return
     * @see #compare(MyImageFingerPrint)
     */
    public float compare(byte[] hashValue) {
        return compare(new MyImageFingerPrint(hashValue));
    }

    /**
     * 与指定图像比较相似度
     *
     * @param image2
     * @return
     * @see #compare(MyImageFingerPrint)
     */
    public float compare(BufferedImage image2) {
        return compare(new MyImageFingerPrint(image2));
    }

    /**
     * 比较指纹相似度
     *
     * @param src
     * @return
     * @see #compare(byte[], byte[])
     */
    public float compare(MyImageFingerPrint src) {
        if (src.binaryzationMatrix.length != this.binaryzationMatrix.length) {
            throw new IllegalArgumentException("length of hashValue is mismatch");
        }
        return compare(binaryzationMatrix, src.binaryzationMatrix);
    }

    /**
     * 判断两个数组相似度，数组长度必须一致否则抛出异常
     *
     * @param f1
     * @param f2
     * @return 返回相似度(0.0 ~ 1.0)
     */
    private static float compare(byte[] f1, byte[] f2) {
        if (f1.length != f2.length) { throw new IllegalArgumentException("mismatch MyImageFingerPrint length"); }
        int sameCount = 0;
        for (int i = 0; i < f1.length; ++i) {
            if (f1[i] == f2[i]) { ++sameCount; }
        }
        return (float)sameCount / f1.length;
    }

    public static float compareCompact(byte[] f1, byte[] f2) {
        return compare(uncompact(f1), uncompact(f2));
    }

    public static float compare(BufferedImage image1, BufferedImage image2) {
        return new MyImageFingerPrint(image1).compare(new MyImageFingerPrint(image2));
    }


    public static void main(String []args) throws IOException {
        long start = System.currentTimeMillis();
        MyImageFingerPrint fp1 = new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p1.png")));
        MyImageFingerPrint fp2 =new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p2.png")));
        MyImageFingerPrint fp3 =new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p3.png")));
        MyImageFingerPrint fp4 =new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p4.png")));
        MyImageFingerPrint fp5 =new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p5.png")));
        MyImageFingerPrint fp6 =new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p6.png")));
        MyImageFingerPrint fp7 =new MyImageFingerPrint(ImageIO.read(new File("/Users/lifeng.zlf/workspace/yahoo-robot/p7.png")));
        System.out.println(fp1.toString(true));
        System.out.println(fp1.toString(true));
        System.out.println("sim2:"+fp1.compare(fp2));
        System.out.println("sim3:"+fp1.compare(fp3));
        System.out.println("sim4:"+fp1.compare(fp4));
        System.out.println("sim5:"+fp1.compare(fp5));
        System.out.println("sim6:"+fp1.compare(fp6));
        System.out.println("sim7:"+fp1.compare(fp7));
        System.out.println("rt:"+(System.currentTimeMillis()-start));
    }
}
