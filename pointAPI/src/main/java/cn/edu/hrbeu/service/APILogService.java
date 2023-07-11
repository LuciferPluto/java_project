package cn.edu.hrbeu.service;

import cn.edu.hrbeu.dao.APIDAO;
import cn.edu.hrbeu.dao.PointDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class APILogService {
    @Autowired
    PointDAO pointDAO;
    @Autowired
    APIDAO apidao;


    public Map<String, Object> insertAPILog( String userName, String password, String apiCode, Map<String,Object> returnMap) {
        Map<String, Object> apiMap = new HashMap<>();
        apiMap.put("logId", UUID.randomUUID().toString());
        apiMap.put("username", userName);
        apiMap.put("password", password);
        apiMap.put("apiCode", apiCode);
        apiMap.put("code", returnMap.get("code"));
        apiMap.put("msg", returnMap.get("msg"));
        apiMap.put("updateTime", (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
        // todo: 插入API调用日志
        apidao.insertAPILog(apiMap);
        return null;
    }
}

