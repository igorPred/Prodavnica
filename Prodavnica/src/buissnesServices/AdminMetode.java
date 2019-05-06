package buissnesServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Product;

public class AdminMetode {

	private SessionFactory sf =new Configuration().configure().buildSessionFactory();
	
	
	public boolean ubaciProizvod (String name ,double price,int stock,int quantity,double discount) {
		
		
		Session sesion =sf.openSession();
		sesion.beginTransaction();
		
		Product p= new Product ();
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setQuantity(quantity);
		p.setDiscont(discount);
		try {
			
			sesion.save(p);
			sesion.getTransaction().commit();
			System.out.println("uspesno ubacen proizvod");
			return true;
			
		}catch (Exception e) {
			sesion.getTransaction().rollback();
			return false;
		}finally {
			sesion.close();
		}
		
	}
}
