package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Secteur;
import tn.cni.ui.utils.HibernateUtil;

public class SecteurJpaDao implements SecteurDao {

	 Session session = HibernateUtil.openSession();
		
	    @SuppressWarnings("unchecked")
		public List<Secteur>findAll() {
		return session.createQuery("select s from Secteur s").list();
		
	
	}
}
