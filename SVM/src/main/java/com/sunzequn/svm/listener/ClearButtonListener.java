package com.sunzequn.svm.listener;

import com.sunzequn.svm.ui.MyGridPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-20.
 */
public class ClearButtonListener implements ActionListener{

    private MyGridPanel leftGridPanel;

    public ClearButtonListener() {
    }

    public ClearButtonListener(MyGridPanel leftGridPanel) {
        this.leftGridPanel = leftGridPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftGridPanel.clearButtonColor();
    }
}
