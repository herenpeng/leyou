package com.leyou.search.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hrp
 * 2020/2/11 12:51
 */
@FeignClient("item-service")
public interface BrandClient extends BrandApi {
}
