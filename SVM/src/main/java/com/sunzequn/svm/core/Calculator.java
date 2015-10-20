package com.sunzequn.svm.core;

/**
 * Created by sloriac on 15-10-20.
 */
import com.sunzequn.svm.libsvm.*;
import org.junit.Test;

import java.io.IOException;

public class Calculator {

    private TrainingSamples mTrainingSamples = new TrainingSamples();
    private String modelText = "src/main/resources/model.txt";
    private String samplesText = "src/main/resources/samples.txt";
    private String testText = "src/main/resources/test.txt";
    private String outText = "src/main/resources/out.txt";


    public Calculator() {
    }

    public void svm() throws IOException {
        mTrainingSamples.handleSamples2();
        String[] train = {samplesText, modelText};
        svm_train t = new svm_train();
        t.main(train);

        String[] test = {testText, modelText, outText};
        svm_predict p = new svm_predict();
        System.out.println(p.getRes(test));

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
