package cn.itcast.dubboxdemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public static void main(String[] args)throws Exception {
        me();




    }
    public static void me(){
        try {
            int i=3;
            if (i==2) {
                throw new Exception("");
            }
        } catch (Exception e) {
            System.out.println("laie");
            e.printStackTrace();

        }
    }
}
