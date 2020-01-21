package com.example.demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author jimw
 * 测试不同文件
 * -Dspring.profiles.active=test -Dproperty.environment=dev
 */
@Configuration
@PropertySource("classpath:/environment/application-${property.environment}.properties")
@Data
public class Config {

    @Autowired
    Environment env;


}

