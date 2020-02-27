/*package com.contacts.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contacts.application.domain.Contact;
import com.contacts.domain.Greeting;
import com.contacts.service.ContactService;

@RestController
public class ContactController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
    private ContactService contactService;
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/contact/add")
	public ResponseEntity<Contact> create(@RequestBody Contact c){
        System.out.println("  Creating Contact  ");
		Contact result = contactService.addContact(c);
        return ResponseEntity.ok().body(result);
    }

	@RequestMapping(method = RequestMethod.GET, value="/fetchall")
    public ResponseEntity<List<Contact>> getContacts() {
		System.out.println("  Get All Contacts  ");
    	return ResponseEntity.ok().body(contactService.getAllContacts());
    }

    @GetMapping(path = "/contacts/{id}")
    public ResponseEntity < Contact > getProductById(@PathVariable String id) {
        return ResponseEntity.ok().body(contactService.getContactById(id));
    }

    @PostMapping(path = "/add")
    public ResponseEntity < Contact > createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok().body(this.contactService.addContact(contact));
    }
	
}
*/