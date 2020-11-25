package com.leyou.search.test;

import com.leyou.common.vo.PageResult;
import com.leyou.search.pojo.Goods;
import com.leyou.search.pojo.SearchRequest;
import com.leyou.search.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hrp
 * 2020/2/12 14:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private SearchService searchService;

    @Test
    public void test1(){
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setKey("手机");
        searchRequest.setPage(1);
        Map map = new HashMap<String, String>();
        map.put("brandId","18374");
        searchRequest.setFilter(map);
        PageResult<Goods> search = searchService.search(searchRequest);
        System.out.println(search);

    }

}
