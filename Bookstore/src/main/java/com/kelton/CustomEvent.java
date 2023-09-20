package com.kelton;

import javafx.event.Event;
import javafx.event.EventType;

public class CustomEvent extends Event {

	public static final EventType<CustomEvent> loginSuccessful = new EventType<>("loginSuccessful");

	public CustomEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
}
