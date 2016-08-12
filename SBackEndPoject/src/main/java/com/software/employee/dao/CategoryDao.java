package com.software.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.software.employee.modal.Category;



@Repository
public interface CategoryDao {

	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public Category get(String id);
	public List<Category>  list();
}
