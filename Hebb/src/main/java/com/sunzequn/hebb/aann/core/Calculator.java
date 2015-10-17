package com.sunzequn.hebb.aann.core;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.export.destination.MatrixByteArrayExportDestination;

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

    public void getW(){
        for(int i = 0; i < samplesNum; i++){
            Matrix p = mTrainingSamples.getP(i);
            W = W.plus(p.mtimes(p.transpose()));
        }
        System.out.println(W);
    }

    public void getWByPseudoInverse(){

    }

    public void printW(){
        System.out.println("权值矩阵W为：");
        System.out.println(W);
    }

    @Test
    public void test(){
        getW();
    }



}
