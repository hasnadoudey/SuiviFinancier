package tn.cni.services;

import java.util.List;


import tn.cni.domain.Contact;

public interface ContactService {

public void add(Contact contact);
	
	public List<Contact> findAll();
	
	public Contact edit(Contact contact);
		
	public void delete(Long id);
		
	public Contact findById(Long id);
	

}
