package xyz.harenk.nvl.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-30 23:04
 */
@SpringBootTest
class SysUserServiceImplTest {

    @Test
    void testPw(){
        String hashpw = BCrypt.hashpw("admin", BCrypt.gensalt());
        System.out.println("hashpw = " + hashpw);
    }
}