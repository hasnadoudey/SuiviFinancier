package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;


import tn.cni.domain.Nature;
import tn.cni.ui.utils.HibernateUtil;

public class NatureJpaDao implements NatureDao {

	
	Session session = HibernateUtil.openSession();
	
    @SuppressWarnings("unchecked")
	public List<Nature> findAll() {
		return session.createQuery("select n from Nature n").list();
	}

}
