package tn.cni.ui.utils;

import org.hibernate.Session;

import tn.cni.dao.EtatDao;
import tn.cni.dao.EtatJpaDao;
import tn.cni.services.EtatService;
import tn.cni.services.impl.EtatServiceImpl;

public class Test {

	static Session session = HibernateUtil.openSession();
	public static void main(String[] args) {
	session.createQuery("select e from Etat e ").list();
		//session.createQuery("select o from Projet o ").list();
 	   //session.createQuery("select o from Type o ").list();
EtatDao dao = new EtatJpaDao();
//
//Etat etat = new Etat();
// projet.setName("rrr");
//dao.add(projet);
		EtatService service = new EtatServiceImpl();
//		
	service.findAll();
		
}	
}	
	



