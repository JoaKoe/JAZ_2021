package pl.pjatk.JoaKoe;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class JoaKoeApplicationTests extends Mockito {

	@Test
	void annotationTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		Person person = context.getBean("person", Person.class);
		person.setName("Jan");
		Assert.isTrue(person.getName() == "Jan");


		PersonDb db = context.getBean(PersonDb.class);
		Assert.isInstanceOf(Person[].class, db.getPersonArray());

		context.scan("pl.pjatk.JoaKoe");
		context.refresh();


		PersonRepository repository = context.getBean(PersonRepository.class);

		repository.save(person);
		repository.getDb();
		db = repository.getDb();
		Person[] list = db.getPersonArray();
		Assert.isTrue(list.length==1000);
		Assert.isTrue(list[0]==person);


	}
	void beanCofigTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");;
		Person person = context.getBean("person", Person.class);
		person.setName("Jan");
		Assert.isTrue(person.getName() == "Jan");


		PersonDb db = context.getBean(PersonDb.class);
		Assert.isInstanceOf(Person[].class, db.getPersonArray());



		PersonRepository repository = context.getBean(PersonRepository.class);

		repository.save(person);
		repository.getDb();
		db = repository.getDb();
		Person[] list = db.getPersonArray();
		Assert.isTrue(list.length==1000);
		Assert.isTrue(list[0]==person);

	}
}
