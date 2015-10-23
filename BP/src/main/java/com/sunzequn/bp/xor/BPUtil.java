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

    @Test
    public void test() {

        Matrix m = DenseMatrix.Factory.zeros(2, 1);
        m.setAsDouble(0.321, 0, 0);
        m.setAsDouble(0.368, 1, 0);
        System.out.println(m);

        Matrix w = DenseMatrix.Factory.zeros(1, 2);
        w.setAsDouble(0.09, 0, 0);
        w.setAsDouble(-0.17, 0, 1);
        System.out.println(w);

        Matrix s = DenseMatrix.Factory.zeros(1, 1);
        s.setAsDouble(-2.522, 0, 0);
        System.out.println(s);
        System.out.println(f1n(m, w, s));

    }
}
