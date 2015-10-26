package com.sunzequn.bp.xor;

import org.junit.Test;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-22.
 */
public class Calculator {

    private Var mVar = new Var();//BP网络所需的变量
    private BPUtil mBpUtil = new BPUtil();//BP计算工具类

    /**
     * 隐层训练
     *
     * @param i 训练样本编号
     */
    public void hideLayer(int i) {
        if (i != -1)
            mVar.getSample(i);
        mVar.hideOutput = mBpUtil.logsig(mVar.hideW.mtimes(mVar.input).plus(mVar.hideB));
    }

    /**
     * 输出层训练
     * @param i 训练样本编号
     */
    public void outLayer(int i) {
        hideLayer(i);
        mVar.output = mBpUtil.purelin(mVar.outW.mtimes(mVar.hideOutput).plus(mVar.outB));
    }

    /**
     * 计算误差
     */
    public void error() {
        mVar.error = mVar.targetOutput.minus(mVar.output);
    }

    /**
     * 反向传播
     */
    public void reverse() {
        //求得敏感值
        Matrix s2 = mBpUtil.f2n(mVar.error);
        Matrix s1 = mBpUtil.f1n(mVar.hideOutput, mVar.outW, s2);
        //调整隐层参数
        mVar.hideB = mVar.hideB.minus(s1.times(mVar.learnSpeed));
        mVar.hideW = mVar.hideW.minus(s1.times(mVar.learnSpeed).mtimes(mVar.input.transpose()));
        //调整输出层参数
        mVar.outB = mVar.outB.minus(s2.times(mVar.learnSpeed));
        mVar.outW = mVar.outW.minus(s2.times(mVar.learnSpeed).mtimes(mVar.hideOutput.transpose()));
    }

    /**
     * 在当前最大训练次数和精度的约束下，训练样本
     * @return 是否训练成功
     */
    public boolean train() {
        //控制迭代次数
        for (int i = 0; i < mVar.MaxTrainingNum; i++) {
            mVar.allError = 0;
            for (int j = 0; j < 4; j++) {
                outLayer(j);//迭代一次，得到输出
                error();//计算误差
                reverse();
                mVar.allError += Math.abs(mVar.error.getAsDouble(0, 0));
            }
            //打印误差
            System.out.print("误差:");
            System.out.println(mVar.allError);
            //训练成功
            if (mVar.allError < mVar.precision) {
                System.out.println("训练完成！共迭代了" + (i + 1) * 4 + "次。");
                return true;
            }
            //训练失败
            if (i == mVar.MaxTrainingNum - 1)
                System.out.println("训练失败，请调整相关参数");
        }
        return false;
    }

    /**
     * 测试BP神经网络，打印测试结果
     * @param a 求亦或的一个值
     * @param b 求亦或的另一个值
     */
    public void test(int a, int b) {
        mVar.input.setAsDouble(a, 0, 0);
        mVar.input.setAsDouble(b, 1, 0);
        outLayer(-1);
        System.out.print(a + " 异或 " + b + " 等于：");
        mBpUtil.out(mVar.output, mVar.precision);
    }

}
