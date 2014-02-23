package test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import test.model.User;

@Component
public class UserDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(User user) {
		hibernateTemplate.save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByUsername(String username) {
		 return
		 (List<User>)hibernateTemplate.find("from User u where u.username = ?",username);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUser(){
		return hibernateTemplate.find("from User u");
	}
}
