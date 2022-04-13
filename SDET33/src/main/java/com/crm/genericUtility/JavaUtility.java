package com.crm.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists all Java Specific Common Methods
 * @author MOHAN GOWDA
 *
 */
public class JavaUtility {
	
	/**
	 * This method is used to generate Random Numbers
	 * @param limit
	 * @return
	 */
	public static int generateRandomNumber(int limit) {
		Random ran=new Random();
		int randomNumber = ran.nextInt(limit);
		return randomNumber;
	}

	/**
	 * This method is used to get the current date and time in required format
	 * @return
	 */
	public static String getCurrentTimeAndDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date=new Date();
		String requireFormatDate = sdf.format(date);
		return requireFormatDate;
	}
	
	
	/**
	 * This method is used to convert String to Long datatype
	 * @param value
	 * @return
	 */
	public static long convertStringToLong(String value) {
		long data=Long.parseLong(value);
		return data;
	}
	
}
