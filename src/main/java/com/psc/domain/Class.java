/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;

import com.psc.enums.Day;
import com.psc.enums.Slot;

/**
 *
 * @author Lenovo
 */

public class Class {
	private int id;
	private Lesson lesson;
	private Day day;
	private Slot slot;
	private int capacity;
	private int count;
	
	public Class(int id, Lesson lesson, Day day, Slot slot, int capacity) {
		super();
		this.id = id;
		this.lesson = lesson;
		this.day = day;
		this.slot = slot;
		this.capacity = capacity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getCount() {
		return count;
	}
	
	public void countUp() {
		this.count++;
	}
	
	public void countDown() {
		this.count--;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(this.id).append("    |    ")
				.append(this.lesson.getLesson()).append("            | ")
				.append(this.day.name()).append("       | ")
				.append(this.slot.getDesc()).append("         |        ")
				.append(this.capacity).append("             |        ")
				.append(this.count).append("             | ").toString();
	}
}

