package com.sunzequn.hebb.aann.core;

import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-14.
 */
public class Calculator {

    private static int dimension = 30;
    private Matrix W = DenseMatrix.Factory.zeros(dimension, dimension);

    public Calculator() {
    }

    public void calculateW(){

    }

    public void calculateWByPseudoInverse(){

    }

    public void printW(){
        System.out.println("权值矩阵W为：");
        System.out.println(W);
    }





}
