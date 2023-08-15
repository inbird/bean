package com.example.bean;

import com.example.bean.config.AppConfig;
import com.example.bean.service.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanApplication.class, args);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		//AnnotationConfigApplicationContext를 통해 스프링 컨테이너에 등록된 모든 빈 조회
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
			//사용자가 직접 등록한 어플리케이션 Bean인 경우
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object objBean = applicationContext.getBean(beanDefinitionName);
				System.out.println("BeanName: " + beanDefinitionName + ", Object: " + objBean);
			}

		}

		Hello hello = applicationContext.getBean("helloBean", Hello.class);
		System.out.println("Hello Bean: [" + hello + "]");
		hello.sayHello();

		Pay pay = applicationContext.getBean("payBean", Pay.class);
		pay.pay();

	}
}

