package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER= LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentImplementTwo")ComponentDependency componentDependency, MyBean myBean, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency=componentDependency;
		this.myBean=myBean;
		this.myBeanWithProperties=myBeanWithProperties;
		this.userPojo=userPojo;
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUserInDatabase();

	}
	private void saveUserInDatabase(){
		User user1 = new User("Camilo", "test1@mail.com", LocalDate.of(1989,01,26));
		User user2 = new User("juan", "test2@mail.com", LocalDate.of(1990,01,26));
		User user3 = new User("pedro", "test3@mail.com", LocalDate.of(1991,01,26));
		User user4 = new User("daniel", "test4@mail.com", LocalDate.of(1992,01,26));
		User user5 = new User("Sara", "test5@mail.com", LocalDate.of(1993,01,26));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5);
		list.stream().forEach(userRepository::save);
	}


	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		System.out.println(myBeanWithProperties.function());
		System.out.printf(userPojo.getAge()+ " prueba");

		try{
			//error
		}catch (Exception e){
			LOGGER.error("Esto es un error del aplicativo "+ e);
		}
	}
}
