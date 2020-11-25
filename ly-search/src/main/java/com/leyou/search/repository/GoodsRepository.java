package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author hrp
 * 2020/2/11 19:21
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
