package me.savushkin.stargate.base.baseApp;

import me.savushkin.stargate.base.baseApp.Services.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseApplication {

	public static void main(String[] args) {
		StorageService storageService = new StorageService();
		try {
			storageService.init();
		}
		catch(Exception e){

		}
		SpringApplication.run(BaseApplication.class, args);
	}
}
