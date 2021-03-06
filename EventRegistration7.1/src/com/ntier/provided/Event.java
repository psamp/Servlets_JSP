package com.ntier.provided;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Simple event. Event name and dateTime are set when created and cannot be changed.
 * Location and capacity can be changed after creation.
 */
public class Event {
	private final Long id; // read-only
	private final String name; // read-only
	private final Date dateTime; // read-only
	private String location;
	private int capacity;
	private List<User> userList;

	public Event(Long id, String name, Date dateTime, String location, int capacity) {
		this.id = id;
		this.name = name;
		this.dateTime = (Date) dateTime.clone();
		this.setLocation(location);
		this.capacity = capacity; // no validation needed here
		this.userList = new ArrayList<User>(capacity);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	/*
	 * Capacity cannot be less than current number of users.
	 */
	public void setCapacity(int capacity) throws EventException {
		synchronized (userList) {
			int numUsers = this.getUserCount();
			if (capacity < numUsers) {
				throw new EventException("Cannot reduce capacity below #users: " + numUsers);
			} else {
				this.capacity = capacity;
			}
		}
	}

	public List<User> getUsers() {
		synchronized (userList) {
			return new ArrayList<User>(userList);
		}
	}

	public int getUserCount() {
		synchronized (userList) {
			return userList.size();
		}
	}

	public boolean isFull() {
		synchronized (userList) {
			return (this.getUserCount() == capacity);
		}
	}

	/*
	 * Adds the specified User to the Event. If the User is already registered
	 * for the event, or the Event is at capacity, an EventException is thrown.
	 */
	public void register(User u) throws EventException {
		synchronized (userList) {
			if (userList.contains(u)) {
				throw new EventException("User already registered");
			} else if (this.isFull()) {
				throw new EventException("Event full");
			} else {
				userList.add(u);
			}
		}
	}

	/*
	 * Removes the specified User from the Event. If the User is not registered
	 * for this Event, and EventException is thrown.
	 */
	public void unregister(User u) throws EventException {
		synchronized (userList) {
			if (userList.contains(u)) {
				userList.remove(u);
			} else {
				throw new EventException("User not registered");
			}
		}
	}

	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Event) {
			Event other = (Event) obj;
			result = this.getId().equals(other.getId());
		}
		return result;
	}

	/*
	 * Generated by RSA.
	 */
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String toString() {
		return this.getClass().getName() + ":" + " id=" + this.getId() + " name=" + this.getName() + " dateTime="
				+ this.getDateTime() + " location=" + this.getLocation() + " capacity=" + this.getCapacity()
				+ " userCount=" + this.getUserCount();
	}
}