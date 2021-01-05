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
	private String companySuffix = "javacompany.com";
	
	// Receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// Method for asking department
		this.department = setDepartment();

		
		//Method for random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
	}
	
	// Random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Department
	private String setDepartment() {
		System.out.print("New Worker: " + firstName + ". Department Code:\n1 Sales\n2 Development\n3 Accounting\n0 None\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if (departmentChoice == 1 ) { 
			return "Sales";
		} else if (departmentChoice == 2 ) {
			return "Development";
		} else if (departmentChoice == 3) { 
			return "Accounting";
		} else {
			return "";
		}
		
	}
	
	// Mailbox capacity
	public void setMailboxCapacity(int capacity) { 
		this.mailboxCapacity = capacity;
	}
	
	// Alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
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
		return "\nDisplay Name: " + firstName + " " + lastName +
				"\nCompany Email: " + email + 
				"\nMailbox Capacity: " + mailboxCapacity + "nb";
	}
				
}
