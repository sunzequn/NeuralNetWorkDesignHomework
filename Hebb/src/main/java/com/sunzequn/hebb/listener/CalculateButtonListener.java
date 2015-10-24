package com.sunzequn.hebb.listener;

import com.sunzequn.hebb.core.Calculator;
import com.sunzequn.hebb.ui.MyGridPanel;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sloriac on 15-10-13.
 */
public class CalculateButtonListener implements ActionListener {

    private static int dimension = 30;//点维数
    private JRadioButton selfRadioButton;//自联想按钮
    private JRadioButton heteroRadioButton;//异联想按钮
    private MyGridPanel leftGridPanel;
    private MyGridPanel rightMyGridPanel;
    private Calculator mCalculator;

    public CalculateButtonListener() {
    }

    public CalculateButtonListener(JRadioButton selfRadioButton, JRadioButton heteroRadioButton, MyGridPanel leftGridPanel, MyGridPanel rightMyGridPanel) {
        this.selfRadioButton = selfRadioButton;
        this.heteroRadioButton = heteroRadioButton;
        this.leftGridPanel = leftGridPanel;
        this.rightMyGridPanel = rightMyGridPanel;
        mCalculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] p = leftGridPanel.getButtonColor();
        Matrix matrix = DenseMatrix.Factory.importFromArray(p).transpose();
        int[][] array;
        //自联想
        if(selfRadioButton.isSelected())
            array = mCalculator.hebb(matrix, 1).toColumnVector(Calculation.Ret.NEW).toIntArray();
        //异联想
        else
            array = mCalculator.hebb(matrix, 2).toColumnVector(Calculation.Ret.NEW).toIntArray();
        rightMyGridPanel.drawButtonColor(array[0]);
    }
}
