package fr.unilorraine.idmc.gamescatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GamesCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesCatalogApplication.class, args);
	}

}
