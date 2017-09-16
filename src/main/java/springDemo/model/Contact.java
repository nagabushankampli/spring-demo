package springDemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APP_CONTACT")
public class Contact implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contactID;
	
	@NotEmpty
	@Column(name = "CONTACT_NAME",nullable = false)
	private String contactName;
	
	@Column(name = "EMAIL",nullable = false)
	private String email;
	
	@Column(name = "PHONE_NUMBER",nullable = false)
	private String phoneNumber;
	


	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = 31 * result + (contactID != null ? contactID.hashCode() : 0);
		result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactID != null ? !contactID.equals(other.contactID) : other.contactID != null) 
			return false;
		if (contactName != null ? !contactName.equals(other.contactName) : other.contactName != null) 
			return false;
		if (email != null ? !email.equals(other.email) : other.email != null) 
			return false;
		if (phoneNumber != null ? !phoneNumber.equals(other.phoneNumber) : other.phoneNumber != null)
			return false;
		
		
		return true;
	}

	@Override
	public String toString() {
		return "Contact [contactID=" + contactID.intValue() + ", contactName=" + contactName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}


}
