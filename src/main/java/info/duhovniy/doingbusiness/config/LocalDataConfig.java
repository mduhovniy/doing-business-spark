package info.duhovniy.doingbusiness.config;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@LocalDevelopment
public class LocalDataConfig implements DataConfig {

    @Bean
    public JavaSparkContext javaSparkContext() {
        SparkConf conf = new SparkConf();
        conf.setAppName("WB Doing Business with Spark").setMaster("local[*]");
        return new JavaSparkContext(conf);
    }
}
