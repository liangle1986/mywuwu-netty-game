package com.mywuwu.mysql;

import com.mywuwu.mysql.common.ds.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

@Import(DynamicDataSourceRegister.class)
@MapperScan(basePackages = "com.mywuwu.mysql.mapper")
@SpringBootApplication
public class MywuwuMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywuwuMysqlApplication.class, args);
	}

}

