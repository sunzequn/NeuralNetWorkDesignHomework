package com.sunzequn.hebb.aann.ui;

import javax.swing.*;

/**
 * Created by sloriac on 15-10-12.
 */
public class MainUi {

    public static void main(String args[]){

        MyFrame myFrame = new MyFrame("Hebb");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(800, 400);
        myFrame.setVisible(true);

    }

}
