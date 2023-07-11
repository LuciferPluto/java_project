package com.proj.dao;

import com.proj.entitles.DisEntity;
import com.proj.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisDAO {
    DBUtils dbUtils = new DBUtils();
    public  int truncateDis(){

        String sql = "truncate table dis_info ";
        return dbUtils.doSave(sql);

    }
    public  int insertDis(DisEntity disEntity){

        String sql = "INSERT INTO dis_info (dis_id,dis_code,dis_name,city_code3,city_code4,city_name)"
                + "VALUES"+
                "("+
                "'"+disEntity.getDisId()+"',"+
                "'"+disEntity.getDisCode6()+"',"+
                "'"+disEntity.getDisName()+"',"+
                "'"+disEntity.getCityCode3()+"',"+
                "'"+disEntity.getCityCode4()+"',"+
                "'"+disEntity.getCityName()+"')";
        return  dbUtils.doSave(sql);


    }

    public List<DisEntity> queryDisListByCode(String disCode) {
        String sql = "select * from dis_info t where t.dis_code = '"+disCode+"'";
        System.out.println("38>> sql"+sql);
        ResultSet rs = dbUtils.doQuery(sql);
        List<DisEntity> disEntityList = new ArrayList<>();

        try{
            while(rs.next()){
                DisEntity disEntity = new DisEntity();
                disEntity.setDisId(rs.getString(1));
                disEntityList.add(disEntity);
            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    return disEntityList;
    }
}
