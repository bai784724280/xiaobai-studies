package com.baiyx.wfwbitest.Dao;

import com.baiyx.wfwbitest.Entity.Projbase;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;

import java.util.*;

/**
 * @Author: 白宇鑫
 * @Date: 2021/6/30 上午 11:28
 * @Description: ProjBase DAO层
 */
@Mapper
@CacheConfig(cacheNames = "UserDao")
public interface ProjBaseDao {

    // 查询projbase表总记录条数
    @DS("slave_1")
    Long CountProjbase();

    // 循环查询,每次查询固定的条数
     @DS("slave_1")
    List<Projbase> readProjbase(Map map);

    // 写入数据
    @DS("slave_1")
    void writeProjbaseException(List list);

}