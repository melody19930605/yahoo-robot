package com.yahoo.model;

import java.awt.*;

public class MyBattle{
    private boolean inBattle;
    private boolean block;

    public MyBattle(boolean inBattle,boolean block){
        this.inBattle = inBattle;
            this.block = block;
    }

    public boolean isInBattle() {
        return inBattle;
    }

    public void setInBattle(boolean inBattle) {
        this.inBattle = inBattle;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
