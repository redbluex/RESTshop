package pl.redblue.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ShopApplication{
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
