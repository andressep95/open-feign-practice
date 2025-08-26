package cl.playground.fake.user.config;

import cl.playground.fake.user.config.interceptor.LogRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String PATTERN = "/api";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
            new LogRequestInterceptor()
        ).addPathPatterns(PATTERN);
    }
}
