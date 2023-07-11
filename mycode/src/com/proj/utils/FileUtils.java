package com.proj.utils;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void main (String[] args) {


        String filepath = "C:\\workjob2023\\code\\mycode\\input\\point20210303.csv";
        List<String> point = file2list(filepath);
        for (int i =0; i < point.size();i++){
            System.out.println("point.get("+i+")="+point.get(i));
        }
        String filepath2 = "C:\\workjob2023\\code\\mycode\\input\\dim_dis_code.txt";
        List<String> point2 = file3list(filepath);
        for (int i =0; i < point2.size();i++){
            System.out.println("point.get("+i+")="+point2.get(i));
        }
    }

    public static List<String> file2list(String filePath) {
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println("br.readline()=" + br.readLine());
            List<String> list = new ArrayList<>();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    list.add(str);
                } else {
                    break;
                }
            }
            return list;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }
    private static List<String> file3list(String filePath) {
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println("br.readline()=" + br.readLine());
            List<String> list = new ArrayList<>();
            while (true) {
                String str = br.readLine();
                if (str != null) {
                    list.add(str);
                } else {
                    break;
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
