package com.sunzequn.svm.core;

/**
 * Created by sloriac on 15-10-20.
 */
import com.sunzequn.svm.libsvm.*;
import org.junit.Test;

import java.io.IOException;

public class Calculator {

    private DataHandler mDataHandler = new DataHandler();//数据处理
    private String modelText = "SVM/src/main/resources/model.txt";//模型存储路径
    private String samplesText = "SVM/src/main/resources/samples.txt";//训练样本存储路径
    private String testText = "SVM/src/main/resources/test.txt";//测试样本存储路径
    private String outText = "SVM/src/main/resources/out.txt";//结果存储路径

    public Calculator() {
    }

    /**
     * 读取训练样本，训练模型并存储
     *
     * @throws IOException
     */
    public void init() throws IOException {
        mDataHandler.handleSamples(samplesText, mDataHandler.getNumberSamples());
        String[] train = {samplesText, modelText};
        svm_train t = new svm_train();
        t.main(train);
    }

    /**
     * 使用svm分类
     * @return 返回分类结果
     * @throws IOException
     */
    public int svm() throws IOException {
        String[] test = {testText, modelText, outText};
        svm_predict p = new svm_predict();
        return p.getRes(test);
    }

}
