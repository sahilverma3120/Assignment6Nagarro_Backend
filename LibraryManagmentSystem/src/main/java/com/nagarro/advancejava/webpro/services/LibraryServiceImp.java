package com.nagarro.advancejava.webpro.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import com.nagarro.advancejava.webpro.dao.LibraryDao;
import com.nagarro.advancejava.webpro.entity.Library;
import com.nagarro.advancejava.webpro.entity.LoginManager;

@Service
public class LibraryServiceImp  {
	@Autowired
	private LibraryDao librarydao;
	@Autowired
	EntityManager entityManager;
	/***
	 * 
	 * @return all employees
	 */
	public List<Library> getEmployees() {
		
		List<Library> list = (List<Library>) this.librarydao.findAll();
		return list;
	}

	/***
	 * 
	 * @param code
	 * @return single employee
	 */
	
	public Library getEmployee(int code) {
		
		Library library = null;
		try {
			library = librarydao.getOne(code);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return library;
	}

	/***
	 * 
	 * @param emp
	 * @return add new employee
	 */
	public Library addEmployee(Library emp) {
		
		librarydao.save(emp);
		return emp;
	}

	/***
	 * 
	 * @param emp
	 * @return update  employee
	 */
	public Library updateEmployee(Library emp) {
		
		librarydao.save(emp);
		return emp;
	}

	/***
	 * 
	 * @param code
	 * delete employee
	 */
	@Transactional
	public void delete(int code) {
		
//		librarydao.deleteById(code);
		Library u = librarydao.getOne(code);
		librarydao.delete(u);
	}
	/***
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public LoginManager validateUser(String userId, String password) {

		
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(LoginManager.class);
		criteria.add(Restrictions.eq("name", userId));
		criteria.add(Restrictions.eq("password", password));
		try {
			return (LoginManager) criteria.list().get(0);
		} catch (Exception e) {
			return null;
		}
		

	}
	

}
