package com.sunzequn.svm.ui;

import com.sunzequn.svm.listener.GridButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sloriac on 15-10-20.
 */
public class MyGridPanel extends JPanel {

    private int buttonNums = 30;
    private GridLayout mGridLayout;
    private JButton[] mButton;

    public MyGridPanel() {
        super();
        init();
    }

    private void init(){
        mGridLayout = new GridLayout(6, 5);
        mButton = new JButton[buttonNums];
        setLayout(mGridLayout);
        for(int i = 0; i < buttonNums; i++){
            mButton[i] = new JButton();
            mButton[i].setBackground(Color.white);
            mButton[i].addActionListener(new GridButtonListener(mButton[i]));
            add(mButton[i]);
        }
    }

    public int[] getButtonColor(){
        int[] color = new int[buttonNums];
        for(int i = 0; i < buttonNums; i++){
            if(mButton[i].getBackground() == Color.black)
                color[i] = 1;
            else
                color[i] = -1;
        }
        return color;
    }

    public void clearButtonColor(){
        for(int i = 0; i < buttonNums; i++)
            mButton[i].setBackground(Color.white);
    }
}
