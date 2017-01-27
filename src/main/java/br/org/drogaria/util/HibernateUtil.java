package br.org.drogaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sf = createSession();
	
	public static SessionFactory getSf() {
		return sf;
	}
	
	private static SessionFactory createSession(){
		try {
			//busca o arquivo de configuração do hibernate(hibernate.cfg.xml)
			Configuration cfg = new Configuration().configure();
			
			//Registar o serviço
			//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			
			SessionFactory fabrica = cfg.buildSessionFactory();
			return fabrica;
		} catch (Exception e) {
			System.err.println("Erro na criação da cessão " + e);
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
}
