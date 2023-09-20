package com.kelton;

import javafx.event.Event;
import javafx.event.EventType;

public class CustomEvent extends Event {

	public static final EventType<CustomEvent> goToStudents = new EventType<>("goToStudents");
	public static final EventType<CustomEvent> goToStudentPanel = new EventType<>("goToStudentPanel");
	public static final EventType<CustomEvent> goToDisciplines = new EventType<>("goToCreateScene");
	public static final EventType<CustomEvent> goToMain = new EventType<>("goToMain");

	public CustomEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
}
