package com.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import com.room.dao.EmployeeRepository;


@SpringBootApplication
//@ComponentScan("com.room")
@ComponentScan(basePackages = { "comroom" })

//@Configuration
//@ComponentScan
//@EnableCouchbaseRepositories
//@Import(EmployeeRepository.class)
//@EnableAutoConfiguration
//@PropertySource("application.properties")
public class AppMain {
	 public static void main(String[] args) {
	        SpringApplication.run(AppMain.class, args);
	    }
}