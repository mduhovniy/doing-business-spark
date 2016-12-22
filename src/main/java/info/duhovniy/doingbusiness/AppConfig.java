package info.duhovniy.doingbusiness;


import info.duhovniy.doingbusiness.config.DataConfig;
import info.duhovniy.doingbusiness.services.RatingService;
import info.duhovniy.doingbusiness.services.RatingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "info.duhovniy.doingbusiness.*" })
@AllArgsConstructor
//@PropertySource("classpath:user.properties")
public class AppConfig {

    private DataConfig dataConfig;

    @Bean
    public RatingService ratingService() {
        return new RatingServiceImpl(dataConfig.javaSparkContext());
    }
//    @Bean
//    public PropertySourcesPlaceholderConfigurer configurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
