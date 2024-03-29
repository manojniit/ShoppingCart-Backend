package com.software.employee.dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.software.employee.modal.UserDetails;

@Repository(value="UserDetailsDao")
public class UserDetailsDaoImpl implements UserDetailsDao{
	private static final String list = null;
	@Autowired
	private SessionFactory sessionFactory;
	public UserDetailsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean save(UserDetails userDetails)
	{
		try {
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		return false;
		}
		
		
	}
	public boolean update(UserDetails userDetails)
	{ 
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean delete(UserDetails userDetails)
	{
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public UserDetails get(String id)
	{
		String hql = "from UserDetails where id = " + " ' " +  id + " ' ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		if(list == null)
	    {
	    	return null;
	    }
		else
	    {
	    	return list.get(0);
	    }
		
	
	
	}

	public List<UserDetails> list() {
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	

}
