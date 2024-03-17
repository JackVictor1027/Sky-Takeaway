package com.sky.controller.admin;/*

 */

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: sky-take-out
 * @package: com.sky.controller.admin
 * @className: ShopController
 * @author: JackVictor
 * @description: TODO
 * @date: 2024/3/17 20:05
 * @version: 1.0
 */
@RestController("adminShopController")
@RequestMapping("admin/shop")
@Api(tags="店铺相关接口")
@Slf4j
public class ShopController {
    public static final String KEY="SHOP STATUS";
    @Autowired
    private RedisTemplate redisTemplate;
    @PutMapping("/{status}")
    @ApiOperation("设置店铺营业状态")
    /**
     * 设置店铺的营业状态
    * @param [status]
    * @return com.sky.result.Result
    */
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺的营业状态为:{}",status==1?"营业中":"打样中");
        redisTemplate.opsForValue().set(KEY,status);
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    /**
     * 查询店铺的营业状态
    * @param []
    * @return com.sky.result.Result<java.lang.Integer>
    */
    public Result<Integer> getStatus(){
        Integer status = (Integer)redisTemplate.opsForValue().get(KEY);
        log.info("获取到店铺的营业状态为:{}...",status==1?"营业中":"打样中");
        return Result.success(status);
    }
}
