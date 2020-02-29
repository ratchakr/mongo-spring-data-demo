package com.contacts.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.*;


@Data
@Document(collection = "contacts")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	private String company;
	private LocalDate dateOfBirth;
	
	

	private boolean emailOptOut;
	
	private boolean doNoCall;
	
	private String country;
	
	private String city;
	
	private String phone;
	
	private String state;
	
	private String zip;
	
	@CreatedDate
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
	
	@Builder.Default
	private Map<String, String> extra = new HashMap<String, String>();

	// setter
	@JsonAnySetter
	public void set(String name, String value) {
		extra.put(name, value);
	}

	// getter
	@JsonAnyGetter
	public Object get(String name) {
		return extra.get(name);
	}
	
}
