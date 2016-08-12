package com.software.employee.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.software.employee.modal.Category;

@Repository(value="categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	private static final String list = null;
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean save(Category category)
	{
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		return false;
		}
		
		
	}
	public boolean update(Category category)
	{ 
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean delete(Category category)
	{
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public Category get(String id)
	{
		String hql = "from category where id = " + " ' " +  id + " ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}

	public List<Category> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	

	

}
