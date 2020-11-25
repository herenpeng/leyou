package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hrp
 * 2020/2/16 9:25
 */
@FeignClient(value = "user-service")
public interface UserClient extends UserApi {
}
