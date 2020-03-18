package alexandra.golovchenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "alexandra.golovchenko.repository")
@EntityScan(basePackages = "alexandra.golovchenko.entity")
@ComponentScan(basePackages = {"alexandra.golovchenko.repository", "alexandra.golovchenko.entity",
        "alexandra.golovchenko.controller"})
public class Golovchenko extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Golovchenko.class, args);
    }
}
