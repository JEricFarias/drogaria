package br.org.drogaria.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.LobHelper;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionEventListener;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionBuilder;
import org.hibernate.SimpleNaturalIdLoadAccess;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.hibernate.UnknownProfileException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.stat.SessionStatistics;

import br.org.drogaria.util.HibernateUtil;

public class GenericDAO<E> {
	private Class<E> classe;
	
	// Reflection 
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(E entidade){
		Session session = HibernateUtil.getSf().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(entidade);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			throw e;
		}finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> listar(){
		Session session = HibernateUtil.getSf().openSession();
		try {
			Criteria consulta = session.createCriteria(classe);
			List<E> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		}finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public E buscar(Long id){
		Session session = HibernateUtil.getSf().openSession();
		try {
			Criteria consulta = session.createCriteria(classe);
			consulta.add(Restrictions.idEq(id));
			E result = (E) consulta.uniqueResult();
			return result;
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		} finally{
			session.close();
		}
	}
	
	public void excluir(E entidade){
		Session session = HibernateUtil.getSf().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.delete(entidade);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			throw e;
		}finally {
			session.close();
		}
	}
	
	public void editar(E entidade){
		Session session = HibernateUtil.getSf().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(entidade);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			throw e;
		}finally {
			session.close();
		}
	}
}
