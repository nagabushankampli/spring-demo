package springDemo;

import org.springframework.web.client.RestTemplate;

import springDemo.model.Contact;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class SpringBootRestTestClient {
	
		 
	    public static final String REST_SERVICE_URI = "http://localhost:8081//api";
	     
	    /* GET */
	    @SuppressWarnings("unchecked")
	    private static void listAllContacts(){
	        System.out.println("Testing listAllContacts API-----------");
	         
	        RestTemplate restTemplate = new RestTemplate();
	        List<LinkedHashMap<String, Object>> contactMap = restTemplate.getForObject(REST_SERVICE_URI+"/contact/", List.class);
	         
	        if(contactMap!=null){
	            for(LinkedHashMap<String, Object> map : contactMap){
	                System.out.println("Contact : Contact ID="+map.get("contactID")+", Contact Name="+map.get("contactName")+", Email="+map.get("email")+", Phone Number="+map.get("phoneNumber"));;
	            }
	        }else{
	            System.out.println("No contact exist----------");
	        }
	    }
	     
	    /* GET */
	    private static void getContact(){
	        System.out.println("Testing getContact API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        Contact contact = restTemplate.getForObject(REST_SERVICE_URI+"/contact/1", Contact.class);
	        System.out.println(contact);
	    }
	     
	    /* POST */
	    private static void createContact() {
	        System.out.println("Testing create Contact API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        Contact contact = new Contact(5,"TestRest2","Rest@Spring.com","1233");
	        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/contact/", contact, Contact.class);
	        System.out.println("Location : "+uri.toASCIIString());
	    }
	 
	    /* PUT */
	    private static void updateContact() {
	        System.out.println("Testing update Contact API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        Contact contact  = new Contact(1,"updateRest","UpdateRest@spring.com", "1222");
	        restTemplate.put(REST_SERVICE_URI+"/contact/1", contact);
	        System.out.println(contact);
	    }
	 
	    /* DELETE */
	    private static void deleteContact() {
	        System.out.println("Testing delete Contact API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete(REST_SERVICE_URI+"/contact/3");
	    }
	 
	 
	    /* DELETE */
	    private static void deleteAllContacts() {
	        System.out.println("Testing all delete contacts API----------");
	        RestTemplate restTemplate = new RestTemplate();
	        restTemplate.delete(REST_SERVICE_URI+"/contact/");
	    }
	 
	    public static void main(String args[]){
	        listAllContacts();
	        getContact();
	        createContact();
	        listAllContacts();
	        updateContact();
	        listAllContacts();
	        deleteContact();
	        listAllContacts();
	        deleteAllContacts();
	        listAllContacts();
	    }
	}


