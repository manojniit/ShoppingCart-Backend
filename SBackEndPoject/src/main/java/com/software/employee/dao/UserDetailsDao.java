package com.software.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.software.employee.modal.UserDetails;



@Repository
public interface UserDetailsDao {

	public boolean save(UserDetails userDetails);
	public boolean update(UserDetails userDetails);
	public boolean delete(UserDetails userDetails);
	public UserDetails get(String id);
	public List<UserDetails>  list();
}
