package com.multi.boot_book;

import book.BookController;
import book.IBookDAO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = BookController.class)
@MapperScan(basePackageClasses = IBookDAO.class)
public class BootBookApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootBookApplication.class, args);
	}
}