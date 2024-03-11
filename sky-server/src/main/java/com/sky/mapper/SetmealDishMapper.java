package com.sky.mapper;/*

 */

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐id
    * @param dishIds
    * @return java.util.List<java.lang.Long>
    */
    List<Long> getSetmealIdsByIds(List<Long> dishIds);
}
