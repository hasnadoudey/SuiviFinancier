package tn.cni.services.impl;

import java.util.List;

import tn.cni.dao.ContactDao;
import tn.cni.dao.ContactJpaDao;
import tn.cni.domain.Contact;
import tn.cni.services.ContactService;

public class ContactServiceImpl implements ContactService {

	
	ContactDao dao = new ContactJpaDao();
	
	
	
	public ContactDao getDao() {
		return dao;
	}

	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	public void add(Contact contact) {
		dao.add(contact);
		
	}

	public List<Contact> findAll() {
		return dao.findAll();
	}


public Contact edit(Contact contact) {
		
		return dao.edit(contact);
	}

	public void delete(Long id) {
		dao.delete(id);	
	}

	public Contact findById(Long id) {
		
		return dao.findById(id);
	}

	

	

}
