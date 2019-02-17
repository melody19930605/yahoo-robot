package com.yahoo.map;

import com.yahoo.RobotMain;
import com.yahoo.model.EntranceTypeEnum;
import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class TG {
    public static void tg(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //TODO 凌霄宝殿
        if (MyCityEnum.LXBD.equals(myCityEnum)) {
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
