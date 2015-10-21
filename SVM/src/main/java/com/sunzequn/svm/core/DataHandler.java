package com.sunzequn.svm.core;

import com.sunzequn.svm.io.IOUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloriac on 15-10-14.
 */
public class DataHandler {

    private String samplesText = "SVM/src/main/resources/samples.txt";
    private String testText = "SVM/src/main/resources/test.txt";
    private static int row = 6;
    private static int col = 5;
    private static int dimension = row * col;
    private static int attribute = 13;
    private IOUtil io = new IOUtil();

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
