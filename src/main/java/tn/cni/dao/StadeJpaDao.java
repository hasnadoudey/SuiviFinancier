package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Stade;
import tn.cni.ui.utils.HibernateUtil;

public class StadeJpaDao implements StadeDao{
	Session session = HibernateUtil.openSession();
	
    @SuppressWarnings("unchecked")
	public List<Stade>findAll() {
	return session.createQuery("select s from Stade s").list();
	

}
}
