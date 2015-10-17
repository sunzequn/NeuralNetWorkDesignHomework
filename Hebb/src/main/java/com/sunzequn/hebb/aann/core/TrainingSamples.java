package com.sunzequn.hebb.aann.core;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

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
     * 取得第index个训练样本
     * @param index 样本编号
     * @return 30*1的向量
     */
    public Matrix getP(int index) {
        Matrix p = DenseMatrix.Factory.zeros(1, dimension);
        p = DenseMatrix.Factory.importFromArray(aannSamples[index]);
        return p.transpose();
    }

}
