package com.design.studentMamagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.studentMamagement.mapper")
@ComponentScan(value="com.design")
public class StudentMamagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMamagementApplication.class, args);
	}

}
