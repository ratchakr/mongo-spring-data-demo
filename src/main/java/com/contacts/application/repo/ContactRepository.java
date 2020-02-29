package com.contacts.application.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.contacts.domain.Contact;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends MongoRepository<Contact, Long>, CrudRepository<Contact, Long> {
	
	Contact findFirstByFirstName(String firstName);
	
/*    //@Query("{email:'?0'}")
    List<Contact> findCustomByEmail(String email);

    //@Query("{email : { $regex: ?0 } }")
    List<Contact> findCustomByRegExEmail(String domain);*/
    
    List<Contact> findAll ();
    
    Contact findById (String id);
    
    Contact findByLastName (String lastName);
    
    Contact findByEmail (String email);
    
    

}
