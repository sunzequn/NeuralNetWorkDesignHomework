package com.sunzequn.svm.core;

/**
 * Created by sloriac on 15-10-20.
 */
import com.sunzequn.svm.libsvm.*;
import org.junit.Test;

import java.io.IOException;

public class Calculator {

    private DataHandler mDataHandler = new DataHandler();
    private String modelText = "SVM/src/main/resources/model.txt";
    private String samplesText = "SVM/src/main/resources/samples.txt";
    private String testText = "SVM/src/main/resources/test.txt";
    private String outText = "SVM/src/main/resources/out.txt";

    public Calculator() {
    }

    public void init() throws IOException {
        mDataHandler.handleSamples(samplesText, mDataHandler.getNumberSamples());
        String[] train = {samplesText, modelText};
        svm_train t = new svm_train();
        t.main(train);
    }

    public int svm() throws IOException {
        String[] test = {testText, modelText, outText};
        svm_predict p = new svm_predict();
        return p.getRes(test);
    }

    @Test
    public void test(){
        try {
            svm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
