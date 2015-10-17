package com.sunzequn.hebb.aann.core;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;

/**
 * Created by sloriac on 15-10-14.
 */
public class Calculator {

    private static int dimension = 30;
    private static int samplesNum = 3;
    private Matrix W1 = DenseMatrix.Factory.zeros(dimension, dimension);
    private Matrix W2 = DenseMatrix.Factory.zeros(dimension, dimension);
    private TrainingSamples mTrainingSamples = new TrainingSamples();

    public Calculator() {
        learnW();
        learnWByPseudoInverse();
    }

    public void learnW(){
        Matrix P = mTrainingSamples.getP();
        for(int i = 0; i < samplesNum; i++){
            Matrix p = P.selectColumns(Calculation.Ret.NEW, i);
            W1 = W1.plus(p.mtimes(p.transpose()));
        }
    }

    public void learnWByPseudoInverse(){
        Matrix P = mTrainingSamples.getP();
        W2 = P.mtimes(P.pinv());
    }

    public Matrix aann(Matrix p, int method){
        Matrix a;
        if(method == 1)
            a = W1.mtimes(p);
        else
            a = W2.mtimes(p);
        hardlims(a);
        return a;
    }

    public void hardlims(Matrix a){
        long row = a.getRowCount();
        long col = a.getColumnCount();
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++){
                if(a.getAsDouble(i, j) > 0)
                    a.setAsDouble(1, i, j);
                else
                    a.setAsDouble(-1, i, j);
            }

    }

    public void printW(){
        System.out.println("权值矩阵W为：");
        System.out.println(W1);
    }

    @Test
    public void test(){
        learnW();
        learnWByPseudoInverse();
        System.out.println(W1);
        System.out.println("-----------------------");
        System.out.println(W2);
    }
}
