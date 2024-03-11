package com.sky.mapper;/*

 */

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
    * @param flavors
    * @return void
    */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除对应的口味
    * @param dishId
    * @return void
    */
    @Delete("delete from dish_flavor where dish_id=#{id}")
    void deleteByDishId(Long dishId);

    /**
     * 根据菜品id批量删除对应的口味
     * @param dishIds
     * @return void
     */
    void deleteByIds(List<Long> dishIds);

    /**
     * 根据菜品id查询口味列表
    * @param id
    * @return java.util.List<com.sky.entity.DishFlavor>
    */
    @Select("select * from dish_flavor where dish_id=#{id}")
    List<DishFlavor> getByDishId(Long id);
}
