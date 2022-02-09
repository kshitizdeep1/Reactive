//package com.omnicell.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//
//import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
//import io.r2dbc.postgresql.PostgresqlConnectionFactory;
//import io.r2dbc.spi.ConnectionFactory;
//
//@Configuration
//public class R2DBConfig extends AbstractR2dbcConfiguration {
//
//	@Bean
//	public ConnectionFactory connectionFactory() {
//		// TODO Auto-generated method stub
//		return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
//				.host("localhost")
//				.port(5432)
//				.username("postgres")
//				.password("demo")
//				.database("recipe")
//				.build());
//	}
//
//}
