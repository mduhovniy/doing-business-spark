package info.duhovniy.doingbusiness.configuration;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ClusterDevelopment
public class ClusterDataConfig implements DataConfig {

    @Bean
    public JavaSparkContext javaSparkContext() {
        SparkConf conf = new SparkConf();
        conf.setAppName("WB Doing Business with Spark");
        return new JavaSparkContext(conf);
    }
}
