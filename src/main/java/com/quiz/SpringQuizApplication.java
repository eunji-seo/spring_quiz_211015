package com.quiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication

@MapperScan(basePackages = "com.quiz.*")  // mapper scan 추가!!!
public class SpringQuizApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringQuizApplication.class, args);
	}

	
}
