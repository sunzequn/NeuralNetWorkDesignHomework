package com.sunzequn.hebb.core;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.calculation.Calculation;

/**
 * Created by sloriac on 15-10-14.
 */
public class Calculator {

    private static int dimension = 30;//输入向量维数
    private static int samplesNum = 3;//自联想训练样本数
    private Matrix W1 = DenseMatrix.Factory.zeros(dimension, dimension);//自联想权值矩阵
    private Matrix W2 = DenseMatrix.Factory.zeros(dimension, dimension);//异联想权值矩阵
    private TrainingSamples mTrainingSamples = new TrainingSamples();//训练样本矩阵

    public Calculator() {
        learnW();
        learnWByPseudoInverse();
    }

    /**
     * 自联想权值矩阵学习
     */
    public void learnW(){
        Matrix P = mTrainingSamples.getSamples(1);
        for(int i = 0; i < samplesNum; i++){
            Matrix p = P.selectColumns(Calculation.Ret.NEW, i);
            W1 = W1.plus(p.mtimes(p.transpose()));
        }
    }

    /**
     * 异联想权值矩阵学习
     * 使用仿逆规则
     */
    public void learnWByPseudoInverse(){
        Matrix P = mTrainingSamples.getSamples(2);
        Matrix t = mTrainingSamples.getTargets();
        W2 = t.mtimes(P.pinv());
    }

    /**
     * 用hebb规则计算输出　a = wp
     *
     * @param p    输入向量
     * @param type 类型：1表示自联想；2表示异联想
     * @return 返回输出向量
     */
    public Matrix hebb(Matrix p, int type){
        Matrix a;
        if(type == 1)
            a = W1.mtimes(p);
        else
            a = W2.mtimes(p);
        hardlims(a);
        return a;
    }


    /**
     * 对称硬极限函数
     * @param a　小于0返回-1；大于0返回1
     */
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

}
