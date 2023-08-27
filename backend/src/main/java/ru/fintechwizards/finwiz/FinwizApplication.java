package ru.fintechwizards.finwiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.fintechwizards.finwiz.Security.RsaProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaProperties.class)
public class FinwizApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinwizApplication.class, args);
	}

}
