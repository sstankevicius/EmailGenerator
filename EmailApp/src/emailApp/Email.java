package emailApp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String companySuffix = "blueprint.com";
	
	
	// Constructor to receive first name and last name
	public Email(String firstName, String lastName) {
		
		Scanner in2 = new Scanner(System.in);
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
	}

	
	
	// Ask for the department
	
	private String setDepartment() {
		
		System.out.print("New worker: " + firstName + ". Department Codes:" + "\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoise = in.nextInt();
		if (depChoise == 1) {
			return "sales";
		} 
		else if (depChoise == 2) {
			return "development";
		}
		else if (depChoise == 3) {
			return "acounting";
		} else {
			return "";
		}
	}

	
	
	// Generate random password;

	private String randomPassword(int length) {
		
		String passwordSet = "ABCDEFGHOPRSTUVWXYZ0123456789";
		char[] password = new char[length];
		
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	// Set mailbox capacity
	
	public void setMailCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set alternate email;
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password;
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Getters 
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
