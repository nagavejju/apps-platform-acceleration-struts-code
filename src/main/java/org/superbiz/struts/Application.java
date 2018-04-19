package org.superbiz.struts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    FilterRegistrationBean struts2Registration () {
        FilterRegistrationBean strutsRb = new FilterRegistrationBean();
        org.apache.struts2.dispatcher.FilterDispatcher fd = new org.apache.struts2.dispatcher.FilterDispatcher();
        strutsRb.setFilter(fd);
        strutsRb.setUrlPatterns(Arrays.asList("/*"));
        strutsRb.setOrder(0);
        return strutsRb;
    }


    @Bean
    FilterRegistrationBean cleanupFilter() {
        FilterRegistrationBean cleanupRb = new FilterRegistrationBean();
        org.apache.struts2.dispatcher.ActionContextCleanUp cf = new org.apache.struts2.dispatcher.ActionContextCleanUp();
        cleanupRb.setFilter(cf);
        cleanupRb.setUrlPatterns(Arrays.asList("/*"));
        cleanupRb.setOrder(1);
        return cleanupRb;
    }

    @Bean
    FilterRegistrationBean sitemeshFilter () {
        FilterRegistrationBean sitemeshRb = new FilterRegistrationBean();
        com.opensymphony.module.sitemesh.filter.PageFilter pf = new com.opensymphony.module.sitemesh.filter.PageFilter();
        sitemeshRb.setFilter(pf);
        sitemeshRb.setUrlPatterns(Arrays.asList("/*"));
        sitemeshRb.setOrder(2);
        return sitemeshRb;
    }

}