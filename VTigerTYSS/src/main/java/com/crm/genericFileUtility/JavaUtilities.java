package com.crm.genericFileUtility;

import java.util.Date;
import java.util.Random;

/**
 * @author Kiruthik Pranav
 */

public class JavaUtilities {
	
	/**
	 * This getRandomNUmber Method will return randomly generated Number 
	 * within some range of value
	 * ex. if it is nextInt(1000) then number generated within 1000 like 44,484,999 but not more than 1000
	 * @return int 
	 */
	public int getRandomNumber(int generateWithin) {
		Random randomNumber =  new Random();
		//int num = randomNumber.nextInt(); output : etc,. 12334, 333331343413, 44,22222222432
		int num = randomNumber.nextInt(generateWithin); //generate 
		return num;
	}
	
	/**
	 * This getSystemDate method will return full data and time. output : Wed Nov 24 13:14:48 IST 2021
	 * There is a many Method available in Date class ex.getDay, getHours, setDate, setDay ,etc,..
	 * @return date  
	 */
	public String getSystemDate() {
		Date date = new Date();
		String s = date.toString().replace(" ", "_").replace(":", "_");
		//date.setDate(2);
		//int n = date.getDate();
		return s;
	}	
}
