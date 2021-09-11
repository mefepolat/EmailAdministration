package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "polat.com";
	
	
	public Email(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		// Call a method asking for department - return department
		this.department = setDepartment();
		
		// Call a method that returns a random password.
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + password);
		
		//Combine elements to generate email.
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
	}
	
	
	private String setDepartment() {
		System.out.print("New worker: " + firstName + "Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None.\nEnter department code: ");
		
		Scanner in = new Scanner(System.in);
		
		int depChoice = in.nextInt();
		
		if (depChoice == 1) { return "Sales"; }
		else if (depChoice == 2) { return "Development"; }
		else if (depChoice == 3) { return "Accounting"; }
		else { return ""; }
			
			
		
	}
	
	private String randomPassword(int length) {
		
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
		
		char[] password = new char[length];
		
		for (int i=0; i<length; i++) {
			
			int randomValue = (int) (Math.random() * passwordSet.length());
			
			password[i] = passwordSet.charAt(randomValue);
			
		}
		
		return new String(password);
		
	}
	
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	
	public String getAlternateEmail() { return alternateEmail; }
	
	public String getPassword() { return password; }
	
	public String showInfo() {
		
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}

}
