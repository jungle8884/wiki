package com.jungle.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jungle
 * 解决跨域问题 【前后端分离项目存在此问题】
 * Vue项目【8080】 和 SpringBoot项目【8880】 可以同时启动
 * 来自一个IP端口的页面【Vue】要访问另一个IP端口的资源【SpringBoot请求接口】，会产生跨域访问。
 */
@SuppressWarnings("all")
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 针对所有的请求地址
                .allowedOriginPatterns("*") // 允许所有来源
                .allowedHeaders(CorsConfiguration.ALL)  // header
                .allowedMethods(CorsConfiguration.ALL) // get post ... 都支持
                .allowCredentials(true) // 允许带上凭证
                .maxAge(3600); // 1小时内不需要再预检【在调用电子书接口之前，会发OPTIONS请求】
    }

}
