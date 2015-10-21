package com.sunzequn.svm.ui;

import com.sunzequn.svm.core.Calculator;
import com.sunzequn.svm.listener.CalculateButtonListener;
import com.sunzequn.svm.listener.ClearButtonListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by sloriac on 15-10-20.
 */
public class MyFrame extends JFrame {

    private Container mContainer;
    private BoxLayout mBoxLayout;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private MyGridPanel leftGridPanel;
    private JLabel resLable;
    private Calculator mCalculator = new Calculator();

    public MyFrame(String name) throws IOException {
        super(name);
        init();
    }

    private void init() throws IOException {
        mContainer = getContentPane();
        mBoxLayout = new BoxLayout(mContainer, BoxLayout.X_AXIS);
        mContainer.setLayout(mBoxLayout);
        leftGridPanel = new MyGridPanel();

        initLeftPanel();
        initRightPanel();
        mCalculator.init();

    }

    private void initLeftPanel() {

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftGridPanel.setPreferredSize(new Dimension(300, 400));
        leftPanel.add(leftGridPanel);

        add(leftPanel);

    }

    private void initRightPanel() {

        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JButton clearButton = new JButton("清空操作");
        JButton calculateButton = new JButton("开始识别");
        resLable = new JLabel();

        calculateButton.addActionListener(new CalculateButtonListener(leftGridPanel, resLable));
        rightPanel.add(calculateButton);

        //控件之间添加间隙
        rightPanel.add(Box.createRigidArea(new Dimension(1, 20)));

        clearButton.addActionListener(new ClearButtonListener(leftGridPanel));
        rightPanel.add(clearButton);

        //控件之间添加间隙
        rightPanel.add(Box.createRigidArea(new Dimension(1, 20)));

        rightPanel.add(resLable);

        add(rightPanel);
    }
}
