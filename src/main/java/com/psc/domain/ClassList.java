/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.domain;
import com.psc.enums.Day;
import com.psc.enums.Slot;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */


public class ClassList {
	private List<Class> classList;

	public List<Class> getClassList() {
		return classList;
	}

	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}
	
	public ClassList() {
		this.classList = new ArrayList<>();
	}
	
	public void addClass(int id, Lesson lesson, Day day, Slot slot, int capacity)throws Exception {
		if(day.equals(Day.SATERDAY) && 
				(slot.equals(Slot.TWOTOTHREE) || slot.equals(Slot.THREETOFOUR)) &&
				isSlotAvailable(day, slot)) {
			this.classList.add(new Class(id, lesson, day, slot, capacity));
		}else if((day.equals(Day.MONDAY) || day.equals(Day.WENSDAY) || day.equals(Day.FRIDAY)) &&
				(slot.equals(Slot.FOURTOFIVE) || slot.equals(Slot.FIVETOSIX) || slot.equals(Slot.SIXTOSEVEN) &&
						isSlotAvailable(day, slot))) {
			this.classList.add(new Class(id, lesson, day, slot, capacity));
		}else {
			throw new Exception("Invalid Time slot");
		}
	}
	
	public boolean isSlotAvailable(Day day, Slot slot) {
		for(Class clz : classList) {
			if(clz.getDay().equals(day) && clz.getSlot().equals(slot)) {
				return false;
			}
		}
		return true;
	}
	
	public Class getClassByDayAndTimeSlot(Day day, Slot slot) {
		for(Class clas : classList) {
			if(clas.getDay().equals(day) && clas.getSlot().equals(slot)) {
				return clas;
			}
		}
		return null;
	}
	
	public Class getClassById(int id) {
		for(Class clas : classList) {
			if(clas.getId() == id) {
				return clas;
			}
		}
		return null;
	}
	
	public void printTimeTable() {
		System.out.println(" Time Table");
		System.out.println("=====================================================================================================================");
		System.out.println(" ID  |       LESSON          |     DAY      |          SLOT          |        CAPACITY       |     BOOKED COUNT     |");
		System.out.println("=====================================================================================================================");
		for(Class clz : classList) {
			System.out.println(clz.toString());
			System.out.println("=====================================================================================================================");
		}
	}
}

