package com.yahoo;

import com.alibaba.fastjson.JSON;
import com.yahoo.biao.BiaoPath;
import com.yahoo.map.CAC;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;
import com.yahoo.model.MyLocation;
import com.yahoo.model.MyPoint;
import com.yahoo.util.ImgCmpUtil;
import com.yahoo.util.MyImageFingerPrint;
import com.yahoo.util.MyImageUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.yuque.com/yi7twv/zvqmrm/gc9sid
 * 204,152初始窗体坐标
 * 麻痹的必须以管理员说身份运行。真的很难受啊
 */
public class RobotMain {
    public final static Random random = new Random();
    public static boolean isInWar = Boolean.FALSE;
    public static AtomicInteger mapLock = new AtomicInteger(0);//1为关闭。0为打开
    public final static Logger logger = LoggerFactory.getLogger(RobotMain.class);
    public static String biaoTarget = "GYJJ";
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        Thread myAppThread = new Thread() {
            @Override
            public void run() {
                try{
                    myApplication(robot,true);
                }catch (Exception e){
                    logger.error(e.toString(),e);
                }
            }
        };
        myAppThread.start();
        Thread.sleep(2000);
        while (true) {
            try {
                //不停的运行监测郑旭
                if (!isInWar&&isAtWar(robot)) {
                    isInWar = Boolean.TRUE;
                    opWar(robot);
                    logger.info("DEBUG:键盘操作战斗完成。线程睡眠8s。时间长度根据任务动画调整");
                    //Thread.sleep(2   * 1000L);//预留出一场动画战斗的时间。大约10s
                    continue;
                } else if (isInWar) {
                    //判断出能不能找到小红点。如果能找到小红点说明确实不在战斗中了
                    logger.info("DEBUG:#####################################。");

                    MyPoint myPoint = getMyRedPointOnMiniMap(robot,2);
                    logger.info("DEBUG:@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@。");
                    if(null==myPoint){
                        opWar(robot);
                    }else{
                        isInWar = Boolean.FALSE;
                        logger.info("DEBUG:检测已经脱战。");
                        opMiniMap(robot,1);
                        new Thread() {
                            @Override
                            public void run() {
                                try{
                                    myApplication(robot,false);
                                }catch (Exception e){
                                    logger.error(e.toString(),e);
                                }
                            }
                        }.start();
                    }
                } else {
                    logger.info("DEBUG:未知情况XXXX。" + isInWar+ JSON.toJSONString( myAppThread.getState()));
                }
                Thread.sleep(2000L);
            } catch (Exception e) {
                logger.error(e.toString(),e);
            }
        }

    }

    private static void opWar(Robot robot) throws Exception {
        robot.keyPress(KeyEvent.VK_ALT);
        getRandomSleep();
        robot.keyPress(KeyEvent.VK_Q);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_Q);
        getRandomSleep();
        robot.keyPress(KeyEvent.VK_A);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_A);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public static void getRandomSleep() throws Exception {
        int sleepTime = random.nextInt(10) + 100;
        Thread.sleep(sleepTime);
    }


    public static void closeIDEActiveMy(Robot robot) throws Exception {
        Point point = new Point();
        //关闭IDE
        point.setLocation(1502, 8);
        logger.info("DEBUG:关闭IDE。。");
        moveAndClick(robot, point, -1);

        //激活梦幻窗体
        point.setLocation(430, 30);
        moveAndClick(robot, point, 0);
        logger.info("DEBUG:激活My窗体。。");
        //讲梦幻鼠标载入游戏中
        point.setLocation(550, 470);
        moveAndClick(robot, point, 0);
        logger.info("DEBUG:载入游戏鼠标。。");
    }

    public static void myApplication(Robot robot,boolean isInit) throws Exception {
        //设置Robot产生一个动作后的休眠时间,否则执行过快
        logger.info("DEBUG:myApplication START。。");
        if(isInit){
            robot.setAutoDelay(1);
            closeIDEActiveMy(robot);
            //关闭小地图。不管有没有都关闭。也好把鼠标放在窗体中
            opMiniMap(robot, 1);
        }
        Boolean isBiaoStop = Boolean.FALSE;
        if ("QQF".equals(biaoTarget)) {
            BiaoPath.toQQF(robot);
            return;
        }
        if ("GYJJ".equals(biaoTarget)) {
            BiaoPath.toGYJJ(robot);
            return;
        }
        //TODO 狮驼岭方向的各位走法
        if ("DDW".equals(biaoTarget)
        ||"EDW".equals(biaoTarget)
        ||"SDW".equals(biaoTarget)) {
            BiaoPath.toDDW(robot);
            return;
        }
        //孙婆婆方向的走法
        if ("SPP".equals(biaoTarget)) {
            BiaoPath.toSPP(robot);
            return;
        }
        //东海龙王
        if ("DHLW".equals(biaoTarget)) {
            BiaoPath.toDHLW(robot);
            return;
        }
        if ("ZYDX".equals(biaoTarget)) {
            BiaoPath.toZYDX(robot);
            return;
        }
        if ("NMW".equals(biaoTarget)) {
            BiaoPath.toNMW(robot);
            return;
        }
        if ("LJ".equals(biaoTarget)||"YJ".equals(biaoTarget)) {
            BiaoPath.toLJ(robot);
            return;
        }
        if ("KD".equals(biaoTarget)) {
            BiaoPath.toKD(robot);
            return;
        }
    }


    /**
     * @param point
     * @param myLocation
     * @param diffDistance
     * @return
     */
    public static boolean isNear(Point point, Point myLocation, String mouseOrUser,Integer diffDistance) {
        int absX = Math.abs(myLocation.x - point.x);
        int absY = Math.abs(myLocation.y - point.y);
        int distance = (int) Math.sqrt(absX * absX + absY * absY);
        diffDistance = null == diffDistance ? 10 : diffDistance;
        logger.info("DEBUG:本次距离里检测=" + distance+",mouseOrUser="+mouseOrUser);
        if (distance <= diffDistance) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取红点在坐标系的位置。
     *
     * @param robot
     * @return
     * @throws Exception
     */
    public static MyPoint getMyRedPointOnMiniMap(Robot robot,Integer maxFindCount) throws Exception {
        int loop =0;
        try{
            opMiniMap(robot, 0);
            while (true) {
                loop++;
                if(isInWar&&null==maxFindCount){
                    return null;
                }
                if(null!=maxFindCount&&( loop>maxFindCount)){
                    return null;
                }
                BufferedImage currentMapImage = getMyCurrentMap(robot);
                BufferedImage pointer = ImageIO.read(new File("redPoint.png"));
                Point mousePoint = ImgCmpUtil.isImageContain(currentMapImage, pointer);
                if (null == mousePoint) {
                    Thread.sleep(2000L);
                    continue;
                }
                MyPoint myPoint = new MyPoint();
                myPoint.setLocation(mousePoint.x + 3, mousePoint.y + 3);//TODO TODO 修正?
                myPoint.setLocation(myPoint.x + MyImageUtil.MAP_START_X, myPoint.y + MyImageUtil.MAP_START_Y);
                opMiniMap(robot, 1);
                return myPoint;
            }
        }catch (Exception e){
            logger.info(e.toString(),e);
            return null;
        }finally {
            opMiniMap(robot,1);
        }
    }

    private static BufferedImage getMyCurrentMap(Robot robot) {
        Point point = new Point();
        point.setLocation(MyImageUtil.MAP_START_X, MyImageUtil.MAP_START_Y);
        Rectangle screenRect = new Rectangle(point.x, point.y, MyImageUtil.MAP_W, MyImageUtil.MAP_H);
        BufferedImage currentMapImage = robot.createScreenCapture(screenRect);
        return currentMapImage;
    }


    public static void getClosePointer(Robot robot) throws Exception {
        opMiniMap(robot,0);
        BufferedImage currentMapImage = getMyCurrentMap(robot);
        BufferedImage pointer = ImageIO.read(new File("currentClose.png"));
        Point mousePoint = ImgCmpUtil.isImageContain(currentMapImage, pointer);
        System.err.println(JSON.toJSONString(mousePoint));
        opMiniMap(robot,1);
    }
    /**
     * @param robot
     * @return
     * @throws Exception
     */
    private static MyPoint getMyPointer(Robot robot) throws Exception {
        while (true) {
            if(isInWar){
                return null;
            }
            BufferedImage currentMapImage = getMyCurrentMap(robot);
            BufferedImage pointer = ImageIO.read(new File("pointer.png"));
            Point mousePoint = ImgCmpUtil.isImageContain(currentMapImage, pointer);
            boolean isOnNPC = Boolean.FALSE;
            if (null == mousePoint) {
                pointer = ImageIO.read(new File("new_pointer.png"));
                mousePoint = ImgCmpUtil.isImageContain(currentMapImage, pointer);
                if (null != mousePoint) {
                    isOnNPC = true;
                }
                logger.info("DEBUG:更换鼠标图片重新识别,选中状态" + JSON.toJSONString(mousePoint));
            }
            if (null == mousePoint) {
                Thread.sleep(500L);
                continue;
            }
            MyPoint myPoint = new MyPoint();
            myPoint.setLocation(mousePoint.x, mousePoint.y + 3);//TODO TODO 修正?
            myPoint.setLocation(myPoint.x + MyImageUtil.MAP_START_X, myPoint.y + MyImageUtil.MAP_START_Y);
            //减去鼠标形状差异,定位到尖端
            myPoint.setLocation(myPoint.x - 17, myPoint.y - 19);
            myPoint.setOnNPC(isOnNPC);
            return myPoint;
        }
    }

    /**
     * @param robot
     * @param isOpen
     * @throws Exception
     */
    private static void opMiniMap(Robot robot, int isOpen) throws Exception {
        synchronized (mapLock){
            /**
            if(1==mapLock.get()&&1==isOpen){
                //如果地图本来就是关闭的。指令也是关闭。返回
                return;
            }**/
            Point point = new Point();
            point.setLocation(560, 429);
            //关闭小地图不需要鼠标精确移动的
            moveTo(robot, point);
            //右键操作关闭任何地图
            logger.info("DEBUG:准备右键按下关闭地图");
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            getRandomSleep();
            logger.info("DEBUG:准备右键松开关闭地图");
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            mapLock.set(1);
            if (0 == isOpen) {
                /**
                if(0==mapLock.get()&&0==isOpen){
                    //如果地图本来就是打开的。指令也是打开。返回
                    return;
                }**/
                logger.info("DEBUG:准备TAB打开地图");
                getRandomSleep();
                robot.keyPress(KeyEvent.VK_TAB);
                logger.info("DEBUG:按下TAB打开地图");
                getRandomSleep();
                getRandomSleep();
                robot.keyRelease(KeyEvent.VK_TAB);
                logger.info("DEBUG:松开TAB打开地图");
                mapLock.set(0);
            }
        }
    }

    public static void myMoveAndClick(Robot robot, Point myMousePoint) throws Exception {
        //游戏鼠标地图定位
        if (null != myMousePoint) {
            myMoveTo(robot, myMousePoint);
        }
        logger.info("DEBUG:准备按下左键。");
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        getRandomSleep();
        logger.info("DEBUG:准备松开左键。");
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        getRandomSleep();
    }

    /**
     * @param robot
     * @param myMousePoint
     * @throws Exception
     */
    private static void myMoveAndClickOnMiniMap(Robot robot, Point myMousePoint) throws Exception {
        opMiniMap(robot, 0);
        myMoveAndClick(robot, myMousePoint);
        opMiniMap(robot, 1);
    }

    /**
     * @param robot
     * @param myMousePoint  游戏鼠标在地图中的位置。
     * @throws Exception
     */
    public static void playerGoToPointByRedPoint(Robot robot, Point myMousePoint) throws Exception {
        myMoveAndClickOnMiniMap(robot, myMousePoint);
        //检测是否走到了
        int loopCount = 0;
        MyPoint myCurLocation;
        //上一次人物坐标的位置
        Point lastMyPoint = null;
        while (true) {
            loopCount++;
            if(isInWar){
                break;
            }
            //等待人物走位到指定坐标
            myCurLocation = getMyRedPointOnMiniMap(robot,null);
            if (null == myCurLocation) {
                logger.info("DEBUG:识别人物坐标失败。1s重试");
                Thread.sleep(500);
                continue;
            }
            //TODO 红点查找和坐标查找是有误差的。
            //TODO 红点放大到20 ,坐标在5以内
            if (isNear(myMousePoint, myCurLocation, "user",20)) {
                System.err.println("哈哈,我到了,休眠2s,地图晃动");
                Thread.sleep(5000L);
                return;
            }
            if (null != lastMyPoint && lastMyPoint.x == myCurLocation.x && lastMyPoint.y == myCurLocation.y) {
                //TODO 两次坐标计算发现人物没有动.也没有达到指定坐标。肯定是发生了事情啦
                logger.info("DEBUG:两次人物坐标未发生变化。");
                playerGoToPointByRedPoint(robot, myMousePoint);
                return;
            }
            lastMyPoint = myCurLocation;
            if (loopCount > 30) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                break;
            }
            Thread.sleep(3000);
        }
    }

    /**
     * 押镖的时候娶不到坐标。所以用小地图红点算法逼近是否Near
     */
    public static void playerGoToPointByXY(Robot robot, Point myMousePoint, Point myPlayerPoint, EntranceTypeEnum nextEntranceTypeEnum) throws Exception {
        myMoveAndClickOnMiniMap(robot, myMousePoint);
        //检测是否走到了
        int loopCount = 0;
        MyLocation myLocation;
        //上一次人物坐标的位置
        Point lastMyPoint = null;
        while (true) {
            loopCount++;
            if(isInWar){
               break;
            }
            //等待人物走位到指定坐标
            myLocation = getMyLocation(robot, 0, 1);
            if (null == myLocation) {
                logger.info("DEBUG:识别人物坐标失败。1s重试");
                Thread.sleep(1000);
                continue;
            }
            Point myPoint = new Point(myLocation.getX(), myLocation.getY());
            if (isNear(myPlayerPoint, myPoint, "user", 10)) {
                System.err.println("哈哈,我到了,休眠2s,地图晃动");
                Thread.sleep(5000L);
                break;
            }
            if (null != lastMyPoint && lastMyPoint.x == myPoint.x && lastMyPoint.y == myPoint.y) {
                //TODO 两次坐标计算发现人物没有动.也没有达到指定坐标。肯定是发生了事情啦
                playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, nextEntranceTypeEnum);
                return;
            }
            lastMyPoint = myPoint;

            if (loopCount > 30) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                break;
            }
            Thread.sleep(3000);
        }
    }


    public static boolean isAtWar(Robot robot) throws Exception {
        //TODO 这里可以检查红包的标志在不在.红包不在了那么就是遇到了弹层
        Point point = new Point(894, 292);
        Rectangle screenRect = new Rectangle(point.x, point.y, 66, 298);
        BufferedImage warImage = robot.createScreenCapture(screenRect);
        MyImageFingerPrint currentWar = new MyImageFingerPrint(warImage);
        MyImageFingerPrint war = new MyImageFingerPrint(ImageIO.read(new File("currentWar.png")));
        boolean result;
        double compareResult = currentWar.compare(war);
        if (compareResult > 0.63) {
            result = true;
        } else {
            result = false;
        }
        /**
        if(!result){
            MyPoint myPoint = getMyRedPointOnMiniMap(robot,2);
            if(null==myPoint){
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                java.awt.Toolkit.getDefaultToolkit().beep();
                result = true;
            }
        }
        **/
        logger.info("DEBUG:检查是否在战斗中。" + result + ":" + compareResult);
        return result;
        //0.7734375 这个就算在战斗中
    }

    private static void moveAndClick(Robot robot, Point point, int button) throws Exception {
        if (null != point) {
            moveTo(robot, point);
        }
        if (0 == button) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            getRandomSleep();
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } else if (1 == button) {
            robot.mousePress(InputEvent.BUTTON3_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
        } else if (2 == button) {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } else if (-1 == button) {

        }
        Thread.sleep(20L);
    }

    /**
     * 根据小地图获取游戏外坐标系的坐标
     *
     * @param robot
     * @param getCityFlag
     * @param getXYFlag
     * @return
     * @throws Exception
     */
    private static MyLocation getXYPointByRedCodeOnMinimap(Robot robot, int getCityFlag, int getXYFlag) throws Exception {
        return null;
    }

    public static MyLocation getMyLocation(Robot robot, int getCityFlag, int getXYFlag) throws Exception {
        MyLocation myLocation = new MyLocation();
        if (1 == getXYFlag) {
            Point point = new Point();
            point.setLocation(25, 122);
            Rectangle screenRect = new Rectangle(point.x, point.y, MyImageUtil.XY_W, MyImageUtil.XY_H);
            BufferedImage xyImage = robot.createScreenCapture(screenRect);
            MyImageUtil.zoomImageAndSave(xyImage, 3, "currentXY", "png");
            String xy = ImageOcr.getXY("currentXY.png");
            if (StringUtils.isEmpty(xy)) {
                return null;
            }
            int[] xyArr = getXY(xy);
            if (null == xyArr) {
                return null;
            }
            myLocation.setX(xyArr[0]);
            myLocation.setY(xyArr[1]);
        }
        if (1 == getCityFlag) {
            Point point = new Point();
            point.setLocation(29, 71);
            Rectangle screenRect = new Rectangle(point.x, point.y, 70, 16);
            BufferedImage cityImage = robot.createScreenCapture(screenRect);
            cityImage = MyImageUtil.getBlackPicture(cityImage);
            MyImageUtil.zoomImageAndSave(cityImage, 2, "currentCity", "png");
            String city = ImageOcr.getCity("currentCity.png");
            System.err.println(city);
            myLocation.setMyCity(transCity(city.trim()));
        }
        System.err.println("~~~~~~~~~~~~~~~~~~~~~" + JSON.toJSONString(myLocation));
        return myLocation;
    }

    private static MyCityEnum transCity(String cityStr) {
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
                || "龙古口".equals(cityStr)) {
            return MyCityEnum.LG;
        }

        if ("长安城".equals(cityStr)) {
            return MyCityEnum.CAC;
        }

        if ("江南野外".equals(cityStr)) {
            return MyCityEnum.JNYW;
        }
        if ("太唐国境".equals(cityStr)) {
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


        //水晶莒

        return null;
    }

    private static int[] getXY(String xyStr) {
        try {
            String s[] = xyStr.split(":");
            String x = s[1].trim();
            x = x.split("Y")[0].trim();
            String y = s[2].trim();
            int[] result = {Integer.valueOf(x), Integer.valueOf(y)};
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 游戏中的鼠标逼近定位到桌面坐标系
     *
     * @param robot
     * @param toPoint
     * @throws Exception
     */
    public static void myMoveTo(Robot robot, Point toPoint) throws Exception {
        int i=0;
        while (true) {
            i++;
            if (isInWar) {
                break;
            }
            MyPoint myPoint = getMyPointer(robot);
            if (null == myPoint) {
                getRandomSleep();
                continue;
            }
            if (isNear(myPoint, toPoint, "mouse",3)) {
                logger.info("DEBUG:游戏鼠标定位结束," + JSON.toJSONString(myPoint) + ",目标位置" + JSON.toJSONString(toPoint)+"经历次数"+i);
                break;
            }
            int diffX = toPoint.x - myPoint.x;
            int diffY = toPoint.y - myPoint.y;
            PointerInfo curPoint = MouseInfo.getPointerInfo();
            Point newPoint = new Point();
            //一次偏移完成容易鼠标在界外
            if(toPoint.x<100||toPoint.x>900||toPoint.y<100||toPoint.y>668){
                newPoint.setLocation(curPoint.getLocation().x + diffX/2, curPoint.getLocation().y + diffY/2);
            }else{
                newPoint.setLocation(curPoint.getLocation().x + diffX, curPoint.getLocation().y + diffY);
            }
            moveTo(robot, newPoint);
        }
        getRandomSleep();
    }

    private static void moveTo(Robot robot, Point point) {
        try {
            if (1 == 1) {
                robot.mouseMove(point.x, point.y);
                getRandomSleep();
                return;
            }
            PointerInfo curPoint = MouseInfo.getPointerInfo();
            Point currentPoint = curPoint.getLocation();
            int curX = currentPoint.x;
            int curY = currentPoint.y;
            int diffX = point.x - curX;
            int diffY = point.y - curY;
            int positiveX = diffX > 0 ? 1 : -1;
            int positiveY = diffY > 0 ? 1 : -1;
            //步长
            int step = Math.min(Math.abs(diffX), Math.abs(diffY));
            for (int i = 0; i < step; i++) {
                robot.mouseMove(curX, curY);
                curX = curX + 1 * positiveX;
                curY = curY + 1 * positiveY;
            }
            int surplusX = Math.abs(diffX) - step;
            int surplusY = Math.abs(diffY) - step;
            for (int i = 0; i < surplusX; i++) {
                robot.mouseMove(curX, curY);
                curX = curX + 1 * positiveX;
            }
            for (int i = 0; i < surplusY; i++) {
                robot.mouseMove(curX, curY);
                curY = curY + 1 * positiveY;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


    private static void playDiDi() throws Exception {
        java.awt.Toolkit.getDefaultToolkit().beep();
        //FileInputStream fileau=new FileInputStream("9026.mp3");
        //AudioStream as=new AudioStream(fileau);
        //AudioPlayer.player.start(as);
    }

    /**
     * 在指定区域滑动鼠标。确认鼠标onNpc的属性为ture
     * 将区域分割为15*15的子区域。鼠标一次划过
     *
     * @throws Exception
     */
    public static void findNpc(Robot robot, Point startPoint, int width, int height) throws Exception {
        robot.keyPress(KeyEvent.VK_ALT);
        getRandomSleep();
        robot.keyPress(KeyEvent.VK_H);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_H);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_ALT);

        //按下键盘F9
        int stepLength = 20;
        robot.keyPress(KeyEvent.VK_F9);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_F9);
        int startX = startPoint.x;
        int startY = startPoint.y;
        int xcount = width / stepLength + 1;
        int ycount = height / stepLength + 1;
        Point point = new Point();
        point.setLocation(startX, startY);
        for (int i = 0; i < ycount; i++) {
            for (int j = 0; j < xcount; j++) {
                System.err.println(i + "," + j);
                //myMoveTo(robot, point);
                moveTo(robot,point);//快一些
                MyPoint myPoint = getMyPointer(robot);
                System.err.println(JSON.toJSONString(myPoint));
                if (myPoint.isOnNPC()) {
                    return;
                }
                point.setLocation(point.x + stepLength, point.y);
            }
            point.setLocation(startX, point.y + stepLength);
        }
    }
}
