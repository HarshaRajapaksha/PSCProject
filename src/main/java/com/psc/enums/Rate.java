/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psc.enums;

/**
 *
 * @author Lenovo
 */
public enum Rate {
	ZERO(0, "Not Updated"),
	ONE(1, "Very Dissatisfied"),
	TWO(2, "Dissatisfied"),
	THREE(3, "OK"),
	FOUR(4, "Satisfied"),
	FIVE(5, "Very Satisfied");
	
	private Rate(int rate, String description) {
		this.rate = rate;
		this.description = description;
	}
	
	public static Rate getEnumByRate(int rate) {
		for(Rate rates : Rate.values()) {
			if(rates.getRate() == rate) {
				return rates;
			}
		}
		return null;
	}
	
	private int rate;
	private String description;
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
