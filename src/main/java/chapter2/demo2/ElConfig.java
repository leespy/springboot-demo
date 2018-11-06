/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package chapter2.demo2;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 配置类
 *
 * Date 2018/10/24 下午1:46
 * Author muse
 */
@Configuration
@ComponentScan("chapter2.demo2")
@PropertySource("classpath:chapter2/demo2/test.properties") // 注入配置文件
public class ElConfig {

    @Value("I love you!") // 1：注入普通字符串
    private String normal;

    @Value("#{systemProperties['os.name']}") // 2：注入操作系统属性
    private String osName;

    @Value("#{T(Math).random()*100.0}") // 3：注入表达式结果
    private double randomNumber;

    @Value("#{demoService.other}") // 4：注入其他Bean的其他属性
    private String fromAnother;

    @Value("classpath:chapter2/demo2/test.properties") // 5：注入文件资源
    private Resource testFile;

    @Value("http://www.baidu.com") // 6：注入网址资源
    private Resource testUrl;

    @Value("${book.name}") // 7：注入配置文件属性
    private String bookName;

    @Autowired
    private Environment environment; // 7：注入配置文件

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
