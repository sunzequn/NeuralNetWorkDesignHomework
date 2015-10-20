package com.sunzequn.svm.core;

import com.sunzequn.svm.io.IOUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sloriac on 15-10-14.
 */
public class TrainingSamples {

    private String samplesText = "src/main/resources/samples.txt";
    private static int row = 6;
    private static int col = 5;
    private static int dimension = row * col;
    private static int type = 10;
    private static int attribute = 13;
    private IOUtils io = new IOUtils();

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

    public TrainingSamples() {
    }

    public void handleSamples() {
        List<String> samples = new ArrayList<String>();

        for (int i = 0; i < type; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            int negOneNum = 0;
            int posOneNum = 0;

            int[] xTag = new int[col];
            int[] yTag = new int[row];
            stringBuffer.append(String.valueOf(i));

            for (int j = 0; j < dimension; j++) {
                if (numberSamples[i][j] == 1) {
                    int xindex = j % col;
                    xTag[xindex]++;
                    int yindex = j / col;
                    yTag[yindex]++;
                    posOneNum++;
                }
                else
                    negOneNum++;

            }

            int[] attrs = {posOneNum, negOneNum};
            for (int k = 1; k <= attribute; k++) {
                int value;
                if(k <= 2)
                    value = attrs[k-1];
                else if (k <= 7)
                    value = xTag[k-3];
                else
                    value = yTag[k-8];
                stringBuffer.append(" " + k + ":" + value);
            }

            String oneLineSamlple = stringBuffer.toString();
            samples.add(oneLineSamlple);

        }
        io.writeData(samplesText, samples);
    }

    public void handleSamples2(){
        List<String> samples = new ArrayList<String>();
        for (int i = 0; i < type; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i));
            for (int j = 0; j < dimension; j++){
                stringBuffer.append(" " + j + ":" + numberSamples[i][j]);
            }
            String oneLineSamlple = stringBuffer.toString();
            samples.add(oneLineSamlple);
        }
        io.writeData(samplesText, samples);
    }

    @Test
    public void test() {
        handleSamples();
    }


}
