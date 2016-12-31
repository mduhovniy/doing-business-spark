package info.duhovniy.doingbusiness.services;

import info.duhovniy.doingbusiness.config.UserConfig;
import info.duhovniy.doingbusiness.utils.WordUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {

    @AutowiredBroadcast
    private Broadcast<UserConfig> userConfig;

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
