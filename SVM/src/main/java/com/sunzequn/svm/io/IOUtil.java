package com.sunzequn.svm.io;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by sloriac on 15-10-20.
 */
public class IOUtil {

    /**
     * 一行一行写入文本
     *
     * @param fileName 文本路径
     * @param data     数据
     */
    public void writeData(String fileName, List<String> data){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for(int i = 0; i < data.size(); i++){
                bw.write(data.get(i));
                if(i != data.size() - 1)
                    bw.newLine();
            }
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 写入一行数据
     * @param fileName 文本路径
     * @param data 数据
     */
    public void writeData(String fileName, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(data);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
