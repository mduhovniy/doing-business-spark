package info.duhovniy.doingbusiness.services;

import org.apache.spark.api.java.JavaRDD;

import java.util.List;


public class RatingServiceImpl implements RatingService {

    @Override
    public List<String> topXCountries(JavaRDD<String> lines, int x) {
        lines.map(String::toLowerCase)
                .rdd();
        return null;
    }
}
