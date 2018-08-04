package test;

//Tests whether phone number is reformatted after entry, sends email on success
//Created by Jesse Penber 8-3-2018

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhoneFormatTest {

	public static void main(String[] args) throws EmailException {
	//Opens Uber form page in Chrome
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpenber\\Downloads\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://auth.uber.com/login/?uber_client_name=riderSignUp");
	
	//Enters phone number and checks that it's reformatted to ###-###-####, sends an email if so
	driver.findElement(By.cssSelector("#mobile")).sendKeys("2222222222");
	String enteredNumber = driver.findElement(By.cssSelector("#mobile")).getAttribute("value");
	System.out.println(enteredNumber);
	String expectedNumber = "222-222-2222";
	
	if(enteredNumber!=expectedNumber) {
		sendEmail();
	} else {
		System.out.println("Failed");
	}
	}
		
	public static void sendEmail() throws EmailException {
	Email email = new SimpleEmail();
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("sampleemail@gmail.com", "Password12!"));
	email.setSSLOnConnect(true);
	email.setFrom("thisismyuser@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("Test succeeded");
	email.addTo("penberelf50@gmail.com");
	email.send();
	}
	}