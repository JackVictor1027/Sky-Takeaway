package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    @AutoFill(value = OperationType.INSERT)
    /**
     * 插入菜品数据
    * @param [dish]
    * @return void
    */
    void insert(Dish dish);

    /**
     * 菜品分页查询
    * @param dishPageQueryDTO
    * @return com.github.pagehelper.Page<com.sky.vo.DishVO>
    */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据主键查询菜品
    * @param id
    * @return com.sky.entity.Dish
    */
    @Select("select * from dish where id=#{id}")
    Dish getById(Long id);

    /**
     * 根据主键来删除菜品数据
    * @param id
    * @return void
    */
    @Delete("delete from dish where id=#{id}")
    void deleteById(Long id);
}
