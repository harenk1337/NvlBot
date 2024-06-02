package xyz.harenk.nvl.common.config;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author harenk.xyz @harenk1337
 * @description
 * @create 2024-05-29 17:53
 */
@Configuration
public class MybatisPlusConfig {

    @Value("${bot.type}")
    private String sqlType;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        DbType type = ObjectUtil.equal(sqlType, "mysql") ? DbType.MYSQL : DbType.SQLITE;
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(type));
        return mybatisPlusInterceptor;
    }
}
