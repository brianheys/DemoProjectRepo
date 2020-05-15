package com.cec.contact.config;

import com.cec.contact.constant.CEC_Constants;
import com.zaxxer.hikari.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.sql.DataSource;

@Configuration
public class CEC_DatabaseConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(CEC_DatabaseConfig.class);

	@Bean
	public DataSource dataSource() throws URISyntaxException, SQLException {

		URI dbUri = null;
		HikariConfig config = null;

		dbUri = new URI(System.getenv(CEC_Constants.DATABASE_URL));
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = CEC_Constants.DB_URL + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setMaximumPoolSize(1);

		LOGGER.trace("Datasource configuration {}", config.toString());
		
		 final HikariDataSource ds = new HikariDataSource(config); 
		 
		 return ds;
		 
		

	}
}