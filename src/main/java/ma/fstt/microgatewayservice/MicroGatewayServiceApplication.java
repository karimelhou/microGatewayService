package ma.fstt.microgatewayservice;

import ma.fstt.filters.ErrorFilter;
import ma.fstt.filters.PostFilter;
import ma.fstt.filters.PreFilter;
import ma.fstt.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroGatewayServiceApplication.class, args);
		System.out.println("Zuul server is running...");
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}


