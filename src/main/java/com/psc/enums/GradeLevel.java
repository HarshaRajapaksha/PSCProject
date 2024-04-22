/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.enums;

/**
 *
 * @author Lenovo
 */
public enum GradeLevel {
	ONE(1,"Grade 1"), TWO(2, "Grade 2"), THREE(3, "Grade 3"), FOUR(4, "Grade 4"), FIVE(5, "Grade 5");
	
	private int level;
	private String desc;
	
	private GradeLevel(int level,String desc) {
		this.level = level;
		this.desc = desc;
	}

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static GradeLevel getEnumByLevel(int level) {
		for(GradeLevel levels : GradeLevel.values()) {
			if(levels.getLevel() == level) {
				return levels;
			}
		}
		return null;
	}
}