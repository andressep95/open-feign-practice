package cl.playground.fake.user.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignLoggerConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
