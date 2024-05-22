// -------------------------------------------------------
	// Assignment 1
	// Question: Client class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Friday, 1st March 2024
	
	/*
	 * The Client class represents a client in the library. 
	 * It includes attributes such as name, contact number, and email address. 
	 * Methods are provided to create, edit, and display client information,
	 * as well as add and remove a leased item from a client.
	 */
// -------------------------------------------------------

package clients;
import library.Items;

public class Client {
	
	// Variables that stores client information and stores the number of leased items, and an array that will contain all the leased item
	private String id;
	private String name;
	private long phone_number;
	private String email;
	private Items[] leasedItems;
	private int leasedCount;
	
	// Static variable that will store unique IDs for every client
	public static int genID;
	
	// Default constructor that initializes client information to default value
	public Client() {
	}
	
	// Custom constructor that initializes client attributes to a specific value
	public Client(String name, long phone_number, String email) {
		this.id = Integer.toString(++genID);
		this.name = name;
		this.phone_number = phone_number;
		this.email = email;
	}
	
	// Copy constructor to create a copy of an existing client
	public Client(Client other) {
		this.name = other.name;
		this.phone_number = other.phone_number;
		this.email = other.email;
		//Generate a unique ID for the copied client
		this.id = Integer.toString(++genID);
	}
	
	// Accessors for each client information
	public String getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getPhoneNumber() {
		return this.phone_number;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//Mutators for each client information
	public void setID(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(long phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Method that shows the client information in a string format
	public String toString() {
		return "ID: "+this.id+"\nName: "+this.name+"\nPhone Number: "+this.phone_number+"\nEmail Address: "+this.email;
	}
	
	// Method to check equality between two clients
	public boolean equals(Client obj) { 
		
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		return this.name == obj.name && this.phone_number == obj.phone_number && this.email == obj.email;
	}
	
	// Accessor for the leased items array
	public Items[] getLeased() {
		return leasedItems;
	}
	
	// Method to add a leased item to the client
	public void addLeasedItem(Items item) {
		Items[] temporaryArray = new Items[leasedCount+1];
		for (int j = 0; j < leasedCount; j++) {
			// Copy existing leased items to the temporary array
			temporaryArray[j] = leasedItems[j];
		}
		// Add the new leased item to the end of the temporary array
		temporaryArray[leasedCount] = item;
		++leasedCount;
		// Update the leasedItems array to the new temporary array
		leasedItems = temporaryArray;
		
	}
	
	// Method to remove a leased item from the client
	public void removeLeasedItem(String id) {
		
		boolean found = false;
		for (int i = 0; i<leasedItems.length; i++) {
			//Checks if the ID of the leased item matches the provided ID 
			if (leasedItems[i].getID().equals(id)) {
				found = true;
				--leasedCount;
				leasedItems[i] = null;
				Items[] temporaryArray = new Items[leasedCount];
				// Copy leased items before the removed item to the temporary array
				for (int j = 0; j < i; j++) {
					temporaryArray[j] = leasedItems[j];
				}
				
				// Copy leased items after the removed item to the temporary array, adjusting the index
				for (int k = i; k < leasedCount; k++) {
					temporaryArray[k] = leasedItems[k+1];
				}
				
				// Update the leasedItems array to the new temporary array
				leasedItems = temporaryArray;
				System.out.println("Returned Sucessfully!");
			}
		}
		
		// If the item with the provided ID is not found
		if (found == false) {
			System.out.println("Item not found, or not leased by client!");
		}
	}
}
