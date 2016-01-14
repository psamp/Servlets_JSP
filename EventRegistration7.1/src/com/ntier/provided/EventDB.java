package com.ntier.provided;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class EventDB {
	// key is Event.id, value is Event itself
	private Map<Long, Event> events = new TreeMap<Long, Event>();
	private static final EventDB INSTANCE = new EventDB();

	private EventDB() {
		if (INSTANCE != null) {
			throw new IllegalStateException("Already instantiated");
		}
	}

	{
		loadEvents();
	}

	// use this method to get an instance of the Database
	public static EventDB getInstance() {
		return INSTANCE;
	}

	public Event getEvent(Long id) {
		synchronized (events) {
			return events.get(id);
		}
	}

	public Collection<Event> getAllEvents() {
		synchronized (events) {
			return new ArrayList<Event>(events.values());
		}
	}

	public void addEvent(Event evt) {
		synchronized (events) {
			events.put(evt.getId(), evt);
		}
	}

	public void removeEvent(Long id) {
		synchronized (events) {
			events.remove(id);
		}
	}

	/*
	 * Returns all Events for which the User is registered. Uses brute force,
	 * since we don't have real DB query facilities.
	 */
	public Collection<Event> getEventsForUser(User u) {
		// return value
		Collection<Event> results = new ArrayList<Event>();

		// get all Events; for each one, get its users and look for this one
		Collection<Event> allEvents = getAllEvents();
		for (Event evt : allEvents) {
			if (evt.getUsers().contains(u)) {
				results.add(evt);
			}
		}
		return results;
	}

	private void loadEvents() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 5);
		cal.set(Calendar.HOUR_OF_DAY, 19);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date d = cal.getTime();
		addEvent(new Event(1L, "Jones Reception", d, "Linen Building Ballroom", 1));

		cal.set(Calendar.HOUR_OF_DAY, 20);
		d = cal.getTime();
		addEvent(new Event(2L, "Smith Reunion", d, "Hyatt Rainier Room", 2));

		cal.add(Calendar.DAY_OF_MONTH, 1);
		d = cal.getTime();
		addEvent(new Event(3L, "Emerson Party", d, "Grove Hotel Sawtooth Room", 3));

		cal.add(Calendar.DAY_OF_MONTH, 1);
		d = cal.getTime();
		addEvent(new Event(4L, "Bill and Ted's Award Show", d, "Linen Building Ballroom", 5));

		cal.add(Calendar.DAY_OF_MONTH, 2);
		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.MINUTE, 30);
		d = cal.getTime();
		addEvent(new Event(5L, "Parker Dinner", d, "Linen Building Ballroom", 5));

		cal.set(Calendar.HOUR_OF_DAY, 20);
		d = cal.getTime();
		addEvent(new Event(6L, "City Prom", d, "Sheraton Grand Ballroom", 10));

		addEvent(new Event(7L, "Mason Company Meeting", d, "Grove Hotel Pioneer Room", 10));

		addEvent(new Event(8L, "Coleman Reunion", d, "Grove Hotel Sawtooth Room", 20));

		cal.add(Calendar.DAY_OF_MONTH, 1);
		d = cal.getTime();
		addEvent(new Event(9L, "Rubble Company Job Fair", d, "Sheraton Grand Ballroom", 20));
	}
}