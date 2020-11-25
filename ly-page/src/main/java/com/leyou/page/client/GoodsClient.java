package com.leyou.page.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hrp
 * 2020/2/11 12:45
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
