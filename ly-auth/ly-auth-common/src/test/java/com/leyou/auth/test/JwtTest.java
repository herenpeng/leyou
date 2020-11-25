package com.leyou.auth.test;

import com.leyou.auth.pojo.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author hrp
 * 2020/2/15 19:18
 */
public class JwtTest {

    private static final String pubKeyPath = "G:\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "G:\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU4MTc2Njg4Nn0.IUYu0rvJmx6F6PhNtVcYjDe2zYDW90aEHPnZcJs1tFAvsQukqyyykzkRO2ssWUPw7NVy77t8W7ScmSADlRffzONJnGY9XmnapXOxU_ld1hIq1C9ddC6SVpRrco0VcUNXeRk86ZM318Vq9ipCjU7I8dtBsTTjnp-j1UZv_oKHUoc";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
