package com.leyou.search.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hrp
 * 2020/2/11 12:47
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {
}
