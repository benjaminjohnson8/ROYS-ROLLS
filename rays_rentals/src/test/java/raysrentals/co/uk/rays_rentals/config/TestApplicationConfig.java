package raysrentals.co.uk.rays_rentals.config;import org.springframework.beans.factory.annotation.Value;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.ComponentScan;import org.springframework.context.annotation.ComponentScan.Filter;import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.EnableAspectJAutoProxy;import org.springframework.context.annotation.PropertySource;import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;import org.springframework.stereotype.Controller;import raysrentals.co.uk.rays_rentals.Application;@Configuration@EnableAspectJAutoProxy@PropertySource("classpath:${target_env:dev}-test-persistence.properties")@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))class TestApplicationConfig {    @Value("${applicationBaseURL}")    private String applicationBaseURL;    @Bean    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {       return new PropertySourcesPlaceholderConfigurer();    }   }