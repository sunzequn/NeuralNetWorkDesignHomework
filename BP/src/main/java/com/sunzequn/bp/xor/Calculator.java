package com.sunzequn.bp.xor;

import org.junit.Test;
import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

/**
 * Created by sloriac on 15-10-22.
 */
public class Calculator {

    private Var mVar = new Var();
    private BPUtil mBpUtil = new BPUtil();

    public void hideLayer(int i) {
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

//        System.out.println(mVar.hideB);
        mVar.hideB = mVar.hideB.minus(s1.times(mVar.learnSpeed));
//        System.out.println(mVar.hideB);

//        System.out.println(mVar.hideW);
        mVar.hideW = mVar.hideW.minus(s1.times(mVar.learnSpeed).mtimes(mVar.input.transpose()));
//        System.out.println(mVar.hideW);

//        System.out.println(mVar.outB);
        mVar.outB = mVar.outB.minus(s2.times(mVar.learnSpeed));
//        System.out.println(mVar.outB);

//        System.out.println(mVar.outW);
        mVar.outW = mVar.outW.minus(s2.times(mVar.learnSpeed).mtimes(mVar.hideOutput.transpose()));
//        System.out.println(mVar.outW);
    }

    @Test
    public void test() {

        for (int i = 0; i < mVar.MaxTrainingNum; i++) {
            mVar.allError = 0;
            for (int j = 0; j < 4; j++) {
                outLayer(j);
                error();
                reverse();
                mVar.allError += Math.abs(mVar.error.getAsDouble(0, 0));
            }

            System.out.print("误差:");
            System.out.println(mVar.allError);


            if (mVar.allError < mVar.precision) {
                System.out.println("success");
                for (int k = 4; k < 8; k++) {
                    outLayer(k);
                    System.out.println(mVar.output);
                }
                return;
            }


        }

    }

}
