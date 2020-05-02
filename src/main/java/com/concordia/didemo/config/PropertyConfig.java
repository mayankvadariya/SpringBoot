package com.concordia.didemo.config;

import com.concordia.didemo.examplebeans.FakeDataSource;
import com.concordia.didemo.examplebeans.FakeJmsBrocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
} )
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru.username}")
    String user;
    @Value("${guru.password}")
    String password;
    @Value("${guru.dburl}")
    String dburl;

    @Value("${guru.jms.username}")
    String jmsuser;
    @Value("${guru.jms.password}")
    String jmspassword;
    @Value("${guru.jms.url}")
    String jmsurl;

    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource =  new FakeDataSource();
        fakeDataSource.setPassword(env.getProperty("PASSWORD"));
        fakeDataSource.setUrl(dburl);
        fakeDataSource.setUser(user);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBrocker fakeJmsBrocker(){
        FakeJmsBrocker fakeJmsBrocker = new FakeJmsBrocker();
        fakeJmsBrocker.setPassword(jmspassword);
        fakeJmsBrocker.setUrl(jmsurl);
        fakeJmsBrocker.setUsername(jmsuser);
        return fakeJmsBrocker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
