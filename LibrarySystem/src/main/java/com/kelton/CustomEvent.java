package com.kelton;

import javafx.event.Event;
import javafx.event.EventType;

public class CustomEvent extends Event {

	public static final EventType<CustomEvent> goToCreateScene = new EventType<>("goToCreateScene");
	public static final EventType<CustomEvent> goToOverviewScene = new EventType<>("goToOverviewScene");
	public CustomEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}

}