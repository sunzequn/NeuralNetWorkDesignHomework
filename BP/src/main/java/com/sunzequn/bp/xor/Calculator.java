package com.sunzequn.bp.xor;

import org.junit.Test;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-22.
 */
public class Calculator {

    private Var mVar = new Var();
    private BPUtil mBpUtil = new BPUtil();

    public void hideLayer(int i) {
        if (i != -1)
            mVar.getSample(i);
        mVar.hideOutput = mBpUtil.logsig(mVar.hideW.mtimes(mVar.input).plus(mVar.hideB));
    }

    public void outLayer(int i) {
        hideLayer(i);
        mVar.output = mBpUtil.purelin(mVar.outW.mtimes(mVar.hideOutput).plus(mVar.outB));
    }

    public void error() {
        mVar.error = mVar.targetOutput.minus(mVar.output);
    }

    public void reverse() {
        Matrix s2 = mBpUtil.f2n(mVar.error);
        Matrix s1 = mBpUtil.f1n(mVar.hideOutput, mVar.outW, s2);

        mVar.hideB = mVar.hideB.minus(s1.times(mVar.learnSpeed));
        mVar.hideW = mVar.hideW.minus(s1.times(mVar.learnSpeed).mtimes(mVar.input.transpose()));

        mVar.outB = mVar.outB.minus(s2.times(mVar.learnSpeed));
        mVar.outW = mVar.outW.minus(s2.times(mVar.learnSpeed).mtimes(mVar.hideOutput.transpose()));
    }

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

            System.out.print("误差:");
            System.out.println(mVar.allError);

            if (mVar.allError < mVar.precision) {
                System.out.println("训练完成！共迭代了" + (i + 1) + "次。");
                return true;
            }

            if (i == mVar.MaxTrainingNum - 1)
                System.out.println("训练失败，请调整相关参数");
        }
        return false;
    }

    public void test(int a, int b) {
        mVar.input.setAsDouble(a, 0, 0);
        mVar.input.setAsDouble(b, 1, 0);
        outLayer(-1);
        System.out.print(a + "亦或" + b + "等于：");
        mBpUtil.out(mVar.output, mVar.precision);
    }

}
