/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;

import com.psc.enums.GradeLevel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */

public class LearnerList {
	private List<Learner> learners;
	private int nextId = 0;
	
	public LearnerList() {
		this.learners = new ArrayList<>();
	}

	public List<Learner> getLearners() {
		return learners;
	}

	public void setLearners(List<Learner> learners) {
		this.learners = learners;
	}
	
	public void addLearner(String name, String gender, String email, int age, 
			String emergencyContact,GradeLevel level) {
		this.learners.add(new Learner(++nextId, name, gender, email, age, emergencyContact, level));
		System.out.println("Learner successfully added");
	}
	
	public Learner getLearnerByEmail(String email) {
		for(Learner learner : learners) {
			if(learner.getEmaill().equalsIgnoreCase(email)) {
				return learner;
			}
		}
		return null;
	}
	
	public void printLearnerList() {
		for(Learner learner : learners) {
			System.out.println(learner.toString());
		}
	}
}
