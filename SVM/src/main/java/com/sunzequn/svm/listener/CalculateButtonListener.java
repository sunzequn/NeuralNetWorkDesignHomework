package com.sunzequn.svm.listener;

import com.sunzequn.svm.core.Calculator;
import com.sunzequn.svm.core.DataHandler;
import com.sunzequn.svm.ui.MyGridPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by sloriac on 15-10-20
 */
public class CalculateButtonListener implements ActionListener {

    private static int dimension = 30;
    private MyGridPanel leftGridPanel;
    private JLabel label;
    private DataHandler mDataHandler = new DataHandler();
    private Calculator mCalculator = new Calculator();
    private String testText = "SVM/src/main/resources/test.txt";

    public CalculateButtonListener() {
    }

    public CalculateButtonListener(MyGridPanel leftGridPanel, JLabel label) {
        this.leftGridPanel = leftGridPanel;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int[] color = leftGridPanel.getButtonColor();
        int[][] test = {color};
        mDataHandler.handleSamples(testText, test);
        try {
            int res = mCalculator.svm();
            label.setText("识别结果为:" + res);
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
