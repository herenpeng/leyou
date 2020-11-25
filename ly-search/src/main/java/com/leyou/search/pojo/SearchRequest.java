package com.leyou.search.pojo;

import java.util.Map;

/**
 * @author hrp
 * 2020/2/12 9:04
 */
public class SearchRequest {
    private String key;
    private Integer page;
    private Map<String,String> filter;
    private static final Integer DEFAULT_SIZE= 20;
    private static final Integer DEFAULT_PAGE = 1;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        if(page == null){
            page = DEFAULT_PAGE;
        }
        return Math.max(DEFAULT_PAGE,page);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return DEFAULT_SIZE;
    }

    public Integer getDefaultPage() {
        return DEFAULT_PAGE;
    }

    public Map<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }
}
