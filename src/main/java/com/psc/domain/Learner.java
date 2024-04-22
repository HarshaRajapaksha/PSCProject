/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;

import com.psc.enums.GradeLevel;

/**
 *
 * @author Lenovo
 */

public class Learner {
	private int id;
	private String name;
    private String gender;
    private String emaill;
    private int age;
    private String emergencyContact;
    private GradeLevel level;

	public Learner(int id, String name, String gender, String emaill, int age, String emergencyContact, GradeLevel level) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.emaill = emaill;
		this.age = age;
		this.emergencyContact = emergencyContact;
		this.level = level;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmaill() {
		return emaill;
	}
	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public GradeLevel getLevel() {
		return level;
	}

	public void setLevel(GradeLevel level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return new StringBuffer().append("ID : ").append(this.id).append(" | ")
				.append("Name : ").append(this.name).append(" | ")
				.append("email : ").append(this.emaill).toString();
	}
}