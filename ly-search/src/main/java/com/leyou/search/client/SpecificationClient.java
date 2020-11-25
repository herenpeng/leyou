package com.leyou.search.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hrp
 * 2020/2/11 12:50
 */
@FeignClient("item-service")
public interface SpecificationClient extends SpecificationApi {
}
