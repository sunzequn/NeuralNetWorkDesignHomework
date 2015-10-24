package com.sunzequn.bp.xor;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-22.
 */
public class BPUtil {

    /**
     * 对数S形函数
     *
     * @param matrix 需要处理的矩阵
     * @return 处理好的矩阵
     */
    public Matrix logsig(Matrix matrix) {
        long col = matrix.getColumnCount();
        long row = matrix.getRowCount();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double temp = matrix.getAsDouble(i, j);
                temp = 1 / (1 + Math.exp(-temp));
                matrix.setAsDouble(temp, i, j);
            }

        }
        return matrix;
    }

    /**
     * 线性函数，取y=x
     * @param matrix 需要处理的矩阵
     * @return 处理好的矩阵
     */
    public Matrix purelin(Matrix matrix) {
        return matrix;
    }

    /**
     * 求反向传播第一层的敏感值
     * @param output BP神经网络的输出
     * @param outW 输出层的权值矩阵
     * @param s2 第一层的敏感值
     * @return 第二层的敏感值
     */
    public Matrix f1n(Matrix output, Matrix outW, Matrix s2) {
        long row = output.getRowCount();
        Matrix m = DenseMatrix.Factory.zeros(row, row);
        for (int i = 0; i < row; i++) {
            double temp = output.getAsDouble(i, 0);
            temp = (1 - temp) * temp;
            m.setAsDouble(temp, i, i);
        }
        Matrix matrix = m.mtimes(outW.transpose()).mtimes(s2);
        return matrix;
    }

    /**
     * 求反向传播第二层的敏感值s2
     * @param matrix 误差矩阵
     * @return 第二层敏感值
     */
    public Matrix f2n(Matrix matrix) {
        long col = matrix.getColumnCount();
        long row = matrix.getRowCount();
        Matrix m = DenseMatrix.Factory.eye(col, row).times(-2);
        matrix = m.mtimes(matrix);
        return matrix;
    }

    /**
     * 输出二值化
     * @param matrix 待输出矩阵
     * @param precision 期望精度
     */
    public void out(Matrix matrix, double precision) {
        double res = matrix.getAsDouble(0, 0);
        if (Math.abs(res - 1) <= precision)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
