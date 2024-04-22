/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.enums;

/**
 *
 * @author Lenovo
 */
public enum Slot {
	FOURTOFIVE("4 p.m. - 5 p.m."), 
	FIVETOSIX("5 p.m. - 6 p.m."),
	SIXTOSEVEN("6 p.m. - 7 p.m."),
	TWOTOTHREE("2 p.m. - 3 p.m."), 
	THREETOFOUR("3 p.m. - 4 p.m.");
	
	private String desc;
	
	private Slot(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
