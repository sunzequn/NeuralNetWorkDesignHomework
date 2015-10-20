package com.sunzequn.svm.ui;

import javax.swing.*;

/**
 * Created by sloriac on 15-10-20.
 */
public class MainUi {

    public static void main(String args[]){

        MyFrame myFrame = new MyFrame("SVM");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 400);
        myFrame.setVisible(true);

    }

}
