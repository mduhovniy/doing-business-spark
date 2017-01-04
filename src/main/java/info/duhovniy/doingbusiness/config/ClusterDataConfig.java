package info.duhovniy.doingbusiness.config;


import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ClusterDevelopment
public class ClusterDataConfig implements DataConfig {

    @Bean
    public SparkContext sparkContext() {
        SparkConf conf = new SparkConf().setAppName("WB Doing Business with Spark");
        return new SparkContext(conf);
    }

    @Bean
    public SQLContext sqlContext() {
        return new SQLContext(sparkContext());
    }
}
