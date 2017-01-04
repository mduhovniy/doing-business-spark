package info.duhovniy.doingbusiness;

import info.duhovniy.doingbusiness.config.DataConfig;
import info.duhovniy.doingbusiness.services.DTFRatingService;
import info.duhovniy.doingbusiness.services.RatingService;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import java.util.List;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		RatingService ratingService = context.getBean(RatingService.class);
        DTFRatingService ratingServiceDF = context.getBean(DTFRatingService.class);
        JavaSparkContext sc = new JavaSparkContext(context.getBean(DataConfig.class).sparkContext());


        List<String> top = ratingService.topXCountries(sc.textFile("datasource/input/test.txt"), 3);
        System.out.println("---------------------------------------");
        System.out.println(String.valueOf(top));
        System.out.println("---------------------------------------");

        SQLContext ssc = context.getBean(DataConfig.class).sqlContext();
        DataFrame df = ssc.read().json("datasource/input/test_j.*");
        df.show();
        df.printSchema();
        df.groupBy("name").count().sort("count").show();

        System.out.println("---------------------------------------");
        System.out.println(ratingServiceDF.topXCountries(df, 3));
        System.out.println("---------------------------------------");

        sc.stop();
    }
}
