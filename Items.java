// -------------------------------------------------------
	// Assignment 1
	// Question: Items class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Friday, 1st March 2024
	
	/*
	 * This class serves as a superclass for various library items, including books, journals, and media. 
	 * It provides common attributes and methods shared among different types of library items.
	 */
// -------------------------------------------------------

package library;

public class Items {
	
	// Variables that stores item information
	protected String id;
	protected String name;
	protected String author;
	protected int publish_year;
	
	// Static variable that will store unique IDs for every item
	public static int genID;
	
	// Default constructor that initializes item information to default value
	public Items() {
	}
	
	// Custom constructor that initializes item attributes to a specific value
	public Items(String name, String author, int publish_year) {
		this.id = Integer.toString(++genID);
		this.name = name;
		this.author = author;
		this.publish_year = publish_year;
	}
	
	// Copy constructor to create a copy of an existing item
	public Items(Items other) {
		this.name = other.name;
		this.author = other.author;
		this.publish_year = other.publish_year;
		//Generate a unique ID for the copied item
		this.id = Integer.toString(++genID);
	}
	
	// Accessors for each item information
	public String getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public int getPublishYear() {
		return this.publish_year;
	}
	
	//Mutators for each item information
	public void setID(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPublishYear(int publish_year) {
		this.publish_year = publish_year;
	}
	
	//Method that shows the item information in a string format
	public String toString() {
		return "ID: "+id+"\nName: "+name+"\nAuthor: "+author+"\nYear of Publication: "+publish_year;
	}
	
	// Method to check equality between two items
	public boolean equals(Items obj) {
		
		// Checks if the provided object is null or of a different class
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		// Checks if the information of the two items are equal
		return this.name == obj.name && this.author == obj.author && this.publish_year == obj.publish_year;
	}
}