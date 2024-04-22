/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */

public class CoachList {
	private List<Coach> coaches;
	
	public CoachList() {
		this.coaches = new ArrayList<>();
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}
	
	public void addCoach(int id, String name) {
		this.coaches.add(new Coach(id, name));
	}
	
	public Coach getCoachById(int id) {
		for(Coach coach : coaches) {
			if(coach.getId() == id) {
				return coach;
			}
		}
		return null;
	}
	
	public void printCoachList() {
		for(Coach coach : coaches) {
			System.out.println(coach.toString());
		}
	}
}
