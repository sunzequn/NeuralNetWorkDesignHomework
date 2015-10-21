package com.sunzequn.svm.ui;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by sloriac on 15-10-20.
 */
public class MainUi {

    public static void main(String args[]) throws IOException {

        MyFrame myFrame = new MyFrame("SVM");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(450, 400);
        myFrame.setVisible(true);

    }

}
