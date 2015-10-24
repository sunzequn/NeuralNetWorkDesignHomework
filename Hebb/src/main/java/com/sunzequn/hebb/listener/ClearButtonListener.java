package com.sunzequn.hebb.listener;

import com.sunzequn.hebb.ui.MyGridPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-17.
 */
public class ClearButtonListener implements ActionListener{

    private MyGridPanel leftGridPanel;
    private MyGridPanel rightGridPanel;

    public ClearButtonListener() {
    }

    public ClearButtonListener(MyGridPanel leftGridPanel, MyGridPanel rightGridPanel) {
        this.leftGridPanel = leftGridPanel;
        this.rightGridPanel = rightGridPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftGridPanel.clearButtonColor();
        rightGridPanel.clearButtonColor();
    }
}
