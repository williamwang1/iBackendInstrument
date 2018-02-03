

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;

import model.Company;
import model.Product;

@SpringBootApplication
public class JspRmqSpringBootOjectMessageConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspRmqSpringBootOjectMessageConsumerApplication.class, args);
	}
	
}
