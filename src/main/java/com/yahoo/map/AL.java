package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;
import java.awt.event.InputEvent;

public class AL {
    /**
     * 初始坐标0,0
     *
     * @throws Exception
     * @xnparam robot
     */
    public static void al(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //走向东海湾
        if (MyCityEnum.HGS.equals(myCityEnum)) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }
        if (MyCityEnum.NEC.equals(myCityEnum)) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }


    }
}
