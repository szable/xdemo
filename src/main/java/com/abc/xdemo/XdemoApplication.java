package com.abc.xdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.abc.xdemo.mapper")
@SpringBootApplication
public class XdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdemoApplication.class, args);
	}

}
