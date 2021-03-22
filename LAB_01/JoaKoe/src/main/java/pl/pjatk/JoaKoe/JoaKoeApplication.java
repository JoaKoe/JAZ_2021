package pl.pjatk.JoaKoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class JoaKoeApplication {

	public static void main(String[] args) {


		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Person kobieta = context.getBean("person", Person.class);
		kobieta.setName("Ala");
		kobieta.PrzedstawSie();



	}







}
