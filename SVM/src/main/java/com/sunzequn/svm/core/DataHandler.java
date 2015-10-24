package com.sunzequn.svm.core;

import com.sunzequn.svm.io.IOUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloriac on 15-10-14.
 * 数据处理，将训练样本数据处理成libsvm需要的格式，并写入文本
 */
public class DataHandler {

    private static int row = 6;//数字图像格点的行数
    private static int col = 5;//数字图像格点的列数
    private static int dimension = row * col;//训练样本特征维数
    private IOUtil io = new IOUtil();//文本读取工具类
    //数字的训练样本
    private int[][] numberSamples = {
            {-1, 1, 1, 1, -1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, 1, 1, -1},
            {-1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1},
            {1, 1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, 1, 1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1},
            {1, 1, 1, 1, -1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1},
            {1, -1, -1, 1, -1, 1, -1, -1, 1, -1, 1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1},
            {1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1},
            {-1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, 1, -1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, 1, 1, -1},
            {1, 1, 1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1},
            {-1, 1, 1, 1, -1, 1, -1, -1, -1, 1, -1, 1, 1, 1, -1, 1, -1, -1, -1, 1, 1, -1, -1, -1, 1, -1, 1, 1, 1, -1},
            {-1, 1, 1, 1, -1, 1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, -1}
    };

    public int[][] getNumberSamples() {
        return numberSamples;
    }

    public DataHandler() {
    }

    /**
     * 处理训练样本数据，写入文本
     *
     * @param file  存储路径
     * @param array 训练样本
     */
    public void handleSamples(String file, int[][] array) {
        List<String> samples = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i));
            for (int j = 0; j < dimension; j++) {
                stringBuffer.append(" " + j + ":" + array[i][j]);
            }
            String oneLineSamlple = stringBuffer.toString();
            samples.add(oneLineSamlple);
        }
        io.writeData(file, samples);
    }

}
