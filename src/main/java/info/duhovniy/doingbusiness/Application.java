package info.duhovniy.doingbusiness;

import info.duhovniy.doingbusiness.services.RatingService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    private static final List<String> LIST = Arrays.asList("Max", "Max", "Dima", "Ura", "Max", "Ivan", "Dima", "Felix");

    public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		RatingService ratingService = context.getBean(RatingService.class);

        System.out.println("---------------------------------------");
        System.out.println(String.valueOf(ratingService.shoot(LIST, 2)));
        System.out.println("---------------------------------------");

	}
}
