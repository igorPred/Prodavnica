package buissnesServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import model.User;

public class MetodeRegistracija {

	private SessionFactory sf =new Configuration().configure().buildSessionFactory();
	private Session sesion =sf.openSession();
	
	
	public boolean ubaciUsera (String userName,String password) {
		
		
		 User user =new User ();
		sesion.beginTransaction();
		try {
			user.setUserName(userName);
			user.setPassword(password);
			sesion.save(user);
			sesion.getTransaction().commit();
			System.out.println("Uspesno unesen podatak");
			return true;
		}catch (Exception e) {
			
			sesion.getTransaction().rollback();
			System.out.println("greska pri unosu");
			return false;
		}finally {
			sesion.close();
		}
		
	}
	
	
}
