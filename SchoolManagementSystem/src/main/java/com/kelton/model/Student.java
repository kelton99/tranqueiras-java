package com.kelton.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Member {

	private final List<Discipline> disciplines;

	public Student(String name, String registry, String email, Integer age) {
		super(name, registry, email, age);
		this.disciplines = new ArrayList<>();
	}
}
