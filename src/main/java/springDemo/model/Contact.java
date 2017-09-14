package springDemo.model;

public class Contact {
	
	private int contactID;
		
	private String contactName;
	
	private String email;
	
	private String phoneNumber;
	
	public Contact(){
		contactID = 0;
		contactName = "Dummy";
		email = "Dummy";
		phoneNumber = "Dummy";
	}
	
	public Contact(int contactID,String contactName,String email,String phoneNumber){
		this.contactID = contactID;
		this.contactName = contactName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
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
		result = prime * result + (int) (contactID ^ (contactID >>> 32));
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
		if (contactID != other.contactID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", contactName=" + contactName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}


}
