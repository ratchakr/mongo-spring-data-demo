package com.contacts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.application.domain.Contact;
import com.contacts.application.repo.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
    private ContactRepository contactRepository;
	
	@Override
	public Contact addContact(Contact contact) {
		// TODO Auto-generated method stub
		contactRepository.save(contact);
		return null;
	}

	@Override
	public Contact updateProduct(Contact product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(String id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id);
	}

	@Override
	public void deleteContact(String id) {
		// TODO Auto-generated method stub

	}

}
