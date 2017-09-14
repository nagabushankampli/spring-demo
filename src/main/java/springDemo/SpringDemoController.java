package springDemo;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import springDemo.model.Contact;
import springDemo.service.ContactService;
import springDemo.util.CustomErrorType;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping ("/api")
public class SpringDemoController {
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to Spring Boot Demo!";
    }
    
    public static final Logger logger = LoggerFactory.getLogger(SpringDemoController.class);

	@Autowired
	ContactService contactService;  //Service will do all required retrieval
	
	
	//  contact api will retrive all contacts from contact list

	@RequestMapping(value = "/contact/", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> listAllContacts() {
		List<Contact> contacts = contactService.findAllContacts();
		if (contacts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
	}
	
	// Retrieve single contact by id

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contact> getContact(@PathVariable("id") int id) {
		logger.info("Fetching Contact with id {}", id);
		Contact contact = contactService.findById(id);
		if (contact == null) {
			logger.error("contact with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("contact with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	
	// Retrieve single contact by name

	@RequestMapping(value = "/contact/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getContactByName(@PathVariable("name") String name) {
		logger.info("Fetching Contact with name {}", name);
		Contact contact = contactService.findByName(name);
		if (contact == null) {
			logger.error("contact with name {} not found.", name);
			return new ResponseEntity(new CustomErrorType("contact with name " + name 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	

	
	//  Create contact

	@RequestMapping(value = "/contact/", method = RequestMethod.POST)
	public ResponseEntity<?> createContact(@RequestBody Contact contact, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Contact : {}", contact);

		if (contactService.isContactExist(contact)){
			logger.error("Unable to create. A Contact with name {} already exist", contact.getContactName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Contact with name " + 
			contact.getContactName()+ " already exist."),HttpStatus.CONFLICT);
		}
		contactService.saveContact(contact);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/contact/{id}").buildAndExpand(contact.getContactID()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	//Update Contact
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateContact(@PathVariable("id") int id, @RequestBody Contact contact) {
		logger.info("Updating Contact with id {}", id);

		Contact currentContact = contactService.findById(id);

		if (currentContact == null) {
			logger.error("Unable to update. Contact with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Contact with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentContact.setContactName(contact.getContactName());
		currentContact.setEmail(contact.getEmail());
		currentContact.setPhoneNumber(contact.getPhoneNumber());
		
		contactService.updateContact(currentContact);
		return new ResponseEntity<Contact>(currentContact, HttpStatus.OK);
	}


	// Delete Contact
	
	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteContat(@PathVariable("id") int id) {
		logger.info("Fetching & Deleting Contact with id {}", id);

		Contact contact = contactService.findById(id);
		if (contact == null) {
			logger.error("Unable to delete. Contact with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Contact with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		contactService.deleteContactById(id);
		return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users-----------------------------

	@RequestMapping(value = "/contact/", method = RequestMethod.DELETE)
	public ResponseEntity<Contact> deleteAllContacts() {
		logger.info("Deleting All Contacts");

		contactService.deleteAllContacts();
		return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	}


    
}
