package com.sunzequn.hebb.aann.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-13.
 */
public class CalculateButtonListener implements ActionListener {

    private JRadioButton selfRadioButton;
    private JRadioButton heteroRadioButton;

    public CalculateButtonListener(JRadioButton selfRadioButton, JRadioButton heteroRadioButton) {
        this.selfRadioButton = selfRadioButton;
        this.heteroRadioButton = heteroRadioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //自联想
        if(selfRadioButton.isSelected()){
            System.out.println("自联想");
        }
        //异联想
        else{
            System.out.println("异联想");
        }

    }
}
