package com.sunzequn.hebb.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-12.
 */
public class GridButtonListener implements ActionListener {

    private JButton mButton;

    public GridButtonListener(JButton mButton) {
        this.mButton = mButton;
    }

    public void actionPerformed(ActionEvent e) {

        if(mButton.getBackground() == Color.black)
            mButton.setBackground(Color.white);
        else
            mButton.setBackground(Color.black);

    }
}
