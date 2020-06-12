package tech.nikant.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DaoConfig {

	@Bean
	public Dao dao() {
		return new Dao();
	}
	
}
