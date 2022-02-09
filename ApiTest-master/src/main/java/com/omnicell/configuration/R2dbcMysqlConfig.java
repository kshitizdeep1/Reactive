package com.omnicell.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class R2dbcMysqlConfig extends AbstractR2dbcConfiguration {
	@Bean
	public ConnectionFactory connectionFactory() {
		// TODO Auto-generated method stub
		MySqlConnectionConfiguration options = MySqlConnectionConfiguration.builder()
			    .host("localhost")
			    .user("root")
			    .port(3306)  // optional, default 3306
			    .password("root") // optional, default null, null means has no password
			    .database("recipe") // optional, default null, null means not specifying the database
			    .build();
		ConnectionFactory connectionFactory = MySqlConnectionFactory.from(options);

		// Creating a Mono using Project Reactor
		return connectionFactory;
	}
}
