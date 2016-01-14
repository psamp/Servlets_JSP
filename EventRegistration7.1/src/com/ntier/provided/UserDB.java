package com.ntier.provided;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class UserDB {
	// key is User.username, value is User itself
	private Map<String, User> users = new HashMap<String, User>();
	private static final UserDB INSTANCE = new UserDB();

	private UserDB() {
		if (INSTANCE != null) {
			throw new IllegalStateException("Already instantiated");
		}
	}

	{
		loadUsers();
	}

	// use this method to get an instance of the Database
	public static UserDB getInstance() {
		return INSTANCE;
	}

	public User getUser(String username) {
		synchronized (users) {
			return users.get(username);
		}
	}

	public Collection<User> getAllUsers() {
		synchronized (users) {
			return new ArrayList<User>(users.values());
		}
	}

	public void addUser(User u) {
		synchronized (users) {
			users.put(u.getUsername(), u);
		}
	}

	public void removeUser(String username) {
		synchronized (users) {
			users.remove(username);
		}
	}

	public boolean containsUser(String username) {
		synchronized (users) {
			return users.containsKey(username);
		}
	}

	private void loadUsers() {
		addUser(new User("jason", "ross", "jr@northwest.net"));
		addUser(new User("edwin", "lancelot", "sir.lancelot@atlanta.org"));
		addUser(new User("eric", "parsnip", "eatveggies@gardening.com"));
		// administrator
		addUser(new User("student", "student", "justastudent@ntiertraining.edu", true));
	}
}