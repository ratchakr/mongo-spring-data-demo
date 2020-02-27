package com.contacts.application.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Data;

@Data
@Document(collection = "contacts")
public class Contact {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	@JsonAnySetter
    private Map<String, String> details;

	public Contact(String firstName, String lastName, String email, Map<String, String> details) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.details = details;
	}
	
}
