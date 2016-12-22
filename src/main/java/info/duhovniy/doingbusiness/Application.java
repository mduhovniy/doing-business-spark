package info.duhovniy.doingbusiness;

import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.scan("info.duhovniy.doingbusiness.configuration");
		context.refresh();
		JavaSparkContext sc = context.getBean(JavaSparkContext.class);

	}
}
