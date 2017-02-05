package tn.cni.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import tn.cni.domain.Contact;
import tn.cni.services.ContactService;
import tn.cni.services.impl.ContactServiceImpl;


@ManagedBean(name="contactBean")
@SessionScoped

public class ContactBean implements Serializable {
	

	private static final long serialVersionUID = 5131480858265056151L;
	ContactService contactService = new ContactServiceImpl();
	
	private int id;
	private String name;
	private String email;
	private String message;
	
	public ContactBean() {
		
	}
	//################add project#################//
	public void addContact(ActionEvent e){
		
				
				Contact contact = new Contact();
				
				contact.setId(id);
				contact.setEmail(email);
				contact.setMessage(message);
				contact.setMessage(message);
				contactService.add(contact);
					
					
				}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	

}
