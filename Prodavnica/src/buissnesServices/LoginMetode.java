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
	
	
	
	public boolean daLiPostojiUser (String userName ) {
		
		
		Session sesion =sf.openSession();
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
	public boolean daLiJeDobarPassowrd (String userName,String password ) {
		
	
	
		
		
		List <String>listOfPasswords =new ArrayList ();
		boolean b=true ;
		 Session sesion =sf.openSession();
		sesion.beginTransaction();
		try {
			
		Query query =sesion.createQuery("From password Where userName= : pera");
		query.setParameter("pera", userName);
		
		
		
		listOfPasswords=query.getResultList();
		
		for (String s :listOfPasswords) {
		if ( s.equals(password)) {
			b=true;
			System.out.println("Ok je pass");
			return b;
		}else {
			b=false;
			System.out.println("pass je los");
			return b;
		 }
		}
		sesion.getTransaction().commit();
		
		return b;
	
			
			
		}catch (Exception e) {
			
			sesion.getTransaction().rollback();
			System.out.println("nneuspela tranaskcija");
			return false;
		}finally {
			sesion.close();
		}
		
		
	
		
		
		
		
	}		
	public User vratiUsera (String userName,String password)	{
		
		User user =null;
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		List <User>listOfUsers=new ArrayList <User> ();
		try {
			String hql ="From User  Where userName =:x AND password =:y";
			Query query =sesion.createQuery(hql);
			query.setParameter("x", userName);
			query.setParameter("y", password);
			
			listOfUsers=query.getResultList();
			
		if (listOfUsers.size()!=0) {
			 user =listOfUsers.get(0);
		}else {
			user=null;
		}
			sesion.getTransaction().commit();
			return user;
			
		}catch (Exception e) {
			sesion.getTransaction().rollback();
			return null;
		}
		
	}
}
