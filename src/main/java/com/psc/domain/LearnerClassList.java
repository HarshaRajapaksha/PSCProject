/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;


import com.psc.enums.Rate;
import com.psc.enums.Status;
import com.psc.enums.GradeLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Lenovo
 */

public class LearnerClassList {
	private List<LearnerClass> learnerClassList;
	private int nextId = 0;

	public List<LearnerClass> getLearnerClassList() {
		return learnerClassList;
	}
	
	public LearnerClassList() {
		this.learnerClassList = new ArrayList<>();
	}

	public void setLearnerClassList(List<LearnerClass> learnerClassList) {
		this.learnerClassList = learnerClassList;
	}
	
	public void bookingClass(Learner learner, Class claz)throws Exception {
		if(this.learnerClassList == null) {
			this.learnerClassList = new ArrayList<>();
		}
		if(learner == null) {
			throw new Exception("Learner Not Found");
		}
		if(claz == null) {
			throw new Exception("Class Not Found");
		}
		if(isBooked(learner, claz)) {
			throw new Exception("Already booked.");
		}
		if(learner.getLevel().getLevel() == claz.getLesson().getLevel().getLevel() || 
				(learner.getLevel().getLevel()+1) == claz.getLesson().getLevel().getLevel()) {
			if(claz.getCount() < claz.getCapacity()) {
				this.learnerClassList.add(new LearnerClass(++nextId, learner, claz, Rate.ZERO, Status.BOOKED));
				System.out.println("Booking Success. Your Booking ID is "+nextId);
			}else {
				throw new Exception("No space available");
			}
		}else {
			throw new Exception("Grade level not allowed");
		}
	}
	
	public boolean isBooked(Learner learner, Class claz) {
		for(LearnerClass learnerClass : learnerClassList) {
			if(learnerClass.getClaz().equals(claz) && learnerClass.getLearner().equals(learner)) {
				return true;
			}
		}
		return false;
	}
	
	public List<LearnerClass> getBookedByLearner(String email){
		List<LearnerClass> bookingList = new ArrayList<>();
		for(LearnerClass learnerClass : learnerClassList) {
			if(learnerClass.getLearner().getEmaill().equalsIgnoreCase(email) && learnerClass.getStatus() == Status.BOOKED) {
				bookingList.add(learnerClass);
			}
		}
		return bookingList;
	}
	
	public LearnerClass getBookingById(int id){
		for(LearnerClass learnerClass : learnerClassList) {
			if(learnerClass.getId() == id) {
				return learnerClass;
			}
		}
		return null;
	}

	
	public void updateAsAttended(int id) {
		for(LearnerClass claz : learnerClassList) {
			if(id == claz.getId()) {
				claz.setStatus(Status.ATTENDED);
				if((claz.getLearner().getLevel().getLevel()+1) == claz.getClaz().getLesson().getLevel().getLevel()) {
					claz.getLearner().setLevel(GradeLevel.getEnumByLevel(claz.getLearner().getLevel().getLevel()+1));
				}
			}
		}
	}
	
	public void updateRate(int id, Rate rate)throws Exception {
		if(rate == null) {
			throw new Exception("Rate not found");
		}
		for(LearnerClass claz : learnerClassList) {
			if(id == claz.getId()) {
				claz.setRate(rate);
				System.out.println("Rate update success.");
			}
		}                                                                                                             
	}
	
	public void printBookings() {
		System.out.println(" Booking List ");
		System.out.println(" ==============================================");
		for(LearnerClass claz : learnerClassList) {
			System.out.println(claz.toString());
		}
	}
	
	public void printRateReport() {
		System.out.println(" Coach Rating report ");
		System.out.println("====================================================================");
		Map<Class, List<LearnerClass>> groupList = learnerClassList.stream().collect(Collectors.groupingBy(LearnerClass :: getClaz));
		for(Class claz : groupList.keySet()) {
			List<LearnerClass> list = groupList.get(claz);
			Map<Rate, List<LearnerClass>> rateList = list.stream().collect(Collectors.groupingBy(LearnerClass :: getRate));
//			claz.getLesson().getCoach().getName();
//			claz.getLesson().getLesson();
			int veryDissatisfiedCount = rateList.get(Rate.ONE) != null ? rateList.get(Rate.ONE).size() : 0;
			int dissatisfiedCount = rateList.get(Rate.TWO) != null ? rateList.get(Rate.TWO).size() : 0;
			int okCount = rateList.get(Rate.THREE) != null ? rateList.get(Rate.THREE).size() : 0;
			int satisfiedCount = rateList.get(Rate.FOUR) != null ? rateList.get(Rate.FOUR).size() : 0;
			int verySatisfied = rateList.get(Rate.FIVE) != null ? rateList.get(Rate.FIVE).size() : 0;
			System.out.println(new StringBuffer().append("COACH : ").append(claz.getLesson().getCoach().getName()).append(" | ")
					.append("Lesson : ").append(claz.getLesson().getLesson()).append(" | ")
					.append("Very Dissatisfied : ").append(veryDissatisfiedCount).append(" | ")
					.append("Dissatisfied : ").append(dissatisfiedCount).append(" | ")
					.append("OK : ").append(okCount).append(" | ")
					.append("Satisfied : ").append(satisfiedCount).append(" | ")
					.append("Very Satisfied : ").append(verySatisfied).toString());
		}
	}
	
}

