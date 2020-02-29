package com.contacts.service;

import java.util.List;

import com.contacts.domain.Contact;

public interface ContactService {

Contact addContact(Contact contact);

Contact updateProduct(Contact product);

List < Contact > getAllContacts();

Contact getContactById(String id);

void deleteContact(String id);
	
}
