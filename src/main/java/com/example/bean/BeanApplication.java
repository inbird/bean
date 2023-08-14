package com.example.bean;

import com.example.bean.config.AppConfig;
import com.example.bean.test.Hello;
import com.example.bean.test.HelloEnglishImpl;
import com.example.bean.test.HelloKoreaImpl;
import com.example.bean.test.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanApplication.class, args);

		//Hello Interface의 구현체를 HelloEnglishImpl => HelloKoreaImpl 로 변경하는 경우
		//Hello hello = new HelloEnglishImpl();
//		Hello hello = new HelloKoreaImpl();
//		hello.sayHello();

		//위와 같이 수정하는 경우 소스 자체의 수정이 필요하며 객체지향 원칙에 위배
		//Hello hello = new HelloEnglishImpl();
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName);
			System.out.println("BeanName: " + beanDefinitionName + ", Object: " + bean);
		}

//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//
		Hello hello = ac.getBean("getHello", Hello.class);
		hello.sayHello();


		Pay pay = ac.getBean("getPay", Pay.class);
		pay.pay();
	}
}

