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
public class LessonList {
	private List<Lesson> lessons;
	
	public LessonList() {
		this.lessons = new ArrayList<>();
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	public void addLesson(int id, String lesson, GradeLevel level, Coach coach) {
		this.lessons.add(new Lesson(id, lesson, level, coach));
	}
	
	public Lesson getLessonById(int id) {
		for(Lesson lesson : lessons) {
			if(lesson.getId() == id) {
				return lesson;
			}
		}
		return null;
	}
	
	public void printLessonList() {
		System.out.println("========================= Lessons ===========================");
		for(Lesson lesson : lessons) {
			System.out.println(lesson.toString());
		}
	}
}
