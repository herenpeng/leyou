package com.leyou.cart.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hrp
 * 2020/2/16 13:12
 */
@FeignClient("item-service")
public interface GoodsClient extends GoodsApi {
}
