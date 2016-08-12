package com.software.employee.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.software.employee.modal.Supplier;

@Repository(value="SupplierDao")
public class SupplierDaoImpl implements SupplierDao{
	private static final String list = null;
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean save(Supplier Supplier)
	{
		try {
			sessionFactory.getCurrentSession().save(Supplier);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		return false;
		}
		
		
	}
	public boolean update(Supplier Supplier)
	{ 
		try {
			sessionFactory.getCurrentSession().update(Supplier);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean delete(Supplier Supplier)
	{
		try {
			sessionFactory.getCurrentSession().delete(Supplier);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public Supplier get(String id)
	{
		String hql = "from Supplier where id = " + " ' " +  id + " ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}

	public List<Supplier> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	

}
