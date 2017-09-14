package springDemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import springDemo.model.Contact;

@Service("contactService")
public class ContactServiceImpl implements ContactService{
	
	
	private static List<Contact> contacts;
	
	
	static{
		contacts= populateDummyContacts();
	}

	public List<Contact> findAllContacts() {
		return contacts;
	}
	
	private static List<Contact> populateDummyContacts(){
		List<Contact> Contact = new ArrayList<Contact>();
		Contact.add(new Contact(1,"Bushan","Bushan.k@gmail.com", "1234"));
		Contact.add(new Contact(2,"Nag","nag.k@gmail.com", "9872"));
		Contact.add(new Contact(3,"Kampli","kampli.k@gmail.com", "37373"));
		Contact.add(new Contact(4,"Nagabushan","nagbushan.k@gmail.com", "071927"));
		return Contact;
	}
	
	
	public Contact findById(int id) {
		for(Contact contact : contacts){
			if(contact.getContactID() == id){
				return contact;
			}
		}
		return null;
	}
	
	
	public Contact findByName(String name) {
		for(Contact contact : contacts){
			if(contact.getContactName().equalsIgnoreCase(name)){
				return contact;
			}
		}
		return null;
	}
	
	public void saveContact(Contact contact) {
		contact.setContactID((int)Math.random());
		contacts.add(contact);
	}

	public void updateContact(Contact contact) {
		int index = contacts.indexOf(contact);
		contacts.set(index, contact);
	}

	public void deleteContactById(int id) {
		
		for (Iterator<Contact> iterator = contacts.iterator(); iterator.hasNext(); ) {
		    Contact contact = iterator.next();
		    if (contact.getContactID() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isContactExist(Contact contact) {
		return findByName(contact.getContactName())!=null;
	}
	
	public void deleteAllContacts(){
		contacts.clear();
	}

	
	



}
