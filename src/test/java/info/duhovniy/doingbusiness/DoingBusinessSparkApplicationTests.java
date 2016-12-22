package info.duhovniy.doingbusiness;

import info.duhovniy.doingbusiness.services.RatingService;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class )
//@SpringBootTest
@ActiveProfiles("dev")
public class DoingBusinessSparkApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(DoingBusinessSparkApplicationTests.class);

	@Autowired
	private JavaSparkContext javaSparkContext;

	@Autowired
    private RatingService ratingService;

	@Test
	public void testTopXCountries() {

	    List<String> list = Arrays.asList("Max", "Max", "Dima", "Ura", "Max", "Ivan", "Dima", "Felix");
        JavaRDD<String> rdd = javaSparkContext.parallelize(list);
        List<String> top2 = ratingService.topXCountries(rdd, 2);
        LOG.info("---------------------------------------");
        LOG.info(String.valueOf(top2));
        LOG.info("---------------------------------------");

    }

}
