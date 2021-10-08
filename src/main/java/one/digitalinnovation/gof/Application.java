package one.digitalinnovation.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot project generated using <a href="https://start.spring.io/">Spring Initializr</a>.
 *
 * Project dependencies installed via Spring Initializr:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * Project dependencies installed via <a href="https://mvnrepository.com/">MVN Repository</a>:
 * - OpenAI / Swagger
 *
 * @author <a href="https://github.com/sergiotavuencas">sergiotavuencas</a>
 */

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
