package org.opencart.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {
	
	
	public static String randomString() {
		String generatedRandomString =  RandomStringUtils.secure().nextAlphabetic(7);
		return generatedRandomString;
	}
	
	public static String randomNumber() {
		String generatedRandomNumber =  RandomStringUtils.secure().nextNumeric(10);
		return generatedRandomNumber;
	}
	
	public static String randomEmail() {
		String generatedRandomNumber = RandomStringUtils.secure().nextNumeric(5);
		return ("user" + generatedRandomNumber + "@gmail.com");
	}
	
	public static String randomPassword() {
		String generatedRandomString = RandomStringUtils.secure().nextAlphabetic(7);
		String generatedRandomNumber = RandomStringUtils.secure().nextNumeric(4);
		return (generatedRandomString + "@" + generatedRandomNumber);
	}
	
	

}
