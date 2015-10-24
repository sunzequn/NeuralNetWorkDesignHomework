package com.sunzequn.bp.xor;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-22.
 */
public class BPUtil {

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

    public Matrix purelin(Matrix matrix) {
        return matrix;
    }

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

    public Matrix f2n(Matrix matrix) {
        long col = matrix.getColumnCount();
        long row = matrix.getRowCount();
        Matrix m = DenseMatrix.Factory.eye(col, row).times(-2);
        matrix = m.mtimes(matrix);
        return matrix;
    }

    public void out(Matrix matrix, double precision) {
        double res = matrix.getAsDouble(0, 0);
        if (Math.abs(res - 1) <= precision)
            System.out.println(1);
        else
            System.out.println(0);
    }

}
