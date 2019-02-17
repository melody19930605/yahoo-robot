package com.yahoo.biao;

import com.yahoo.RobotMain;
import com.yahoo.map.*;
import com.yahoo.model.MyCityEnum;
import com.yahoo.model.MyLocation;

import java.awt.*;

public class BiaoPath {
    /**
     * 程咬金
     */
    public static void toCYJ(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.DTGF);
            }
            if (MyCityEnum.DTGF.equals(myLocation.getMyCity())) {
                DTGF.dtgf(robot,MyCityEnum.CYJ);
            }
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);
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
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.HSS);
            }
            if (MyCityEnum.HSS.equals(myLocation.getMyCity())) {
                HSS.hss(robot, MyCityEnum.CJG);
            }
            if (MyCityEnum.CJG.equals(myLocation.getMyCity())) {
                HSS.hss(robot, null);
            }
            Thread.sleep(2000);
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
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.QQF);
            }
            if (MyCityEnum.QQF.equals(myLocation.getMyCity())) {
                QQF.toQQ(robot,null);
            }
            Thread.sleep(2000);
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
            if (MyCityEnum.CAC.equals(myLocation.getMyCity())) {
                CAC.cac(robot, MyCityEnum.DTGJ);
            }
            if (MyCityEnum.DTGJ.equals(myLocation.getMyCity())) {
                DTGJ.dtgj(robot, MyCityEnum.PTS);
            }
            if (MyCityEnum.PTS.equals(myLocation.getMyCity())) {
                PTS.pts(robot,MyCityEnum.CYD);
            }
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
                STL.stl(robot, MyCityEnum.DDW);
            }
            Thread.sleep(3000);
        }
    }

    public static void toBJJ(Robot robot) throws Exception{
        while (true) {
            if(RobotMain.isInWar){
                break;
            }
            MyLocation myLocation = RobotMain.getMyLocation(robot, 1, 0);
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
            Thread.sleep(3000);
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
                //TODO TODO
                MWZ.mwz(robot, MyCityEnum.CSJW);
            }
            if (MyCityEnum.MWD.equals(myLocation.getMyCity())) {
                //TODO TODO
                MWD.mwd(robot, null);
            }

            Thread.sleep(3000);
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
            Thread.sleep(3000);
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
            //TODO
            Thread.sleep(3000);
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
            //TODO 苏婆婆
            Thread.sleep(3000);
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
            //TODO
            Thread.sleep(3000);
        }
    }
}
