/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;

import com.psc.enums.Rate;
import com.psc.enums.Status;

/**
 *
 * @author Lenovo
 */
public class LearnerClass {
	private int id;
	private Learner learner;
	private Class claz;
	private Rate rate;
	private Status status;
	
	public LearnerClass(int id, Learner learner, Class claz, Rate rate, Status status) {
		super();
		this.id = id;
		this.learner = learner;
		this.claz = claz;
		this.rate = rate;
		this.status = status;
		claz.countUp();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Learner getLearner() {
		return learner;
	}
	public void setLearner(Learner learner) {
		this.learner = learner;
	}
	public Class getClaz() {
		return claz;
	}
	public void setClaz(Class claz) {
		this.claz = claz;
	}
	public Rate getRate() {
		return rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void cancelBooking() {
		this.status = Status.CANCELLED;
		this.claz.countDown();
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ID : ").append(this.id).append(" | ")
				.append("Learner : ").append(this.learner.getName()).append(" | ")
				.append("Lesson : ").append(this.claz.getLesson().getLesson()).append(" | ")
				.append("Day  : ").append(this.claz.getDay().name()).append(" | ")
				.append("Time  : ").append(this.claz.getSlot().getDesc()).append(" | ")
				.append("Rate  : ").append(this.rate != null ? this.rate.name() : 0).append(" | ")
				.append("Status  : ").append(this.status.name()).toString();
	}
}
