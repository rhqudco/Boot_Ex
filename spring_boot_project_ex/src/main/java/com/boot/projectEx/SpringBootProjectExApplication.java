package com.boot.projectEx;

import com.boot.projectEx.controller.CartController;
import com.boot.projectEx.controller.MemberController;
import com.boot.projectEx.controller.ProductController;
import com.boot.projectEx.dao.ICartDAO;
import com.boot.projectEx.dao.IMemberDAO;
import com.boot.projectEx.dao.IProductDAO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

@ComponentScan(basePackages = {"com.boot.projectEx.service"})

@ComponentScan(basePackageClasses = MemberController.class)
@MapperScan(basePackageClasses = IMemberDAO.class)

@ComponentScan(basePackageClasses = ProductController.class)
@MapperScan(basePackageClasses = IProductDAO.class)

@ComponentScan(basePackageClasses = CartController.class)
@MapperScan(basePackageClasses = ICartDAO.class)

public class SpringBootProjectExApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectExApplication.class, args);
	}
}