package info.duhovniy.doingbusiness.services;


import info.duhovniy.doingbusiness.config.UserConfig;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;

import java.io.Serializable;
import java.util.List;

public interface RatingService extends Serializable {

    List<String> topXCountries(JavaRDD<String> lines, int x);

    void setUserConfig(Broadcast<UserConfig> userConfig);
}
