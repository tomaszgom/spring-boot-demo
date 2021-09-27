package tg.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * ClientRequest ORM object, mapped with database, used to handle managing data within application
 */


@Entity
//@Table(name="CLIENT_REQUEST")
public class ClientRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	
	@Size(min = 1, max = 25)
	private String firstName;
	
	@Size(min = 1, max = 25)
	private String lastName;
	
	private String emailAddress;
	private String postalAddress;
	private String phone;
	private String contactPurpose;
	
	public ClientRequest() {
		
	}
	
	public ClientRequest(String firstName, String lastName, String emailAddress, String postalAddress,
			String phone, String contactPurpose) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.postalAddress = postalAddress;
		this.phone = phone;
		this.contactPurpose = contactPurpose;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContactPurpose() {
		return contactPurpose;
	}
	public void setContactPurpose(String contactPurpose) {
		this.contactPurpose = contactPurpose;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		ClientRequest other = (ClientRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
