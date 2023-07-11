package com.bootdo.common.config;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class TestTools {


    public static void main(String[] args) {
        int min = 0;
        int max = 5000;

        String strData = "";
        for (int i = 1; i <= 31; i++) {
            Random r = new Random(1);
             int ran1 =  (int) (Math.random()*(max-min)+min);
           // ran1 = new BigDecimal(ran1).setScale(2, RoundingMode.HALF_UP).doubleValue();
            strData += ran1 + ",";
            if (i%5 == 0){
                strData = strData + "\n";
            }
        }
        strData = strData.substring(0,strData.length()-2);
        strData = "["+strData+"] ;";
        System.out.println(strData);
    }
}
