package com.cn.travel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages ={"com.cn.travel.common","com.cn.travel.*.*.service.imp","com.cn.travel.*.*.provider","com.cn.travel.web.*"})//IOC容器依赖注入
@MapperScan(basePackages ="com.cn.travel.*.*.dao")//扫描所有Mapper映射接口
public class TravelApplication extends SpringBootServletInitializer {

	@Override//开发环境启动函数
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TravelApplication.class);
	}

	//生产环境启动函数
	public static void main(String[] args) {
		SpringApplication.run(TravelApplication.class, args);
	}

}
