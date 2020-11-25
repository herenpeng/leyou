package com.leyou.page.service;

import com.leyou.item.pojo.*;
import com.leyou.page.client.BrandClient;
import com.leyou.page.client.CategoryClient;
import com.leyou.page.client.GoodsClient;
import com.leyou.page.client.SpecificationClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrp
 * 2020/2/15 9:17
 */
@Slf4j
@Service
public class PageService {

    @Autowired
    private BrandClient brandClient;

    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private SpecificationClient specClient;

    @Autowired
    private TemplateEngine templateEngine;

    public Map<String, Object> loadModel(Long spuId) {
        Map<String,Object> model = new HashMap<>();
        //查询spu
        Spu spu = goodsClient.querySpuById(spuId);
        //查询skus
        List<Sku> skus = spu.getSkus();
        //查询详情
        SpuDetail detail = spu.getSpuDetail();
        //查询brand
        Brand brand = brandClient.queryBrandById(spu.getBrandId());
        //查询商品分类
        List<Category> categories = categoryClient.queryCategoryByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
        //查询规格参数
        List<SpecGroup> specialSpec = specClient.queryGroupById(spu.getCid3());
        List<SpecGroup> groups = specClient.queryGroupById(spu.getCid3());

        List<SpecParam> params = specClient.queryParamList(null, spu.getCid3(), null);
        Map<Long,String> paramMap = new HashMap<>(16);
        for (SpecParam param : params) {
            paramMap.put(param.getId(), param.getName());
        }

        model.put("spu",spu);
        model.put("skus",skus);
        model.put("spuDetail",detail);
        model.put("brand",brand);
        model.put("categories",categories);
        model.put("paramMap",paramMap);
        model.put("groups",groups);
        return model;
    }

    public void createHtml(Long spuId){
        Context context = new Context();
        context.setVariables(loadModel(spuId));
        File dest = new File("G:\\"+spuId+".html");
        if(dest.exists()){
            dest.delete();
        }
        try(PrintWriter writer = new PrintWriter(dest,"UTF-8")){
            templateEngine.process("item",context,writer);
        }catch (Exception e){
            log.error("[静态页服务]生成静态页异常！",e);
        }
    }

    public void deleteHtml(Long spuId) {
        File dest = new File("G:\\"+spuId+".html");
        if(dest.exists()){
            dest.delete();
        }
    }
}
