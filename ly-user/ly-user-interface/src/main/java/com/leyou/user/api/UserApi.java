package com.leyou.user.api;

import com.leyou.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hrp
 * 2020/2/16 9:18
 */
public interface UserApi {

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("query")
    User queryUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );

}
