package com.sky.service;/*

 */

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

public interface DishService {
    /**
     * 新增菜品和对应的口味数据
    * @param dishDTO
    * @return void
    */
    public void saveWithFlavour(DishDTO dishDTO);

    /**
     * 菜品分页查询
    * @param dishPageQueryDTO
    * @return com.sky.result.PageResult
    */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);
}
