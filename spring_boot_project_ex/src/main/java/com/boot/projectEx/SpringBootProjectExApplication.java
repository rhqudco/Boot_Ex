package com.boot.projectEx;

import com.boot.projectEx.controller.MemberController;
import com.boot.projectEx.dao.IMemberDAO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.boot.projectEx.service"})
@ComponentScan(basePackageClasses = MemberController.class)
@MapperScan(basePackageClasses = IMemberDAO.class)
public class SpringBootProjectExApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectExApplication.class, args);
	}
}