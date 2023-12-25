package com.baiyx.tinkerplay.Config;

import com.baiyx.tinkerplay.InterceptorAndFilter.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: baiyx
 * @Date: 2023年6月12日, 0012 上午 10:24:18
 * @Description: 注册拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor(1.0))
                .addPathPatterns("/**/getConfigInfo"); // 设置拦截器的匹配路径
    }
}
