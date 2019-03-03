package com.yahoo;

import com.alibaba.fastjson.JSON;
import com.yahoo.biao.BiaoPath;
import com.yahoo.model.*;
import com.yahoo.util.*;
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

/**
 * https://www.yuque.com/yi7twv/zvqmrm/gc9sid
 * 204,152初始窗体坐标目标位置
 * 麻痹的必须以管理员说身份运行。真的很难受啊
 */
public class RobotMain {
    public final static Random random = new Random();
    public static boolean isInWar = Boolean.FALSE;
    public static MyCityEnum currentCity;
    public static MyCityEnum lastCity;
    public static boolean isNear = Boolean.FALSE;
    public final static Logger logger = LoggerFactory.getLogger(RobotMain.class);
    public static MyBiaoTargetEnum biaoTarget = null;

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
                //不停的运行监测战斗
                MyBattle myBattle = checkBattle(robot);
                if (myBattle.isBlock()) {
                    isInWar = Boolean.TRUE;
                    logger.info("warwarwarwarwarwarwarwarwarwar");
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    Thread.sleep(2000L);
                } else if(myBattle.isInBattle()){
                    isInWar = Boolean.TRUE;
                    boolean isOpBattle = checkBattleOp(robot);
                    if(isOpBattle){
                        opWar(robot);
                        Thread.sleep(2000L);
                    }
                }else{
                    if(Thread.State.TERMINATED.equals( myAppThread.getState())){
                        isInWar = Boolean.FALSE;
                        myAppThread = new Thread() {
                            @Override
                            public void run() {
                                try{
                                    myApplication(robot,false);
                                }catch (Exception e){
                                    logger.error(e.toString(),e);
                                }
                            }
                        };
                        myAppThread.start();
                    }
                }
            } catch (Exception e) {
                logger.error(e.toString(),e);
            }
        }
    }

    private static void opWar(Robot robot) throws Exception {
        robot.keyPress(KeyEvent.VK_ALT);
        getRandomSleep();
        robot.keyPress(KeyEvent.VK_A);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_A);
        getRandomSleep();
        robot.keyPress(KeyEvent.VK_A);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_A);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    public static void getRandomSleep() throws Exception {
        int sleepTime = random.nextInt(10) + 200;
        Thread.sleep(sleepTime);
    }


    public static void closeIDEActiveMy(Robot robot) throws Exception {
        Point point = new Point();
        //关闭IDE
        point.setLocation(1502, 8);
        moveAndClick(robot, point, -1);
        //激活梦幻窗体
        point.setLocation(430, 30);
        moveAndClick(robot, point, 0);
        //梦幻鼠标载入游戏中
        point.setLocation(550, 470);
        moveAndClick(robot, point, -1);
    }

    public static void myApplication(Robot robot,boolean isInit) throws Exception {
        //设置Robot产生一个动作后的休眠时间,否则执行过快
        logger.info("DEBUG:。。。myApplication START。。。");
        if(isInit){
            robot.setAutoDelay(1);
            closeIDEActiveMy(robot);
        }
        if(null==biaoTarget){
            BiaoPath.toBIAO(robot);
            return;
        }
        if (MyBiaoTargetEnum.QQ.equals(biaoTarget)) {
            BiaoPath.toQQF(robot);
            return;
        }
        if (MyBiaoTargetEnum.GYJJ.equals(biaoTarget)) {
            BiaoPath.toGYJJ(robot);
            return;
        }
        //TODO 狮驼岭方向的各位走法
        if (MyBiaoTargetEnum.DDW.equals(biaoTarget)
        ||MyBiaoTargetEnum.EDW.equals(biaoTarget)
        ||MyBiaoTargetEnum.SDW.equals(biaoTarget)) {
            BiaoPath.toDDW(robot);
            return;
        }
        //孙婆婆方向的走法
        if (MyBiaoTargetEnum.SPP.equals(biaoTarget)) {
            BiaoPath.toSPP(robot);
            return;
        }
        //东海龙王
        if (MyBiaoTargetEnum.DHLW.equals(biaoTarget)) {
            BiaoPath.toDHLW(robot);
            return;
        }
        if (MyBiaoTargetEnum.ZYDX.equals(biaoTarget)) {
            BiaoPath.toZYDX(robot);
            return;
        }
        if (MyBiaoTargetEnum.NMW.equals(biaoTarget)) {
            BiaoPath.toNMW(robot);
            return;
        }
        if (MyBiaoTargetEnum.LJ.equals(biaoTarget)||MyBiaoTargetEnum.YJ.equals(biaoTarget)) {
            BiaoPath.toLJ(robot);
            return;
        }
        if (MyBiaoTargetEnum.KD.equals(biaoTarget)) {
            BiaoPath.toKD(robot);
            return;
        }
        if (MyBiaoTargetEnum.CYJ.equals(biaoTarget)) {
            BiaoPath.toCYJ(robot);
            return;
        }
        if (MyBiaoTargetEnum.BBGN.equals(biaoTarget)||MyBiaoTargetEnum.HSN.equals(biaoTarget)) {
            BiaoPath.toBJJ(robot);
            return;
        }
        if (MyBiaoTargetEnum.PTZS.equals(biaoTarget)) {
            BiaoPath.toPTZS(robot);
            return;
        }
        if (MyBiaoTargetEnum.DZW.equals(biaoTarget)) {
            BiaoPath.toDZW(robot);
            return;
        }
        //地藏王
        if (MyBiaoTargetEnum.DZW.equals(biaoTarget)) {
            BiaoPath.toDZW(robot);
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
     * 获取地图上的红点在坐标系的位置。
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
                if(loop>5){
                    return null;
                }
                if(isInWar){
                    return null;
                }
                if(null!=maxFindCount&&( loop>maxFindCount)){
                    return null;
                }
                BufferedImage currentMapImage = getMyCurrentMap(robot);
                BufferedImage pointer = ImageIO.read(new File("redPoint.png"));
                Point mousePoint = ImgCmpUtil.isImageContain(currentMapImage, pointer);
                if (null == mousePoint) {
                    Thread.sleep(500L);
                    continue;
                }
                MyPoint myPoint = new MyPoint();
                myPoint.setLocation(mousePoint.x + 3, mousePoint.y + 3);//TODO TODO 修正?
                myPoint.setLocation(myPoint.x + MyImageUtil.MAP_START_X, myPoint.y + MyImageUtil.MAP_START_Y);
                return myPoint;
            }
        }catch (Exception e){
            logger.error(e.toString(),e);
            return null;
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
    public static MyPoint getMyPointer(Robot robot) throws Exception {
        int loop=0;
        while (true) {
            if(loop>5){
                return null;
            }
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
                //尝试右键鼠标。有可能正在攻击目标
                //robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                //getRandomSleep();
                //robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
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
     * 操作物品栏
     * @param robot
     * @param isOpen
     * @throws Exception
     */
    public static void opInventory(Robot robot, int isOpen) throws Exception {
        Rectangle screenRect = new Rectangle(0, 0, 1030, 829);
        BufferedImage searchImg = robot.createScreenCapture(screenRect);
        BufferedImage mapImg = ImageIO.read(new File("imgsource/daojulan.png"));
        Point daojuPoint = ImgCmpUtil.isImageContain(searchImg, mapImg);
        if(1==isOpen){
            if(null==daojuPoint){
                return;//说明本来就是关闭的
            }
        }
        if (0 == isOpen) {
            if (null != daojuPoint) {
                return;//说明本来就是打开的
            }
        }
        logger.info("DEBUG:准备TAB关闭道具");
        robot.keyPress(KeyEvent.VK_ALT);
        getRandomSleep();
        robot.keyPress(KeyEvent.VK_E);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_E);
        getRandomSleep();
        robot.keyRelease(KeyEvent.VK_ALT);
    }
    /**
     * @param robot
     * @param isOpen
     * @throws Exception
     */
    public static void opMiniMap(Robot robot, int isOpen) throws Exception {
        Rectangle screenRect = new Rectangle(0, 0, 1030, 829);
        BufferedImage searchImg = robot.createScreenCapture(screenRect);
        BufferedImage mapImg = ImageIO.read(new File("imgsource/map_shijie.png"));
        Point mapPoint = ImgCmpUtil.isImageContain(searchImg, mapImg);
        /****/
        if(1==isOpen){
            if(null==mapPoint){
                return;//说明本来就是关闭的
            }
            logger.info("DEBUG:准备TAB关闭地图");
            robot.keyPress(KeyEvent.VK_TAB);
            getRandomSleep();
            robot.keyRelease(KeyEvent.VK_TAB);
            getRandomSleep();
        }
        if (0 == isOpen) {
            if(null!=mapPoint){
                return;//说明本来就是打开的
            }
            logger.info("DEBUG:准备TAB打开地图");
            robot.keyPress(KeyEvent.VK_TAB);
            getRandomSleep();
            robot.keyRelease(KeyEvent.VK_TAB);
            getRandomSleep();
            getRandomSleep();
        }
    }

    /**
     * 0是左键。
     * 1是右键
     * @param robot
     * @param myMousePoint
     * @param mouseType
     * @throws Exception
     */
    public static void myMoveAndClick(Robot robot, Point myMousePoint,int mouseType) throws Exception {
        //游戏鼠标地图定位
        if (null != myMousePoint) {
            myMoveTo(robot, myMousePoint);
        }
        if(0==mouseType){
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            logger.info("DEBUG:准备松开左键。");
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            getRandomSleep();
        }else if(1==mouseType){
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            logger.info("DEBUG:准备松开右键。");
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            getRandomSleep();
        }

    }
    public static void myMoveAndClick(Robot robot, Point myMousePoint) throws Exception {
        myMoveAndClick(robot,myMousePoint,0);
    }

    /**
     * @param robot
     * @param myMousePoint
     * @throws Exception
     */
    private static void myMoveAndClickOnMiniMap(Robot robot, Point myMousePoint) throws Exception {
        opMiniMap(robot, 0);
        myMoveAndClick(robot, myMousePoint);
    }

    /**
     * @param robot
     * @param myMousePoint  游戏鼠标在地图中的位置。
     * @throws Exception
     */
    public static void playerGoToPointByRedPoint(Robot robot, Point myMousePoint,Point nextPoint) throws Exception {
        if(isNear){
            return;
        }
        myMoveAndClickOnMiniMap(robot, myMousePoint);
        if("ZYDX".equals(biaoTarget) && currentCity.equals(MyCityEnum.DTJW)){
            Thread.sleep(6000L);
        }
        //地图上鼠标会挡住小红点。鼠标随便移走
        //moveTo(robot,new Point(500,500));
        if(null!=nextPoint){
            myMoveTo(robot,nextPoint);
        }else{
            moveTo(robot,new Point(250,250));
        }
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
            myCurLocation = getMyRedPointOnMiniMap(robot,3);
            if (null == myCurLocation) {
                logger.info("DEBUG:识别人物坐标失败。1s重试");
                Thread.sleep(500);
                continue;
            }
            //TODO 红点查找和坐标查找是有误差的。
            //TODO 红点放大到20 ,坐标在5以内
            //这个数据在五庄观很微妙25
            //当两次坐标不再变化的时候,再去检测距离到了没有
            if (null != lastMyPoint && lastMyPoint.x == myCurLocation.x && lastMyPoint.y == myCurLocation.y) {
                if (isNear(myMousePoint, myCurLocation, "user",40)) {
                    System.err.println("哈哈,我到了,休眠2s,地图晃动");
                    isNear = Boolean.TRUE;
                    opMiniMap(robot,1);
                    Thread.sleep(1500L);
                    return;
                }else{
                    //TODO 两次坐标计算发现人物没有动.也没有达到指定坐标。肯定是发生了事情啦
                    logger.error("DEBUG:两次人物坐标未发生变化。");
                    playerGoToPointByRedPoint(robot, myMousePoint,nextPoint);
                    return;
                }
            }
            lastMyPoint = myCurLocation;
            //慢一点检查。防止没走到近似坐标
            Thread.sleep(500);
        }
    }

    /**
     * 识别地图上个的XY坐标。计算是否逼近
     */
    public static void playerGoToPointByXY(Robot robot, Point myMousePoint, Point myPlayerPoint, Point nextPoint) throws Exception {
        if(isNear){
            return;
        }
        myMoveAndClickOnMiniMap(robot, myMousePoint);
        if(null!=nextPoint){
            myMoveTo(robot,nextPoint);
        }
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
                Thread.sleep(500);
                continue;
            }
            Point myPoint = new Point(myLocation.getX(), myLocation.getY());
            if (isNear(myPlayerPoint, myPoint, "user", 10)) {
                System.err.println("哈哈,我到了,休眠2s,地图晃动");
                opMiniMap(robot,1);
                Thread.sleep(2000L);
                break;
            }
            if (null != lastMyPoint && lastMyPoint.x == myPoint.x && lastMyPoint.y == myPoint.y) {
                //TODO 两次坐标计算发现人物没有动.也没有达到指定坐标。
                logger.error("DEBUG:两次人物坐标未发生变化。");
                playerGoToPointByXY(robot, myMousePoint, myPlayerPoint, nextPoint);
                return;
            }
            lastMyPoint = myPoint;
            Thread.sleep(2000);
        }
    }
    public static boolean checkBattleOp(Robot robot) throws Exception {
        //检查是否有操作界面。如果有操作界面那么操作
        //TODO
        Point myMousePoint = SearchPointUtil.getPointOnMiniMap(robot,"BATTLE_USER",false,"imgsource/battle_user.png",null);
        if(null!=myMousePoint){
            return true;
        }
        return false;
    }
    public static MyBattle checkBattle(Robot robot) throws Exception {
        Point point = new Point(972, 757);
        Rectangle screenRect = new Rectangle(point.x, point.y, 100, 100);
        BufferedImage searchImg = robot.createScreenCapture(screenRect);
        BufferedImage warImg = ImageIO.read(new File("imgsource/battle_gong.png"));
        Point battlePoint = ImgCmpUtil.isImageContain(searchImg, warImg);
        if(null==battlePoint){
            //宫殿
            return new MyBattle(true,true);
        }else{
            point = new Point(0, 150);
            screenRect = new Rectangle(point.x, point.y, 60, 60);
            searchImg = robot.createScreenCapture(screenRect);
            warImg = ImageIO.read(new File("imgsource/cc.png"));
            battlePoint = ImgCmpUtil.isImageContain(searchImg, warImg);
            if(null==battlePoint){
                //CC不见了
                return new MyBattle(true,false);
            }
        }
        return new MyBattle(false,false);
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
            MyCityEnum cityEnum = null;
            int loop =0;
            while(null==cityEnum){
                loop++;
                Point point = new Point();
                point.setLocation(29, 71);
                Rectangle screenRect = new Rectangle(point.x, point.y, 70, 16);
                BufferedImage cityImage = robot.createScreenCapture(screenRect);
                cityImage = MyImageUtil.getColorPicture(cityImage,Color.WHITE,Color.BLACK);
                MyImageUtil.zoomImageAndSave(cityImage, 2, "currentCity", "png");
                String city = ImageOcr.getCity("currentCity.png");
                cityEnum = CityUtil.transCity(city.trim());
                System.err.println("........................"+JSON.toJSONString(city.trim()));
                System.err.println("........................"+JSON.toJSONString(cityEnum));
                if(loop>5){
                    break;
                }
            }
            myLocation.setMyCity(cityEnum);
        }
        return myLocation;
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
        if(null==toPoint){
            return;
        }
        int i=0;
        while (true) {
            i++;
            if (isInWar) {
                break;
            }
            MyPoint myPoint = getMyPointer(robot);
            if (null == myPoint) {
                logger.error("myPoint is null!");
                getRandomSleep();
                continue;
            }
            if (isNear(myPoint, toPoint, "mouse",1)) {
                logger.info("经历次数"+i);
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

    public static void moveTo(Robot robot, Point point) {
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
        int stepLength = 20;
        int stepHeight = 30;
        int startX = startPoint.x;
        int startY = startPoint.y;
        int xcount = width / stepLength + 1;
        int ycount = height / stepHeight + 1;
        Point point = new Point();
        point.setLocation(startX, startY);
        for (int i = 0; i < ycount; i++) {
            for (int j = 0; j < xcount; j++) {
                System.err.println(i + "," + j);
                moveTo(robot,point);//快一些
                MyPoint myPoint = getMyPointer(robot);
                System.err.println(JSON.toJSONString(myPoint));
                if (myPoint.isOnNPC()) {
                    return;
                }
                point.setLocation(point.x + stepLength, point.y);
            }
            point.setLocation(startX, point.y + stepHeight);
        }
    }
}
