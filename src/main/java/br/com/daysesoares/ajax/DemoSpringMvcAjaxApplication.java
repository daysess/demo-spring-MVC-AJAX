package br.com.daysesoares.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.daysesoares.ajax.services.SocialMetaTagService;

@SpringBootApplication
public class DemoSpringMvcAjaxApplication implements CommandLineRunner{
	
	@Autowired
	private SocialMetaTagService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringMvcAjaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
