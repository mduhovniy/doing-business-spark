package info.duhovniy.doingbusiness.services;


import org.apache.spark.sql.DataFrame;

public interface DTFRatingService {

    String topXCountries(DataFrame df, int x);
}
