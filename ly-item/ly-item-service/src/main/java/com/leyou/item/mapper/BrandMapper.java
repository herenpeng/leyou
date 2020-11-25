package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hp
 */
public interface BrandMapper extends BaseMapper<Brand> {

    /**
     * 插入商品和品牌的中间表信息
     * @param cid
     * @param bid
     * @return
     */
    @Insert("insert into tb_category_brand values(#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

    /**
     * 通过商品id查询品牌，中间表关联查询
     * @param cid
     * @return
     */
    @Select("select b.id,b.name,b.letter,b.image from tb_brand b INNER JOIN tb_category_brand cb on b.id = cb.brand_id where cb.category_id = #{cid}")
    List<Brand> queryByCategoryId(@Param("cid") Long cid);

}
