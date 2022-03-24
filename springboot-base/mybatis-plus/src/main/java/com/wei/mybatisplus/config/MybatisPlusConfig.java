package com.wei.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;
import java.util.Random;

@MapperScan("com.wei.mybatisplus.mapper")
@EnableTransactionManagement
@Configuration//配置类
public class MybatisPlusConfig {
    /**
     * 配置乐观锁插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //新增乐观锁插件
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //新增sql性能规范插件
        mybatisPlusInterceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        //新增防止全表更新与删除插件
        mybatisPlusInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        //新增分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        //动态表明插件
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        /**
         * 通过动态表明插件可以实现分表
         * 规则可以自己定义
         * 但是获取参数的方式需要自己写,可以做到读写分离
         * 怎样获取到值呢？加入可以获取到id值可以根据一定的规则实现分表
         *
         **/

        dynamicTableNameInnerInterceptor.setTableNameHandler((sql, tableName) -> {
            // 获取参数方法

            String sqlString = sql;
            String year = "_2022";

            return tableName;
        });
        mybatisPlusInterceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);



        return mybatisPlusInterceptor;
    }

}