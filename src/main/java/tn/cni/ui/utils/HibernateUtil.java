package tn.cni.ui.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	private static Session session = null;
	
	//Créer l'objet SessionFactory
	private static SessionFactory buildSessionFactory(){
		try {
			Configuration configuration= new Configuration();
			configuration.configure("hibernate.cfg.xml");  	
			
			//serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			return configuration.buildSessionFactory(serviceRegistry);
			
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	
	//methodes util
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
	}
     public static Session openSession() {
          return sessionFactory.openSession();  
            
     }   
      public static Session getCurrentSession() {
           return sessionFactory.getCurrentSession();
           
      }
      
      public static void close(){
    	  
    	  if(sessionFactory!=null){
    		  sessionFactory.close();
    	  }
    
           
      }






} 
      
      
      
     
