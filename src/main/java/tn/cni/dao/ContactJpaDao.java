package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Contact;
import tn.cni.ui.utils.HibernateUtil;

public class ContactJpaDao implements ContactDao {
	
	Session session = HibernateUtil.openSession();
	
    @SuppressWarnings("unchecked")
	public List<Contact> findAll() {
	return session.createQuery("select c from Contact c").list();
	

}


 public void add(Contact contact) {
 	
	session.beginTransaction();
	session.save(contact);
	session.getTransaction().commit();
	

}
	public Contact edit(Contact contact) {
		session.beginTransaction();
		Contact p =(Contact)session.merge(contact);
		session.getTransaction().commit();
		return p;
	}


	public void delete(Long id) {
	session.beginTransaction();
	Contact p =findById(id);
   session.delete(p);
   session.getTransaction().commit();	
	}


	public Contact findById(Long id) {
	
 return (Contact) session.get(Contact.class,id);
	}



	

}
