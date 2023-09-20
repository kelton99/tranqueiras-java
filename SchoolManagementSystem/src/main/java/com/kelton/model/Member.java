package com.kelton.model;

public abstract class Member {

	private final String name;
	private final String registry;
	private final String email;
	private final Integer age;

	public Member(String name, String registry, String email, Integer age) {
		this.name = name;
		this.registry = registry;
		this.email = email;
		this.age = age;
	}
}
