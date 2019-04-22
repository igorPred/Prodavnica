package buissnesServices;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class LoginMetode {

	
	private SessionFactory sf =new Configuration().configure().buildSessionFactory();
	private Session sesion =sf.openSession();
	
	
	
	public boolean daLiPostojiUser (String userName ) {
		
		
		sesion.beginTransaction();
		try {
			
		Query query =sesion.createQuery("From User Where userName= : pera");
		query.setParameter("pera", userName);
		
		List < User>listOfUsers =new ArrayList ();
		
		listOfUsers=query.getResultList();
		
		if (listOfUsers.size()==1) {
			sesion.getTransaction().commit();
			System.out.println("postoji user");
			return true;
		}else {
			sesion.getTransaction().commit();
			System.out.println("Ne postojin user name");

			return false;
		}
			
			
		}catch (Exception e) {
			
			sesion.getTransaction().rollback();
			System.out.println("nneuspela tranaskcija");
			return false;
		}finally {
			sesion.close();
		}
	}
	
}
