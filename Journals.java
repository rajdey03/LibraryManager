// -------------------------------------------------------
	// Assignment 1
	// Question: Journals class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Friday, 1st March 2024
	
	/*
	 * The Journals class represents a journal in the library. 
	 * It contains attributes specific to journals such as title, author, publication year, and number of issues. 
	 * Methods are provided to create, manipulate, and display journal objects.
	 */
// -------------------------------------------------------

package library;

public class Journals extends Items {
	
	// Variables that stores the volume number of the journal and a unique ID for the journal, respectively
	private int num_volume;
	public static int genID;
	
	// Default constructor that calls the superclass default constructor
	public Journals() {
		super();
	}
	
	// Custom constructor that calls the superclass custom constructor, 
	// as well as initializes the volume number and IDs of the journal to a specific value
	public Journals(String name, String author, int publish_year, int num_volume) {
		super(name, author, publish_year);
		this.id = "J"+ ++genID;
		this.num_volume = num_volume;
	}
	
	// Copy constructor that calls superclass copy constructor, 
	// as well as generates a unique ID for the copied journal and creates a copy of the volume number in the existing journal
	public Journals(Journals other) {
		super(other);
		this.id = "J"+ ++genID;
		this.num_volume = other.num_volume;
	}
	
	// Accesor for the volume number of the journal
	public int getNumVolume() {
		return this.num_volume;
	}
	
	// Mutator for volume number of the journal
	public void setNumVolume(int num_volume) {
		this.num_volume = num_volume;
	}
	
	// Method that shows the journal information in a string format, overriding the method of the superclass
	@Override
	public String toString() {
		
			return "ID: "+this.id+"\nName: "+this.name+"\nAuthor: "+this.author+"\nYear of Publication: "+this.publish_year+"\nVolume Number: "+this.num_volume;
		}
	
	// Method to check equality between two journals
	public boolean equals(Journals obj) {
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return this.name == obj.name && this.author == obj.author && this.publish_year == obj.publish_year && this.num_volume == obj.num_volume;
	}
	

}