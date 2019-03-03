package com.yahoo.biao;

import com.yahoo.RobotMain;
import com.yahoo.map.*;
import com.yahoo.model.MyBiaoTargetEnum;
import com.yahoo.model.MyCityEnum;
import com.yahoo.model.MyLocation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

import static com.yahoo.RobotMain.biaoTarget;
import static com.yahoo.RobotMain.isInWar;

public class BiaoPath {
    public final static Logger logger = LoggerFactory.getLogger(BiaoPath.class);

    private static int ON_BATTLE = 0;
    private static int NO_CITY = 1;
    //其实每个while 里面都有了sleep,不需要在外面sleep了,这里要考虑一下时间调整
    private static Long CITY_CHANGE_SLEEP = 500L;

    private static void flagCity(MyLocation myLocation){
        RobotMain.currentCity = myLocation.getMyCity();
        if(null!=RobotMain.lastCity && !RobotMain.lastCity.equals(RobotMain.currentCity)){
            RobotMain.isNear = Boolean.FALSE;
        }
        RobotMain.lastCity =  RobotMain.currentCity;
    }

    /**
     * 领取镖人物
     */
    public static void toBIAO(Robot robot) throws Exception{
        while (true) {
            if(isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            MyBiaoTargetEnum curBiao = CFBJ.getBiaoStr(robot);
            if(null!=curBiao){
                biaoTarget = curBiao;
                return;
            }
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }else if(MyCityEnum.CAC.equals(myLocation.getMyCity())){
                CAC.cac(robot,MyCityEnum.CFBJ);
            }else{
                //飞长安
                RobotMain.opInventory(robot,0);
                //点开旗子
                Point qiziPoint = new Point(792,316);
                RobotMain.myMoveAndClick(robot,qiziPoint,1);
                //小地图点击飞过去
                Point biaojuMiniPoint = new Point(764,429);
                biaojuMiniPoint = new Point(772,429);
                RobotMain.myMoveAndClick(robot,biaojuMiniPoint,0);
                //检测是否到了镖局附近
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }


    /**
     * 程咬金
     */
    public static void toCYJ(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.DTGF);
            }
            if (MyCityEnum.DTGF.equals(myLocation.getMyCity())) {
                DTGF.dtgf(robot,MyCityEnum.CYJF);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }



    /**
     * 空渡
     * @param robot
     * @throws Exception
     */
    public static void toKD(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.HSS);
            }
            if (MyCityEnum.HSS.equals(myLocation.getMyCity())) {
                HSS.hss(robot, MyCityEnum.CJG);
            }
            if (MyCityEnum.CJG.equals(myLocation.getMyCity())) {
                CJG.cjg(robot, null);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }

    /**
     * 秦琼府
     */
    public static void toQQF(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.QQF);
            }
            if (MyCityEnum.QQF.equals(myLocation.getMyCity())) {
                QQF.toQQ(robot,null);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }

    /**
     *  观音姐姐
     */
    public static void toGYJJ(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.DTGJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.PTS);
            }
            if (MyCityEnum.PTS.equals(myLocation.getMyCity())) {
                PTS.pts(robot,MyCityEnum.CYD);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }

    /**
     * 大大王
     * @param robot
     * @throws Exception
     */
    public static void toDDW(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.CF_GJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.DTJW);
            }
            if (MyCityEnum.DTJW.equals(myLocation.getMyCity())) {
                DTJW.dtjw(robot, MyCityEnum.STL);
            }
            if (MyCityEnum.STL.equals(myLocation.getMyCity())) {
                STL.stl(robot, MyCityEnum.STL);
            }
            //三大王
            if (MyCityEnum.STL.equals(myLocation.getMyCity())) {
                STL.stl(robot, MyCityEnum.YWD);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }


    public static void toDZW(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.CF_GJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.DF);
            }
            if (MyCityEnum.DF.equals(myLocation.getMyCity())) {
                DF.df(robot, MyCityEnum.SLD);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }


    public static void toBJJ(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.CF_GJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.DTJW);
            }
            if (MyCityEnum.DTJW.equals(myLocation.getMyCity())) {
                DTJW.dtjw(robot, MyCityEnum.PSL);
            }
            if (MyCityEnum.PSL.equals(myLocation.getMyCity())) {
                PSL.psl(robot, MyCityEnum.PSD);
            }
            if (MyCityEnum.PSD.equals(myLocation.getMyCity())) {
                PSD.psd(robot, MyCityEnum.PSD);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }


    /**
     * 牛魔王
     * @param robot
     * @throws Exception
     */
    public static void toNMW(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.CF_GJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.DTJW);
            }
            if (MyCityEnum.DTJW.equals(myLocation.getMyCity())) {
                DTJW.dtjw(robot, MyCityEnum.MWZ);
            }
            if (MyCityEnum.MWZ.equals(myLocation.getMyCity())) {
                MWZ.mwz(robot, MyCityEnum.MWJ);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }

    /**
     * 李靖
     * @param robot
     * @throws Exception
     */
    public static void toLJ(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.CF_GJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.DTJW);
            }
            if (MyCityEnum.DTJW.equals(myLocation.getMyCity())) {
                DTJW.dtjw(robot, MyCityEnum.CSJW);
            }
            if (MyCityEnum.CSJW.equals(myLocation.getMyCity())) {
                CSJW.csjw(robot, MyCityEnum.TG);
            }
            if (MyCityEnum.TG.equals(myLocation.getMyCity())) {
                TG.tg(robot, MyCityEnum.LXBD);
            }
            if (MyCityEnum.LXBD.equals(myLocation.getMyCity())) {
                LXBD.lxbd(robot, MyCityEnum.LXBD);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }

    /**
     * 镇元大仙
     * @param robot
     * @throws Exception
     */
    public static void toZYDX(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.CF_GJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.DTJW);
            }
            if (MyCityEnum.DTJW.equals(myLocation.getMyCity())) {
                DTJW.dtjw(robot, MyCityEnum.WZG);
            }
            if (MyCityEnum.WZG.equals(myLocation.getMyCity())) {
                WZG.wzg(robot, MyCityEnum.WZG);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }

    /**
     * 孙婆婆
     * @param robot
     * @throws Exception
     */
    public static void toSPP(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.JNYW);
            }
            if (MyCityEnum.JNYW.equals(myLocation.getMyCity())) {
                JNYW.jnyw(robot, MyCityEnum.JY);
            }
            if (MyCityEnum.JY.equals(myLocation.getMyCity())) {
                JY.jy(robot, MyCityEnum.DHW);
            }
            if (MyCityEnum.DHW.equals(myLocation.getMyCity())) {
                DHW.dhw(robot, MyCityEnum.AL);
            }
            if (MyCityEnum.AL.equals(myLocation.getMyCity())) {
                AL.al(robot, MyCityEnum.NEC);
            }
            if (MyCityEnum.NEC.equals(myLocation.getMyCity())) {
                NEC.nec(robot, MyCityEnum.NEC);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }


    /**
     * 东海龙王
     * @param robot
     * @throws Exception
     */
    public static void toDHLW(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.JNYW);
            }
            if (MyCityEnum.JNYW.equals(myLocation.getMyCity())) {
                JNYW.jnyw(robot, MyCityEnum.JY);
            }
            if (MyCityEnum.JY.equals(myLocation.getMyCity())) {
                JY.jy(robot, MyCityEnum.DHW);
            }
            if (MyCityEnum.DHW.equals(myLocation.getMyCity())) {
                DHW.dhw(robot, MyCityEnum.LG);
            }
            if (MyCityEnum.LG.equals(myLocation.getMyCity())) {
                LG.lg(robot, MyCityEnum.SJG);
            }
            if (MyCityEnum.SJG.equals(myLocation.getMyCity())) {
                SJG.sjg(robot, null);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }


    /**
     * 菩提祖师
     * @param robot
     * @throws Exception
     */
    public static void toPTZS(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            flagCity(myLocation);
            if (MyCityEnum.CFBJ.equals(myLocation.getMyCity())) {
                CFBJ.cfbj(robot, null);
            }
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.JNYW);
            }
            if (MyCityEnum.JNYW.equals(myLocation.getMyCity())) {
                JNYW.jnyw(robot, MyCityEnum.JY);
            }
            if (MyCityEnum.JY.equals(myLocation.getMyCity())) {
                JY.jy(robot, MyCityEnum.DHW);
            }
            if (MyCityEnum.DHW.equals(myLocation.getMyCity())) {
                DHW.dhw(robot, MyCityEnum.AL);
            }
            if (MyCityEnum.AL.equals(myLocation.getMyCity())) {
                AL.al(robot, MyCityEnum.HGS);
            }
            if (MyCityEnum.HGS.equals(myLocation.getMyCity())) {
                HGS.hgs(robot, MyCityEnum.BJLZ);
            }
            if (MyCityEnum.BJLZ.equals(myLocation.getMyCity())) {
                BJLZ.bjlz(robot, MyCityEnum.CSJW);
            }
            if (MyCityEnum.CSJW.equals(myLocation.getMyCity())) {
                CSJW.csjw(robot, MyCityEnum.CSC);
            }
            if (MyCityEnum.CSC.equals(myLocation.getMyCity())) {
                CSC.cac(robot, MyCityEnum.FCS);
            }
            if (MyCityEnum.FCS.equals(myLocation.getMyCity())) {
                FCS.fcs(robot, MyCityEnum.FCS);
            }
            Thread.sleep(CITY_CHANGE_SLEEP);
        }
    }
}
