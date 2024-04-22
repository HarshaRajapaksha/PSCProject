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

public class Lesson {
	private int id;
	private String lesson;
	private GradeLevel level;
	private Coach coach;
	
	public Lesson(int id, String lesson, GradeLevel level, Coach coach) {
		super();
		this.id = id;
		this.lesson = lesson;
		this.level = level;
		this.coach = coach;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLesson() {
		return lesson;
	}
	public void setLesson(String lesson) {
		this.lesson = lesson;
	}
	public GradeLevel getLevel() {
		return level;
	}
	public void setLevel(GradeLevel level) {
		this.level = level;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ID : ").append(this.id).append(" | ")
				.append("Lesson : ").append(this.lesson).append(" | ")
				.append("Level : ").append(this.level.getDesc()).append(" | ")
				.append("Coach : ").append(this.coach.getName()).toString();
	}
}
