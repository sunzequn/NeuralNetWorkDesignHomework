package com.sunzequn.svm.ui;

import com.sunzequn.svm.listener.CalculateButtonListener;
import com.sunzequn.svm.listener.ClearButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sloriac on 15-10-20.
 */
public class MyFrame extends JFrame {

    private Container mContainer;
    private BoxLayout mBoxLayout;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private MyGridPanel rightGridPanel;
    private MyGridPanel leftGridPanel;

    public MyFrame(String name) throws HeadlessException {
        super(name);
        init();
    }

    private void init() {
        mContainer = getContentPane();
        mBoxLayout = new BoxLayout(mContainer, BoxLayout.X_AXIS);
        mContainer.setLayout(mBoxLayout);
        leftGridPanel = new MyGridPanel();
        rightGridPanel = new MyGridPanel();

        initLeftPanel();
        initRightPanel();

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

        JButton calculateButton = new JButton("开始识别");
        calculateButton.addActionListener(new CalculateButtonListener());
        rightPanel.add(calculateButton);

        //控件之间添加间隙
        rightPanel.add(Box.createRigidArea(new Dimension(1, 20)));

        JButton clearButton = new JButton("清空操作");
        clearButton.addActionListener(new ClearButtonListener());
        rightPanel.add(clearButton);

        //控件之间添加间隙
        rightPanel.add(Box.createRigidArea(new Dimension(1, 20)));
        
        JLabel resLable = new JLabel();
        rightPanel.add(resLable);

        add(rightPanel);
    }
}
