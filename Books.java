// -------------------------------------------------------
	// Assignment 1
	// Question: Books class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Friday, 1st March 2024
	
	/*
	 * This class represents a book in the library. 
	 * It includes attributes such as title, author, publication year, and number of pages. 
	 * The class provides methods to create, manipulate, and display book objects.
	 */
// -------------------------------------------------------

package library;

// Books class is now a subclass to Items class
public class Books extends Items {
	
	// Variables that stores the number of pages of the book and unique ID for the book, respectively
	private int num_pages;
	public static int genID;
	
	// Default constructor that calls the superclass default constructor
	public Books() {
		super();
	}
	
	// Custom constructor that calls the superclass custom constructor, 
	// as well as initializes the number of pages and IDs of the book to a specific value
	public Books(String name, String author, int publish_year, int num_pages) {
		super(name, author, publish_year);
		this.num_pages = num_pages;
		this.id = "B"+ ++genID;
	}
	
	// Copy constructor that calls superclass copy constructor, 
	// as well as generates a unique ID for the copied book and creates a copy of the number of pages in the existing book.
	public Books(Books other) {
		super(other);
		this.id = "B"+ ++genID;
		this.num_pages = other.num_pages;
	}
	
	// Accesor for the number of pages of the book
	public int getNumPages() {
		return this.num_pages;
	}
	
	// Mutator for the number of pages of the book
	public void setNumPages(int num_pages) {
		this.num_pages = num_pages;
	}
	
	// Method that shows the book information in a string format, overriding the method of the superclass
	@Override
	public String toString() {
		
			return "ID: "+this.id+"\nName: "+this.name+"\nAuthor: "+this.author+"\nYear of Publication: "+this.publish_year+"\nNumber of Pages: "+this.num_pages;
		}
	
	// Method to check equality between two books
	public boolean equals(Books obj) {
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return this.name == obj.name && this.author == obj.author && this.publish_year == obj.publish_year && this.num_pages == obj.num_pages;
	}

}