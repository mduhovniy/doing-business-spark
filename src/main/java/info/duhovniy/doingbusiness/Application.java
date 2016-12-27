package info.duhovniy.doingbusiness;

import info.duhovniy.doingbusiness.config.DataConfig;
import info.duhovniy.doingbusiness.config.LocalDataConfig;
import info.duhovniy.doingbusiness.config.LocalDevelopment;
import info.duhovniy.doingbusiness.services.RatingService;
import lombok.AllArgsConstructor;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		RatingService ratingService = context.getBean(RatingService.class);
        JavaSparkContext sc = context.getBean(DataConfig.class).javaSparkContext();

        List<String> top = ratingService.topXCountries(sc.textFile("datasource/input/*.txt"), 3);
        System.out.println("---------------------------------------");
        System.out.println(String.valueOf(top));
        System.out.println("---------------------------------------");

	}
}
