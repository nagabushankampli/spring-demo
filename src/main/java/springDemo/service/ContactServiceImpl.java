package springDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springDemo.model.Contact;
import springDemo.repository.ContactRepository;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	

	public List<Contact> findAllContacts() {
        return contactRepository.findAll();
	}
	
	
	
	public Contact findById(Integer id) {
		return contactRepository.findOne(id);
	}
	
	
	public Contact findByName(String name) {
		return contactRepository.findByContactName(name);
	}
	
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	public void updateContact(Contact contact) {
		saveContact(contact);
	}

	public void deleteContactById(Integer id) {
		contactRepository.delete(id);
	}
	
	public void deleteAllContacts(){
		contactRepository.deleteAll();
	}

	public boolean isContactExist(Contact contact) {
		return findByName(contact.getContactName())!=null;
	}
	
		
	



}
