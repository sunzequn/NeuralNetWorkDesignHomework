package com.sunzequn.hebb.aann.listener;

import com.sunzequn.hebb.aann.core.Calculator;
import com.sunzequn.hebb.aann.ui.MyGridPanel;
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

    private static int dimension = 30;
    private JRadioButton selfRadioButton;
    private JRadioButton heteroRadioButton;
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
        //自联想
        if(selfRadioButton.isSelected()){
            int[] p = leftGridPanel.getButtonColor();
            Matrix matrix = DenseMatrix.Factory.importFromArray(p).transpose();
            int[][] array = mCalculator.aann(matrix).toColumnVector(Calculation.Ret.NEW).toIntArray();
            rightMyGridPanel.drawButtonColor(array[0]);
        }
        //异联想
        else{
            System.out.println("异联想");
        }

    }
}
