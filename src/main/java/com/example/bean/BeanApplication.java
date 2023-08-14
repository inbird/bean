package com.example.bean;

import com.example.bean.config.AppConfig;
import com.example.bean.test.Hello;
import com.example.bean.test.Pay;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanApplication.class, args);

		//Hello Interface의 구현체를 HelloEnglishImpl => HelloKoreaImpl 로 변경하는 경우
		//Hello hello = new HelloEnglishImpl();
		//Hello hello = new HelloKoreaImpl();
		//hello.sayHello();

		//위와 같이 수정하는 경우 소스 자체의 수정이 필요하며 객체지향 원칙에 위배됨
		//Bean 리스트 중 사용자가 등록한 Application Bean 목록 조회
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
			if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object objBean = applicationContext.getBean(beanDefinitionName);
				System.out.println("BeanName: " + beanDefinitionName + ", Object: " + objBean);
			}

		}

		Hello hello = applicationContext.getBean("getHello", Hello.class);
		System.out.println("Hello Object: [" + hello + "]");
		hello.sayHello();

		Pay pay = applicationContext.getBean("getPay", Pay.class);
		pay.pay();


		//https://mangkyu.tistory.com/75
		//https://tecoble.techcourse.co.kr/post/2023-05-22-configuration/

	}
}

