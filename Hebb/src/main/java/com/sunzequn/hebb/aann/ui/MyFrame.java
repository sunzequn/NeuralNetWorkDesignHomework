package com.sunzequn.hebb.aann.ui;

import com.sunzequn.hebb.aann.listener.CalculateButtonListener;
import com.sunzequn.hebb.aann.listener.ClearButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sloriac on 15-10-12.
 */
public class MyFrame extends JFrame {

    private Container mContainer;
    private BoxLayout mBoxLayout;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel midPanel;
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
        initMidPanel();
        initRightPanel();

    }

    private void initLeftPanel() {

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftGridPanel.setPreferredSize(new Dimension(300, 400));
        leftPanel.add(leftGridPanel);

        add(leftPanel);

    }

    private void initMidPanel() {
        midPanel = new JPanel();
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));

        JRadioButton selfRadioButton = new JRadioButton("自联想");
        selfRadioButton.setSelected(true);
        JRadioButton heteroRadioButton = new JRadioButton("异联想");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(selfRadioButton);
        buttonGroup.add(heteroRadioButton);
        midPanel.add(selfRadioButton);
        midPanel.add(heteroRadioButton);

        JButton calculateButton = new JButton("开始识别");
        calculateButton.addActionListener(new CalculateButtonListener(selfRadioButton, heteroRadioButton, leftGridPanel, rightGridPanel));
        midPanel.add(calculateButton);

        //按钮之间添加间隙
        midPanel.add(Box.createRigidArea(new Dimension(1, 20)));

        JButton clearButton = new JButton("清空操作");
        clearButton.addActionListener(new ClearButtonListener(leftGridPanel, rightGridPanel));
        midPanel.add(clearButton);

        add(midPanel);
    }

    private void initRightPanel() {

        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightGridPanel.setPreferredSize(new Dimension(300, 400));
        rightPanel.add(rightGridPanel);
        add(rightPanel);
    }
}
