package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(ApplicationConfig.class)
@ComponentScan("controller")
@EnableJpaRepositories("repository")
@EntityScan(basePackages = "model.entities")
public class UserRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserRestfulApplication.class, args);
	}
}