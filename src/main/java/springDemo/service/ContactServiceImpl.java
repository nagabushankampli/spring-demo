package springDemo.service;

import java.util.ArrayList;
import java.util.List;

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
		Contact.add(new Contact(3,"Nagabushan","nagbushan.k@gmail.com", "071927"));
		return Contact;
	}



}
