package com.sunzequn.svm.listener;

import com.sunzequn.svm.ui.MyGridPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-20
 */
public class CalculateButtonListener implements ActionListener {

    private static int dimension = 30;
    private MyGridPanel leftGridPanel;

    public CalculateButtonListener() {
    }

    public CalculateButtonListener(MyGridPanel leftGridPanel, MyGridPanel rightMyGridPanel) {
        this.leftGridPanel = leftGridPanel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
