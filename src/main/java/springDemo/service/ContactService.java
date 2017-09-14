package springDemo.service;

import java.util.List;

import springDemo.model.Contact;

public interface ContactService {
	
	List<Contact> findAllContacts();
	Contact findById(int id);
	Contact findByName(String name);
	void saveContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContactById(int id);
	boolean isContactExist(Contact contact);
	void deleteAllContacts();

}
