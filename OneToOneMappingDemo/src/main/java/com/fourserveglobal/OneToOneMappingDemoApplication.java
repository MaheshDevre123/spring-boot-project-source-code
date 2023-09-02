package com.fourserveglobal;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fourserveglobal.entity.User;
import com.fourserveglobal.entity.UserProfile;
//import com.fourserveglobal.repository.UserProfileRepository;
import com.fourserveglobal.repository.UserRepository;


@SpringBootApplication
public class OneToOneMappingDemoApplication  {

	public static void main(String[] args)  {
		SpringApplication.run(OneToOneMappingDemoApplication.class, args);
	}
	
	
	 

}
