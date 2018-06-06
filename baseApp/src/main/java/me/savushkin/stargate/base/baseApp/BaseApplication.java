package me.savushkin.stargate.base.baseApp;

import me.savushkin.stargate.base.baseApp.Services.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BaseApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BaseApplication.class);
	}

	public static void main(String[] args) {
		StorageService storageService = new StorageService();
		try {
			storageService.init();
		} catch(Exception e){

		}

		SpringApplication.run(BaseApplication.class, args);
	}
}
