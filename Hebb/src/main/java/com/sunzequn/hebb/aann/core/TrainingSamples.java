package com.sunzequn.hebb.aann.core;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;

/**
 * Created by sloriac on 15-10-14.
 */
public class TrainingSamples {

    private static int dimension = 30;
    private int[][] aannSamples = {
            {-1, 1, 1, 1,-1, 1,-1,-1,-1, 1, 1,-1,-1,-1, 1, 1,-1,-1,-1, 1, 1,-1,-1,-1, 1,-1, 1, 1, 1,-1},
            {-1, 1, 1,-1,-1,-1,-1, 1,-1,-1,-1,-1, 1,-1,-1,-1,-1, 1,-1,-1,-1,-1, 1,-1,-1,-1,-1, 1,-1,-1},
            {1, 1, 1,-1,-1,-1,-1,-1, 1,-1,-1,-1,-1, 1,-1,-1, 1, 1,-1,-1,-1, 1,-1,-1,-1,-1, 1, 1, 1, 1}
    };


    public TrainingSamples() {
    }

    public int[][] getAannSamples() {
        return aannSamples;
    }

    /**
     * 得到训练样本
     * @return　30*3的矩阵
     */
    public Matrix getP(){
        Matrix p = DenseMatrix.Factory.zeros(3, dimension);
        p = DenseMatrix.Factory.importFromArray(aannSamples);
        return p.transpose();
    }

    @Test
    public void test(){
        System.out.println(getP().selectColumns(Calculation.Ret.NEW, 0));
    }

}
