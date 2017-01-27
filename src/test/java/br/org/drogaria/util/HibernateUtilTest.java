package br.org.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void conectar(){
		Session session = HibernateUtil.getSf().openSession();
		session.close();
		HibernateUtil.getSf().close();
	}
}
