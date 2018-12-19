package com.blog;

import com.blog.convert.EnumConvert;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

/**
 * author:xiujiang.liu
 * Date:2018/12/11
 * Time:23:54
 */
@SpringBootApplication
public class BlogApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BlogApplication.class);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BlogApplication.class,args);
        ConfigurableListableBeanFactory configurableListableBeanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
        System.out.println(configurableListableBeanFactory.getRegisteredScopeNames());
        Iterator iterator = configurableListableBeanFactory.getBeanNamesIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
