package info.duhovniy.doingbusiness.configuration;


import org.apache.spark.api.java.JavaSparkContext;

interface DataConfig {

    JavaSparkContext javaSparkContext();
}
