package info.duhovniy.doingbusiness.services;

import info.duhovniy.doingbusiness.config.UserConfig;
import info.duhovniy.doingbusiness.utils.WordUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.List;


//@Service
//@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    private Broadcast<UserConfig> userConfig;

    public void setUserConfig(Broadcast<UserConfig> userConfig) {
        this.userConfig = userConfig;
    }

    @Override
    public List<String> topXCountries(JavaRDD<String> lines, int x) {
        return lines.map(String::toLowerCase)
                .flatMap(WordUtils::mSplit)
                .filter(word -> !userConfig.value().exclude.contains(word))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a,b) -> a+b)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2)
                .take(x);
    }
}
