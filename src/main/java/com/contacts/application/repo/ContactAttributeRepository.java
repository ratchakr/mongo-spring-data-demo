package com.contacts.application.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.contacts.domain.metadata.ContactAttribute;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "contactattributes", path = "contactattributes")
public interface ContactAttributeRepository extends MongoRepository<ContactAttribute, Long>, CrudRepository<ContactAttribute, Long> {
	
	List<ContactAttribute> findAll();
    
    

}
