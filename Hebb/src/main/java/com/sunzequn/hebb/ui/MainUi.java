package com.sunzequn.hebb.ui;

import javax.swing.*;

/**
 * Created by sloriac on 15-10-12.
 * 工程的入口程序，运行main函数即可
 */
public class MainUi {

    public static void main(String args[]){

        MyFrame myFrame = new MyFrame("Hebb");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(800, 400);
        myFrame.setVisible(true);

    }

}
