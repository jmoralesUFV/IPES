package ufv.dis.final2022.JMI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class JmiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmiApplication.class, args);
	}

}
