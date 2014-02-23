package test.action;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import test.model.User;
import test.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User user;
	private List<User> userList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String addUser() {
		Logger.getAnonymousLogger().info("add action");
		if (userService.exits(user.getUsername())) {
			return ERROR;
		}
		userService.save(user);
		return SUCCESS;
	}

	public String listUser() {
		Logger.getAnonymousLogger().info("list action");
		this.userList = userService.list();
		return "list";
	}

}
