package com.crm.practice;

import java.util.Random;

public class GenerateRandomNumber {
	public static void main(String[] args) {
		
		//Step1: create object for Random Class
		Random ran=new Random();
		//Step2: generate the random number by calling nextInt() method
		int randomNumber = ran.nextInt(1000);
		System.out.println("Test_"+randomNumber);
		
	}

}
