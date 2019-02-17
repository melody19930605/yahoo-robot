package com.yahoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class TestMain {
    private final static Logger logger = LoggerFactory.getLogger(TestMain.class);
    private static Object t = new Object();
    public static void main(String []args) throws Exception{
        logger.info("sssssssssssssssssssss");
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(500L);
                    }catch (Exception e){

                    }

                        System.err.println("thread1~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
        };
        thread1.start();
        int i = 0;
        while(true){
            i++;
            Thread.sleep(500L);
            if(i%5==0){
                System.err.println(i+"##############");
                thread1.interrupt( );
            }else if(i%8==0){
                System.err.println(i+"##############");
                thread1.start();
            }
        }

    }
}
