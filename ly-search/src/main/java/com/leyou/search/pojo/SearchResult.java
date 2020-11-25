package com.leyou.search.pojo;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author hrp
 * 2020/2/12 12:00
 */
@Data
public class SearchResult extends PageResult<Goods> {
    /**
     * 分类待选项
     */
    private List<Category> categories;
    /**
     * 品牌待选项
     */
    private List<Brand> brands;
    /**
     * 规格参数待选项
     */
    private List<Map<String,Object>> specs;

    public SearchResult(){}

    public SearchResult(Long total, Integer totalPage, List<Goods> items, List<Category> categories, List<Brand> brands, List<Map<String, Object>> specs) {
        super(total, totalPage, items);
        this.categories = categories;
        this.brands = brands;
        this.specs = specs;
    }
}
