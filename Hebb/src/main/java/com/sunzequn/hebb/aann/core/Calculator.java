package com.sunzequn.hebb.aann.core;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-14.
 */
public class Calculator {

    private static int dimension = 30;
    private static int samplesNum = 3;
    private Matrix W = DenseMatrix.Factory.zeros(dimension, dimension);
    private TrainingSamples mTrainingSamples = new TrainingSamples();

    public Calculator() {
    }

    public void learnW(){
        for(int i = 0; i < samplesNum; i++){
            Matrix p = mTrainingSamples.getP(i);
            W = W.plus(p.mtimes(p.transpose()));
        }
    }

    public void learnWByPseudoInverse(){

    }

    public Matrix aann(Matrix p){
        learnW();
        Matrix a = W.mtimes(p);
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
        System.out.println(W);
    }

}
