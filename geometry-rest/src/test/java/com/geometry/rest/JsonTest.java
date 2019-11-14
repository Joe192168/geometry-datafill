package com.geometry.rest;

import com.geometry.pojo.utils.JacksonUtil;
import com.geometry.pojo.vo.NewDataSource;

public class JsonTest {

    public static void main(String[] args) {
        String str = "{\"username\": \"root\",\"password\": \"root\",\"dataIp\": \"localhost\",\"dataPort\": \"3306\",\"dataType\": \"mysql\",\"dataName\": \"mysql\",\"schemaName\": \"\"}";

        str = "{\"username\": \"root\",\"password\": \"root\",\"dataIp\": \"localhost\",\"dataPort\": \"3306\",\"dataType\": \"mysql\",\"dataName\": \"mysql\",\"schemaName\": \"\"}";


        NewDataSource newDataSource = JacksonUtil.stringToBean(str,NewDataSource.class);

        System.out.print(newDataSource);
    }

}
