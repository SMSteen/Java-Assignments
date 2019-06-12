package com.teamroster.models;

public class Player {
	private String firstName;
	private String lastName;
	private int age;

	public Player(String first, String last, int age) {
		this.setFirstName(first);
		this.setLastName(last);
		this.setAge(age);

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
