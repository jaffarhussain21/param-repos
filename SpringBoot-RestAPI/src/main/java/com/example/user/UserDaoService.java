package com.example.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> userList = new ArrayList<User>();
	private int counter = userList.size();
	static {
		userList.add(new User(1, "ABC", new Date()));
		userList.add(new User(2, "PQR", new Date()));
		userList.add(new User(3, "XYZ", new Date()));
	}

	public List<User> findAll() {
		return userList;
	}

	public User findOne(int id) {
		for (User u : userList) {
			if (id == u.getId()) {
				return u;
			}
		}
		return null;
	}

	public void save(User user) {
		if (user.getId() == 0) {
			user.setId(++counter);
		}
		userList.add(user);
	}

	public void delete(int id) {
		Iterator<User> itr = userList.iterator();
		while (itr.hasNext()) {
			User u = itr.next();
			if (u.getId() == id)
				itr.remove();
		}
	}
}
