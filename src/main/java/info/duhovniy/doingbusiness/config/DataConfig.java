package info.duhovniy.doingbusiness.config;


import org.apache.spark.SparkContext;
import org.apache.spark.sql.SQLContext;

import java.io.Serializable;


public interface DataConfig extends Serializable {

    SparkContext sparkContext();

    SQLContext sqlContext();
}
