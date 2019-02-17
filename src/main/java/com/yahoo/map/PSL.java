package com.yahoo.map;

import com.yahoo.model.MyCityEnum;

import java.awt.*;

public class PSL {
    public static void psl(Robot robot, MyCityEnum myCityEnum) throws Exception {
        //TODO 凌霄宝殿
        if (MyCityEnum.PSD.equals(myCityEnum)) {
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
