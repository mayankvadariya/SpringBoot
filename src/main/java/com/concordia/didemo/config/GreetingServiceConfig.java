package com.concordia.didemo.config;


import com.concordia.didemo.services.GreetingRepository;
import com.concordia.didemo.services.GreetingService;
import com.concordia.didemo.services.GreetingServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean//At run time GreetingRepository repository would be created by Spring
    GreetingServiceFactory greetingServiceFactory(GreetingRepository repository){
            return new GreetingServiceFactory(repository);
    }

 /*
 * This configuration is required to choose between which implementation of GreetingService to be made available
 * out of PrimaryGreetingService, PrimaryGermanGreetingService, PrimarySpanishGreetingService, PrimaryGreetingService
 * */


    @Bean
    @Primary
    @Profile({"default","en"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile({"es"})
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("es");
    }

    @Bean
    @Primary
    @Profile({"de"})
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.createGreetingService("de");
    }

}
