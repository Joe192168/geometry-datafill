package com.geometry.rest;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {

    @Test
    public void testJasypt(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("swhdg");
        //要加密的数据（数据库的用户名或密码）
        String password = textEncryptor.encrypt("gpadmin123");
        System.out.println("password:"+password);
    }

}
