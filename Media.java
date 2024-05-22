// -------------------------------------------------------
	// Assignment 1
	// Question: Media class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Friday, 1st March 2024
	
	/*
	 * The Media class represents media items in the library. 
	 * It includes attributes like title, author, publication year, and media type. 
	 * Methods are available to create, manipulate, and display media objects.
	 */
// -------------------------------------------------------

package library;

public class Media extends Items{
	
	// Variables that stores the media type and a unique ID for the media item, respectively
	private String media_type;
	public static int genID;
	
	// Default constructor that calls the superclass default constructor
	public Media() {
		super();
	}
	
	// Custom constructor that calls the superclass custom constructor, 
		// as well as initializes the media type and IDs of the media item to a specific value
	public Media(String name, String author, int publish_year, String media_type) {
		super(name, author, publish_year);
		this.id = "M"+ ++genID;
		this.media_type = media_type;
	}
	
	// Copy constructor that calls superclass copy constructor, 
	// as well as generates a unique ID for the copied media item and creates a copy of the media type in the existing media item
	public Media(Media other) {
		super(other);
		this.id = "M"+ ++genID;
		this.media_type = other.media_type;
	}
	
	// Accesor for the volume number of the media item
	public String getType() {
		return this.media_type;
	}
	
	// Mutator for volume number of the media item
	public void setType(String media_type) {
		this.media_type = media_type;
	}
	
	// Method that shows the media item information in a string format, overriding the method of the superclass
	@Override
	public String toString() {
		
			return "ID: "+this.id+"\nName: "+this.name+"\nAuthor: "+this.author+"\nYear of Publication: "+this.publish_year+"\nType: "+this.media_type;
		}
	
	// Method to check equality between two media items
	public boolean equals(Media obj) {
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return this.name == obj.name && this.author == obj.author && this.publish_year == obj.publish_year && this.media_type == obj.media_type;
	}

}