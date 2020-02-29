package com.contacts.application;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contacts.application.repo.ContactAttributeRepository;
import com.contacts.application.repo.ContactRepository;
import com.contacts.application.repo.CustomRepository;
import com.contacts.domain.Contact;
import com.contacts.domain.metadata.ContactAttribute;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ContactCRUDApplication implements CommandLineRunner {

	@Autowired
	ContactRepository repository;
	
	@Autowired
	ContactAttributeRepository conAttrRepo;
	
	@Autowired
	CustomRepository crepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactCRUDApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		provisionContactAttributes();
		
		deleteAll();
		addSampleData();
		listAll();
		findByFirstName();
		//findByRegex();
		findByEmail();
	}
	
	private void provisionContactAttributes() {
		
		conAttrRepo.deleteAll();
		
		log.info("adding contact fields as metadata");
		
		ContactAttribute fn = ContactAttribute.builder().name("firstName").description("First name of the contact").order(1).build();
		ContactAttribute ln = ContactAttribute.builder().name("lastName").description("Last name of the contact").order(2).build();
		ContactAttribute em = ContactAttribute.builder().name("email").description("Email of the contact").order(3).build();
		ContactAttribute city = ContactAttribute.builder().name("city").description("City of the contact").order(4).build();
		ContactAttribute ph = ContactAttribute.builder().name("phone").description("Phone number of the contact").order(5).build();
		
		List<ContactAttribute> attrs = Arrays.asList(fn, ln, em, city, ph);
		
		conAttrRepo.saveAll(attrs);
		
		log.info("listing all attributes");
		conAttrRepo.findAll().forEach(ca -> log.info("attributes name =" + ca.getName() + " desc = "+ ca.getDescription() + " order = "+ ca.getOrder()));
		
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
		
		/*Contact(String firstName, String lastName, String email, String company, LocalDate dateOfBirth,
				String country, String city, String phone, String state, String zip)*/
		
		
		LocalDate localDate = LocalDate.now();
	    System.out.println(localDate);

	      //Specific date
	      LocalDate localDate1 = LocalDate.of(1965, Month.MAY, 15);
		
		Contact c1 = Contact.builder().firstName("Theo").lastName("Walraven").email("theowal@ibm.com").company("IBM").dateOfBirth(localDate1).country("Holland").city("Amsterdam")
					.phone("234567890").state("NorthShore").zip("777777").build();
		c1.set("salary", "99999");
		c1.set("preferredContactMode", "email");
		
		LocalDate localDate2 = LocalDate.of(1982, Month.SEPTEMBER, 12);
		Contact c2 = Contact.builder().firstName("Christiano").lastName("Ronaldo").email("cr7@juve.com").company("Juventas").dateOfBirth(localDate2).country("Portugal").city("Lisbon")
				.phone("234567890").state("Balboa").zip("654432").build();
		c2.set("jersey", "7");
		c2.set("maritalStatus", "married");
		
		Contact c3 = Contact.builder().firstName("Lionel").lastName("Messi").email("leo@barca.com").city("Barcelona")
				.build();
		c3.set("playsFor", "Argentina");
		c3.set("hasEndorsement", "yes");
		
		List<Contact> contacts = Arrays.asList(c1, c2, c3);
		
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
		Contact c = repository.findFirstByFirstName("Lionel");
		System.out.println(c);
	}
	
	/*public void findByRegex() {
		System.out.println("Finding by Regex - All with address starting with ^New");
		repository.findCustomByRegExEmail("^New").forEach(u -> System.out.println(u));
	}*/
	
	public void findByEmail () {
		System.out.println("Finding Contact by email");
		Contact c = repository.findByEmail("cr7@juve.com");
		System.out.println(c);
	}
}
