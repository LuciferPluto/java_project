package com.proj.utils;

import com.proj.entitles.DisEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DisUtils {
    FileUtils fileUtils = new FileUtils();

    public static void main(String[] args) {

        String filePath = "C:\\workjob2023\\code\\mycode\\input\\dim_dis_code.txt";
        DisUtils disUtils = new DisUtils();
        List<DisEntity> disEntityList = disUtils.getDisInfo(filePath);
        for (int i = 0;i<disEntityList.size();i++){

            System.out.println("disEntityList = "+disEntityList);
        }
    }

    public  List<DisEntity> getDisInfo(String filePath){
        List<DisEntity> disEntityList = new ArrayList<>();
        List<String> strDist = fileUtils.file2list(filePath);
        for (int i =0;i<strDist.size();i++){
            String str = strDist.get(i);
            String strs[]=str.split("\\|");
            DisEntity disEntity = new DisEntity();
            disEntity.setDisName(strs[1]);
            disEntity.setDisCode6(strs[3]);
            disEntity.setCityCode3(strs[7]);
            disEntity.setCityName(strs[0]);
            disEntity.setCityCode4(strs[2]);
            disEntity.setDisId(UUID.randomUUID().toString());
            disEntityList.add(disEntity);

        }


        return disEntityList;
    }

}
