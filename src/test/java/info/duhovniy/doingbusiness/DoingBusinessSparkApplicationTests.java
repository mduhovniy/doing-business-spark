package info.duhovniy.doingbusiness;

import info.duhovniy.doingbusiness.services.RatingService;
import org.apache.spark.SparkContext;
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
    private SparkContext sc;

	@Autowired
    private RatingService ratingService;

	@Test
	public void testTopXCountries() {

	    String list = "Max  Max   Dima  Ura Max     Ivan Dima Felix";
        List<String> top = ratingService.topXCountries(new JavaSparkContext(sc).parallelize(Arrays.asList(list)), 3);
        LOG.info("---------------------------------------");
        top.forEach(System.out::println);
        LOG.info(String.valueOf(top));
        LOG.info("---------------------------------------");

    }

}
