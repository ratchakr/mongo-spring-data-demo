package com.contacts.application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contacts.application.domain.Contact;
import com.contacts.application.repo.ContactRepository;
import com.contacts.application.repo.CustomRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ContactCRUDApplication implements CommandLineRunner {

	@Autowired
	ContactRepository repository;
	
	@Autowired
	CustomRepository crepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactCRUDApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		findByFirstName();
		//findByRegex();
	}
	
	public void deleteAll() {
		System.out.println("Deleting all contacts..");
		repository.deleteAll();
	}
	
	public void addSampleData() {
		System.out.println("Adding sample contacts");
		/*Map<String, String> rafaOtherInfo = new HashMap<String, String>();
		rafaOtherInfo.put("phone", "333444555");*/
		
		//repository.save(new Contact("Rafa", "Nadal", "rafa@frenchopen.com", rafaOtherInfo));
		
/*		repository.save(new Contact("Christiano", "Ronaldo", "cr7@juve.com", null));
		repository.save(new Contact("Lionel", "Messi", "leo@barca.com", null));
		repository.save(new Contact("Paul", "Pogba", "pp@manu.com", null));
		repository.save(new Contact("Eden", "Hazard", "eden@rma.com", null));
*/		
		/*repository.save(new Users("Stefan Edberg", "London", 22222d));
		repository.save(new Users("Novac Jocovic", "Melbourne", 333333d));
		repository.save(new Users("Roger Fedrer", "Zurich", 44444d));*/
		
		
		Map<String, String> cd1 = new HashMap<>();
		cd1.put("ph", "123");
		cd1.put("location", "Germany");
		
		Map<String, String> cd2 = new HashMap<>();
		cd2.put("salary", "99000");
		cd2.put("middleName", "NA");
		
		Contact c1 = new Contact("theo", "walraven", "lm@barca.com", cd1);
		
		
		Contact c2 = new Contact("Paul", "Mcenroe", "pp@manutd.com", cd2);
		
		List<Contact> contacts = Arrays.asList(c1, c2);
		

		
		repository.saveAll(contacts);
		
		
		
		ObjectMapper mapper = new ObjectMapper();
	     String jsonData = null;
		try {
			jsonData = mapper.writeValueAsString(contacts);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println(jsonData);
		
		
		
	}
	
	public void listAll() {
		System.out.println("Listing sample contacts");
		repository.findAll().forEach(c -> System.out.println(c));
	}
	
	public void findByFirstName() {
		System.out.println("Finding Contact by first by Name");
		Contact c = repository.findFirstByFirstName("ABC");
		System.out.println(c);
	}
	
	/*public void findByRegex() {
		System.out.println("Finding by Regex - All with address starting with ^New");
		repository.findCustomByRegExEmail("^New").forEach(u -> System.out.println(u));
	}*/
	
	public void findByEmail () {
		Contact c = repository.findByEmail("cr7@juve.com");
		System.out.println(c);
	}
}
