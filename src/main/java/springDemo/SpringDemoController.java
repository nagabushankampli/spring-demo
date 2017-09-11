package springDemo;



import org.springframework.web.bind.annotation.RestController;

import springDemo.model.Contact;
import springDemo.service.ContactService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	//  /contact api will retrive all contacts from contact list

	@RequestMapping(value = "/contact/", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> listAllContacts() {
		List<Contact> contacts = contactService.findAllContacts();
		if (contacts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
	}
    
}
