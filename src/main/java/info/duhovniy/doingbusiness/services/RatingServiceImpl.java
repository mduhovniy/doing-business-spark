package info.duhovniy.doingbusiness.services;

import lombok.AllArgsConstructor;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.List;

@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    private JavaSparkContext sc;

    @Override
    public List<String> topXCountries(JavaRDD<String> lines, int x) {
        return lines.map(String::toLowerCase)
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey((a,b) -> a+b)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2)
                .take(x);
    }

    @Override
    public List<String> shoot(List<String> list, int x) {
        return topXCountries(sc.parallelize(list), x);
    }
}
