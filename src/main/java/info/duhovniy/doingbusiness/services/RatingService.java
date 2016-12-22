package info.duhovniy.doingbusiness.services;


import org.apache.spark.api.java.JavaRDD;

import java.util.List;

public interface RatingService {

    List<String> topXCountries(JavaRDD<String> lines, int x);

    List<String> shoot(List<String> list, int x);
}
