package com.sunzequn.bp.xor;

import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-22.
 */
public class Var {

    int dimension = 2;//训练样本维数
    int samplesNum = 4;//训练样本个数
    int hideNeuronNum = 2;//隐层神经元个数
    int outNeuronNum = 1;//输出层神经元个数
    int MaxTrainingNum = 1000000;//最大循环次数
    double allError;//误差
    double precision = 0.1;//期望精度
    double learnSpeed = 0.1;//学习速率

    Matrix input = DenseMatrix.Factory.zeros(dimension, 1);//输入向量
    Matrix hideW = DenseMatrix.Factory.rand(hideNeuronNum, dimension).times(randMin());//隐层权值，随机
    Matrix hideB = DenseMatrix.Factory.rand(hideNeuronNum, 1).times(randMin());//隐层偏置，随机
    Matrix hideOutput = DenseMatrix.Factory.zeros(hideNeuronNum, 1);//隐层输出

    Matrix outW = DenseMatrix.Factory.rand(outNeuronNum, hideNeuronNum).times(randMin());//输出层权值，随机
    Matrix outB = DenseMatrix.Factory.rand(outNeuronNum, 1).times(randMin());//输出层偏置，随机
    Matrix output = DenseMatrix.Factory.zeros(outNeuronNum, 1);//输出层输出

    Matrix targetOutput = DenseMatrix.Factory.zeros(outNeuronNum, 1);//预期输出
    Matrix error = DenseMatrix.Factory.zeros(outNeuronNum, 1);//误差

    private int[][] samplesInput = {{0, 0}, {0, 1}, {1, 0}, {1, 1}, {0, 0}, {0, 1}, {1, 0}, {1, 1}};
    private int[] samplesOutput = {0, 1, 1, 0, 0, 1, 1, 0};


    //获得第i个测试样例，i从0开始
    public void getSample(int i) {
        input.setAsDouble(samplesInput[i][0], 0, 0);
        input.setAsDouble(samplesInput[i][1], 1, 0);
        targetOutput.setAsDouble(samplesOutput[i], 0, 0);
    }

    public double randMin() {
        return Math.random() * 0.5;
    }

}