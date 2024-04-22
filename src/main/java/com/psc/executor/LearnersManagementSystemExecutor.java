/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.executor;
import com.psc.domain.ClassList;
import com.psc.domain.CoachList;
import com.psc.domain.LearnerClass;
import com.psc.domain.LearnerClassList;
import com.psc.domain.LearnerList;
import com.psc.domain.LessonList;


import com.psc.enums.Day;
import com.psc.enums.GradeLevel;
import com.psc.enums.Rate;
import com.psc.enums.Slot;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */

public class LearnersManagementSystemExecutor {
	
	public static void main(String[] arg) {
		System.out.println("Wecome to Learner Management System");
		
		CoachList coachList = new CoachList();
		coachList.addCoach(1, "Jone");
		coachList.addCoach(2, "Joy");
		coachList.addCoach(3, "Andason");
		
//		coachList.printCoachList();
		
		LearnerList learners = new LearnerList();
		learners.addLearner("Alex", "Male", "alex@mail.com", 25, "012345678", GradeLevel.ONE);
		learners.addLearner("Mike", "Male", "mike@mail.com", 26, "012345679", GradeLevel.ONE);
		learners.addLearner("micle", "Male", "micle@mail.com", 28, "012345678", GradeLevel.THREE);
		
//		learners.printLearnerList();
		
		LessonList lessons = new LessonList();
		lessons.addLesson(1, "Lesson1", GradeLevel.ONE, coachList.getCoachById(1));
		lessons.addLesson(2, "Lesson2", GradeLevel.ONE, coachList.getCoachById(2));
		lessons.addLesson(3, "Lesson3", GradeLevel.THREE, coachList.getCoachById(3));
		
//		lessons.printLessonList();
		
		ClassList timeTable = new ClassList();
		try {
			timeTable.addClass(1, lessons.getLessonById(1), Day.MONDAY, Slot.FOURTOFIVE, 4);
			timeTable.addClass(2, lessons.getLessonById(2), Day.SATERDAY, Slot.TWOTOTHREE, 4);
			timeTable.addClass(3, lessons.getLessonById(3), Day.WENSDAY, Slot.SIXTOSEVEN, 4);
			
//			timeTable.printTimeTable();
		}catch(Exception e) {
			System.out.println("Time Table Create Exception : "+e.getMessage());
		}
		
		LearnerClassList bookingList = new LearnerClassList();
		try {
			bookingList.bookingClass(learners.getLearnerByEmail("mike@mail.com"), timeTable.getClassByDayAndTimeSlot(Day.MONDAY, Slot.FOURTOFIVE));
			bookingList.bookingClass(learners.getLearnerByEmail("alex@mail.com"), timeTable.getClassByDayAndTimeSlot(Day.SATERDAY, Slot.TWOTOTHREE));
			
//			bookingList.printBookings();
			
//			timeTable.printTimeTable();
			
		}catch(Exception e) {
			System.out.println("Booking Exception : "+e.getMessage());
		}
		System.out.println("Sample Data Create Success....");
		System.out.println("\n");
		System.out.println("Available Choices : ");
		
        System.out.println("1 - View Time Table");
        System.out.println("2 - View Lessons");
        System.out.println("3 - Book  a session");
        System.out.println("4 - Cancel the session");
        System.out.println("5 - Add Learner");
        System.out.println("6 - Review a Lesson");
        System.out.println("7 - Print Report");
        System.out.println("8 - Exit");
        
        boolean isContinue = true;
        
        Scanner scanner = new Scanner(System.in);
        while(isContinue) {
        	System.out.println("Enter Your choice : ");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
            	case 1 :
            		timeTable.printTimeTable();
            		break;
            	case 2 :
            		lessons.printLessonList();
            		break;
            	case 3:
            		 System.out.println("Enter learner email : ");
            		 String email = scanner.next();
            		 System.out.println("Enter  time table ID : ");
            		 int timeTableId = scanner.nextInt();
            		 try {
            			 bookingList.bookingClass(learners.getLearnerByEmail(email), timeTable.getClassById(timeTableId));
            		 }catch(Exception e) {
            				System.out.println("Booking failed due to : "+e.getMessage());
            		 }
            		break;
            	case 4:
            		System.out.println("Enter booking ID : ");
            		int bookingId = scanner.nextInt();
            		LearnerClass booking = bookingList.getBookingById(bookingId);
            		if(booking != null) {
            			booking.cancelBooking();
            		}else {
            			System.out.println("Booking not found");
            		}
            		break;
            	case 5:
            		System.out.println("Enter Student Name : ");
            		String name = scanner.next();
            		System.out.println("Enter Gender : ");
            		String gender = scanner.next();
            		System.out.println("Enter Email : ");
            		String stuEmail = scanner.next();
            		System.out.println("Enter Age : ");
            		int age = scanner.nextInt();
            		System.out.println("Enter emergency contact : ");
            		String contact = scanner.next();
            		System.out.println("Enter Grade : ");
            		int grade = scanner.nextInt();
            		learners.addLearner(name, gender, stuEmail, age, contact, GradeLevel.getEnumByLevel(grade));
            		break;
            	case 6:
            		System.out.println("Enter booking ID : ");
            		int reviewBookingId = scanner.nextInt();
            		System.out.println("Enter Rate (1 - 5): ");
            		int rate = scanner.nextInt();
            		try {
            			bookingList.updateRate(reviewBookingId, Rate.getEnumByRate(rate));
            		}catch(Exception e) {
            			System.out.println("Review failed due to : "+e.getMessage());
            		}
            		break;
            	case 7:
            		System.out.println("Available Reports");
            		System.out.println("1. Rating Report");
            		System.out.println("2. Booking Details");
            		System.out.println("Enter your report ID : ");
            		int reportId = scanner.nextInt();
            		switch(reportId) {
            		case 1:
            			bookingList.printRateReport();
            			break;
            		case 2:
            			bookingList.printBookings();
            			break;
            		}
            		break;
            	case 8:
            		isContinue = false;
            		break;
            		
            }
        }
        
	}
}
