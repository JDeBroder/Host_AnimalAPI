package crudapi.example.animal_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.persistence.*;

@SpringBootApplication
public class AnimalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApiApplication.class, args);
	}

}
