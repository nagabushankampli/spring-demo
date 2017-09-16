package springDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springDemo.model.Contact;

@Repository
public interface ContactRepository extends  JpaRepository<Contact, Integer>{
	
	Contact findByContactName(String name);
}
