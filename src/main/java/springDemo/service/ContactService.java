package springDemo.service;

import java.util.List;

import springDemo.model.Contact;

public interface ContactService {
	
	List<Contact> findAllContacts();
	Contact findById(Integer id);
	Contact findByName(String name);
	void saveContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContactById(Integer id);
	boolean isContactExist(Contact contact);
	void deleteAllContacts();

}
