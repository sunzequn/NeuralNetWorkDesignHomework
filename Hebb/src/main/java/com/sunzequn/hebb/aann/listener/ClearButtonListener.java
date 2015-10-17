package com.sunzequn.hebb.aann.listener;

import com.sunzequn.hebb.aann.ui.MyGridPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-17.
 */
public class ClearButtonListener implements ActionListener{

    private MyGridPanel leftGridPanel;
    private MyGridPanel rightMyGridPanel;

    public ClearButtonListener() {
    }

    public ClearButtonListener(MyGridPanel leftGridPanel, MyGridPanel rightMyGridPanel) {
        this.leftGridPanel = leftGridPanel;
        this.rightMyGridPanel = rightMyGridPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftGridPanel.clearButtonColor();
        rightMyGridPanel.clearButtonColor();
    }
}
