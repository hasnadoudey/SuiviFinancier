package tn.cni.dao;

import java.util.List;

import org.hibernate.Session;

import tn.cni.domain.Type;
import tn.cni.ui.utils.HibernateUtil;




public class TypeJpaDao implements TypeDao{

	Session session = HibernateUtil.openSession();

	@SuppressWarnings("unchecked")
	public List<Type> findAll() {
		return session.createQuery("select o from Type o").list();
	}
	
	
	

}
