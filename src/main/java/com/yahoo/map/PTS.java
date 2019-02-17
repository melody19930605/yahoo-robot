package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class PTS {
    public static void pts(Robot robot, MyCityEnum myCityEnum) throws Exception {
        if (MyCityEnum.CYD.equals(myCityEnum)) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            java.awt.Toolkit.getDefaultToolkit().beep();
            return;
        }
    }
}
