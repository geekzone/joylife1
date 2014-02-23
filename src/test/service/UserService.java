package test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import test.dao.UserDAO;
import test.model.User;
@Component
public class UserService {
	private UserDAO userDAO = new UserDAO();;

	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void save(User user) {
		System.out.println(user);
		userDAO.save(user);
	}
	
	public List<User> list(){
		return userDAO.listUser();
	}
	
	public boolean exits(String username){
		List<User> users = userDAO.findByUsername(username);
		if(users!=null&&users.size()>0){
			return true;
		}
		return false;
	}
}
