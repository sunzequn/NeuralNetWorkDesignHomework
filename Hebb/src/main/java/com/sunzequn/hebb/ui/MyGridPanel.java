package com.sunzequn.hebb.ui;

import com.sunzequn.hebb.listener.GridButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sloriac on 15-10-12.
 */
public class MyGridPanel extends JPanel {

    private int buttonNums = 30;
    private GridLayout mGridLayout;
    private JButton[] mButton;

    public MyGridPanel() {
        super();
        init();
    }

    public MyGridPanel(int color[]) {
        super();
        init();
        drawButtonColor(color);
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

    public void drawButtonColor(int color[]){

        for(int i = 0; i < buttonNums; i++){
            JButton button = new JButton();
            if(color[i] == -1)
                button.setBackground(Color.white);
            else
                button.setBackground(Color.black);
            add(button);
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

}
