package com.yahoo.model;

import java.awt.*;

public class MyPoint extends Point{
    boolean onNPC;

    public boolean isOnNPC() {
        return onNPC;
    }

    public void setOnNPC(boolean onNPC) {
        this.onNPC = onNPC;
    }
}
