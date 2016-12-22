package info.duhovniy.doingbusiness.config;


import org.apache.spark.api.java.JavaSparkContext;

public interface DataConfig {

    JavaSparkContext javaSparkContext();
}
