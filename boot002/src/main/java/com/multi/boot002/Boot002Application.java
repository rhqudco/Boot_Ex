package com.multi.boot002;

import com.multi.file.FileDownloadController;
import com.multi.file.FileUploadController;
import com.multi.product.IProductDAO;
import com.multi.product.ProductController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ProductController.class)
@ComponentScan(basePackageClasses = FileUploadController.class)
@ComponentScan(basePackageClasses = FileDownloadController.class)
@MapperScan(basePackageClasses = IProductDAO.class)
public class Boot002Application {
	public static void main(String[] args) {
		SpringApplication.run(Boot002Application.class, args);

	}
}