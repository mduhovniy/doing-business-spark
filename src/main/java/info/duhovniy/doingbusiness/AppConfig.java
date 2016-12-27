package info.duhovniy.doingbusiness;


import info.duhovniy.doingbusiness.config.DataConfig;
import info.duhovniy.doingbusiness.config.UserConfig;
import info.duhovniy.doingbusiness.services.RatingService;
import info.duhovniy.doingbusiness.services.RatingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@AllArgsConstructor
@ComponentScan({ "info.duhovniy.doingbusiness.*" })
@PropertySource("classpath:user.properties")
public class AppConfig {

    private UserConfig userConfig;

    private DataConfig dataConfig;

    @Bean
    public RatingService ratingService() {
        RatingService ratingService = new RatingServiceImpl();
        ratingService.setUserConfig(dataConfig.javaSparkContext().broadcast(userConfig));
        return ratingService;
    }
}
