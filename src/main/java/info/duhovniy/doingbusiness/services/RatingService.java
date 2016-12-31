package info.duhovniy.doingbusiness.services;


import org.apache.spark.api.java.JavaRDD;

import java.io.Serializable;
import java.util.List;

public interface RatingService extends Serializable {

    List<String> topXCountries(JavaRDD<String> lines, int x);
}
