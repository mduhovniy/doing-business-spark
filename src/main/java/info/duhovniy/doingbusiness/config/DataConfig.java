package info.duhovniy.doingbusiness.config;


import org.apache.spark.api.java.JavaSparkContext;

import java.io.Serializable;


public interface DataConfig extends Serializable {

    JavaSparkContext javaSparkContext();
}
