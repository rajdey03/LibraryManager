// -------------------------------------------------------
	// Assignment 1
	// Question: Driver class
	// Written by: Huu Khoa Kevin Tran 40283037 && Pritthiraj Dey 40273416
	// For COMP 249 Section WW && QQ – Winter 2024
	// --------------------------------------------------------

	// Date of submission: Friday, 1st March 2024
	
	/*
	 * The LibraryManager class contains the main logic for managing the library system. 
	 * It includes methods for adding, deleting, and editing items and clients, 
	 * leasing items to clients, returning items, and displaying information about the library's inventory and clients. 
	 * The main method controls the interaction with the user through a menu-driven interface.
	 */
// -------------------------------------------------------

package library_driver;
import library.*;
import clients.*;
import java.util.Scanner;

public class LibraryDriver {
	
	static Scanner input = new Scanner(System.in);
	// Arrays to store different types of items and clients
	static private Books[] arrBooks = new Books[0];
	static private Journals[] arrJournals = new Journals[0];
	static private Media[] arrMedia = new Media[0];
	static private Items[] arrOtherItems = new Items[0];
	static private Client[] arrClient = new Client[0];
	// Variable to track if an item or client is found during search operations
	static private boolean found;
	// Variables to keep track of counts for each type of item and client
	static private int countBooks, countJournals, countMedia, countOtherItems, countClient;
	
	// Method to add a new item to the library
	public static void addItem() {
		System.out.print("Which category of item would you like to add to?\n"
						+"1. Book\n"
						+"2. Journal\n"
						+"3. Media\n"
						+"4. Other\n"
						+">");
		int type = input.nextInt();
		input.nextLine();
		
		do {
			switch(type) {
				case 1:
					System.out.print("Please enter new book's information (Name,Author,Year of Publication,Number of Pages): ");
					String info = input.nextLine();
					String[] infoArray = info.split(",");
					
					Items[] temporaryArray = new Books[countBooks+1];
					for (int i = 0; i<countBooks; i++) {
						temporaryArray[i] = arrBooks[i];
					}
					
					// Adding the new book to the temporary array
					temporaryArray[countBooks] = new Books(infoArray[0], infoArray[1], Integer.parseInt(infoArray[2]), Integer.parseInt(infoArray[3]));
					arrBooks = (Books[]) temporaryArray;
					++countBooks;
					System.out.println("Sucessfully added!");
					break;
				case 2:
					System.out.print("Please enter new journal's information (Name,Author,Year of Publication,Volume Number): ");
					info = input.nextLine();
					infoArray = info.split(",");
					
					temporaryArray = new Journals[countJournals+1];
					for (int i = 0; i<countJournals; i++) {
						temporaryArray[i] = arrJournals[i];
					}
					
					// Adding the new journal to the temporary array
					temporaryArray[countJournals] = new Journals(infoArray[0], infoArray[1], Integer.parseInt(infoArray[2]), Integer.parseInt(infoArray[3]));
					arrJournals = (Journals[]) temporaryArray;
					++countJournals;
					System.out.println("Sucessfully added!");
					break;
				case 3:
					System.out.print("Please enter new media's information (Name,Author,Year of Publication,Media Type): ");
					info = input.nextLine();
					infoArray = info.split(",");
					
					temporaryArray = new Media[countMedia+1];
					for (int i = 0; i<countMedia; i++) {
						temporaryArray[i] = arrMedia[i];
					}
					
					// Adding the new media item to the temporary array
					temporaryArray[countMedia] = new Media(infoArray[0], infoArray[1], Integer.parseInt(infoArray[2]), infoArray[3]);
					arrMedia = (Media[]) temporaryArray;
					++countMedia;
					System.out.println("Sucessfully added!");
					break;
				case 4:
					System.out.print("Please enter new item's information (Name,Author,Year of Publication): ");
					info = input.nextLine();
					infoArray = info.split(",");
					
					temporaryArray = new Items[countOtherItems+1];
					for (int i = 0; i<countOtherItems; i++) {
						temporaryArray[i] = arrOtherItems[i];
					}
					
					// Adding the new item to the temporary array
					temporaryArray[countOtherItems] = new Items(infoArray[0], infoArray[1], Integer.parseInt(infoArray[2]));
					arrOtherItems = (Items[]) temporaryArray;
					++countOtherItems;
					System.out.println("Sucessfully added!");
					break;
				default:
					System.out.print("\nWrong input! Try again >");	
					type = input.nextInt();
					input.nextLine();
			}
		} while (type > 4 || type < 1);
	}
	
	// Method to delete an item from the library
	public static void deleteItem() {
		System.out.print("Which item would you like to delete (ID)?: ");
		String id = input.nextLine();
		
		// Checks if the item ID belongs to a book
		if (id.startsWith("B")) {
			for (int i = 0; i<arrBooks.length; i++) {
				//Checks if the ID of the book matches the provided ID
				if (arrBooks[i].getID().equals(id)) {
					found = true;
					--countBooks;
					arrBooks[i] = null;
					Books[] temporaryArray = new Books[countBooks];
					// Copy books before the deleted book to the temporary array
					for (int j = 0; j < i; j++) {
						temporaryArray[j] = arrBooks[j];
					}
					
					// Copy books after the deleted book to the temporary array, adjusting the index
					for (int k = i; k < countBooks; k++) {
						temporaryArray[k] = arrBooks[k+1];
					}
					// Updates the book array
					arrBooks = temporaryArray;
					System.out.println("Deleted Sucessfully!");
				}
			}
			
		} 
		
		// Checks if the item ID belongs to a journal
		else if (id.startsWith("J")) {
			for (int i = 0; i<arrJournals.length; i++) {
				if (arrJournals[i].getID().equals(id)) {
					found = true;
					--countJournals;
					arrJournals[i] = null;
					Journals[] temporaryArray = new Journals[countJournals];
					for (int j = 0; j < i; j++) {
						temporaryArray[j] = arrJournals[j];
					}
					
					for (int k = i; k < countJournals; k++) {
						temporaryArray[k] = arrJournals[k+1];
					}
					arrJournals = temporaryArray;
					System.out.println("Deleted Sucessfully!");
				}
			}
			
		} 
		
		// Checks if the item ID belongs to a media item
		else if (id.startsWith("M")) {
			for (int i = 0; i<arrMedia.length; i++) {
				if (arrMedia[i].getID() == id) {
					found = true;
					--countMedia;
					arrMedia[i] = null;
					Media[] temporaryArray = new Media[countMedia];
					for (int j = 0; j < i; j++) {
						temporaryArray[j] = arrMedia[j];
					}
					
					for (int k = i; k < countMedia; k++) {
						temporaryArray[k] = arrMedia[k+1];
					}
					arrMedia = temporaryArray;
					System.out.println("Deleted Sucessfully!");
				}
			}
			
		} 
		
		// If it is an item that is not a book, journal or type of media
		else {
			for (int i = 0; i<arrOtherItems.length; i++) {
				if (arrOtherItems[i].getID() == id) {
					found = true;
					--countOtherItems;
					arrOtherItems[i] = null;
					Items[] temporaryArray = new Items[countOtherItems];
					for (int j = 0; j < i; j++) {
						temporaryArray[j] = arrOtherItems[j];
					}
					
					for (int k = i; k < countOtherItems; k++) {
						temporaryArray[k] = arrOtherItems[k+1];
					}
					arrOtherItems = temporaryArray;
					System.out.println("Deleted Sucessfully!");
				}
			}
		}
		
		// If the item with the provided ID is not found
		if (found == false) {
			System.out.println("Sorry, there are no item corresponding to the ID!");
		}
		
		found = false;
	}
	
	// Method to edit the information of a specific item
	public static void editItem() {
		System.out.print("Which item would you like to delete (ID)?: ");
		String id = input.nextLine();
		
		// Checks if the item ID belongs to a book
		if (id.startsWith("B")) {
			for (int i = 0; i<arrBooks.length; i++) {
				//Checks if the ID of the book matches the provided ID
				if (arrBooks[i].getID().equals(id)) {
					found = true;
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+"4. Number of Pages\n"
							+">");
					int choice = input.nextInt();
					input.nextLine();
					
					do {
						switch (choice) {
							case 1:
								System.out.print("Type in the new name: ");
								arrBooks[i].setName(input.nextLine());
								break;
							case 2:
								System.out.print("Type in the new author: ");
								arrBooks[i].setAuthor(input.nextLine());
								break;
							case 3:
								System.out.print("Type in the new year of publication: ");
								arrBooks[i].setPublishYear(input.nextInt());
								break;
							case 4:
								System.out.print("Type in the new number of pages: ");
								arrBooks[i].setNumPages(input.nextInt());
								input.nextLine();
								break;
							default:
								System.out.print("Wrong input! Try again >");
						}
					} while (choice > 4 || choice < 1);
					
					System.out.println("Changed Sucessfully!");
				}
			}
			
		} 
		
		// Checks if the item ID belongs to a journal
		else if (id.startsWith("J")) {
			for (int i = 0; i<arrJournals.length; i++) {
				if (arrJournals[i].getID().equals(id)) {
					found = true;
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+"4. Volume number\n"
							+">");
					int choice = input.nextInt();
					input.nextLine();
					
					do {
						switch (choice) {
							case 1:
								System.out.print("Type in the new name: ");
								arrJournals[i].setName(input.nextLine());
								break;
							case 2:
								System.out.print("Type in the new author: ");
								arrJournals[i].setAuthor(input.nextLine());
								break;
							case 3:
								System.out.print("Type in the new year of publication: ");
								arrJournals[i].setPublishYear(input.nextInt());
								break;
							case 4:
								System.out.print("Type in the new number of volume: ");
								arrJournals[i].setNumVolume(input.nextInt());
								input.nextLine();
								break;
							default:
								System.out.print("Wrong input! Try again >");
						}
					} while (choice > 4 || choice < 1);
					
					System.out.println("Changed Sucessfully!");
				}
			}
			
		} 
		
		// Checks if the item ID belongs to a media item
		else if (id.startsWith("M")) {
			for (int i = 0; i<arrMedia.length; i++) {
				if (arrMedia[i].getID().equals(id)) {
					found = true;
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+"4. Media Type\n"
							+">");
					int choice = input.nextInt();
					input.nextLine();
					
					do {
						switch (choice) {
							case 1:
								System.out.print("Type in the new name: ");
								arrMedia[i].setName(input.nextLine());
								break;
							case 2:
								System.out.print("Type in the new author: ");
								arrMedia[i].setAuthor(input.nextLine());
								break;
							case 3:
								System.out.print("Type in the new year of publication: ");
								arrMedia[i].setPublishYear(input.nextInt());
								input.nextLine();
								break;
							case 4:
								System.out.print("Type in the new media type: ");
								arrMedia[i].setType(input.nextLine());
								break;
							default:
								System.out.print("Wrong input! Try again >");
						}
					} while (choice > 4 || choice < 1);
					
					System.out.println("Changed Sucessfully!");
				}
			}
			
		} 
		
		// Checks if the item ID belongs to an item that is not a book, a journal or a media item
		else {
			for (int i = 0; i<arrOtherItems.length; i++) {
				if (arrOtherItems[i].getID().equals(id)) {
					found = true;
					System.out.print("Which information would you like to change?\n"
							+"1. Name\n"
							+"2. Author\n"
							+"3. Year of Publication\n"
							+">");
					int choice = input.nextInt();
					input.nextLine();
					
					do {
						switch (choice) {
							case 1:
								System.out.print("Type in the new name: ");
								arrOtherItems[i].setName(input.nextLine());
								break;
							case 2:
								System.out.print("Type in the new author: ");
								arrOtherItems[i].setAuthor(input.nextLine());
								break;
							case 3:
								System.out.print("Type in the new year of publication: ");
								arrOtherItems[i].setPublishYear(input.nextInt());
								input.nextLine();
								break;
							default:
								System.out.print("Wrong input! Try again >");
						}
					} while (choice > 3 || choice < 1);
					
					System.out.println("Changed Sucessfully!");
				}
			}
		}
		
		// If the item with the provided ID is not found
		if (found == false) {
			System.out.println("Sorry, there are no item corresponding to the ID!");
		}
		
		found = false;
	}
	
	// Method that lists all the information of all the items in a specific item category
	public static void listCategory() {
		System.out.print("Which type of category of item would you like to list all\n"
				+"1. Book\n"
				+"2. Journal\n"
				+"3. Media\n"
				+"4. Other\n"
				+">");
		int type = input.nextInt();
		input.nextLine();
		
		do {
			switch(type) {
				case 1:
					for (Books element : arrBooks) {
						System.out.println(element.toString());
					}
					break;
				case 2:
					for (Journals element : arrJournals) {
						System.out.println(element.toString());
					}
					break;
				case 3:
					for (Media element : arrMedia) {
						System.out.println(element.toString());
					}
					break;
				case 4:
					for (Items element : arrOtherItems) {
						System.out.println(element.toString());
					}
					break;
				default:
					System.out.print("\nWrong input! Try again >");	
			}
		} while (type > 4 || type < 1);
	}
	
	// Method that lists all items
	public static void showAll() {
		for (Books element : arrBooks) {
			System.out.println(element.toString());
		}
		for (Journals element : arrJournals) {
			System.out.println(element.toString());
		}
		for (Media element : arrMedia) {
			System.out.println(element.toString());
		}
		for (Items element : arrOtherItems) {
			System.out.println(element.toString());
		}
	}
	
	// Method for adding a client
	public static void addClient() {
		System.out.print("Please enter client's information (Name,Phone number,Address): ");
		String info = input.nextLine();
		String[] infoArray = info.split(",");
		
		Client[] temporaryArray = new Client[countClient+1];
		// Copy existing clients into the temporary array
		for (int i = 0; i<countClient; i++) {
			temporaryArray[i] = arrClient[i];
		}
		
		// Adds the new client to the temporary array
		temporaryArray[countClient] = new Client(infoArray[0], Long.parseLong(infoArray[1]), infoArray[2]);
		// Updates the client array
		arrClient = (Client[]) temporaryArray;
		++countClient;
		System.out.println("Client Sucessfully added!");
	}
	
	// Method that edits the information of a client
	public static void editClient() {
		
		System.out.print("Which client would you like to edit (ID)?: ");
		String id = input.nextLine();
		
		for (int i = 0; i<arrClient.length; i++) {
			//Checks if the ID of the client matches the provided ID 
			if (arrClient[i].getID().equals(id)) {
				found = true;
				System.out.print("Which information would you like to change?\n"
						+"1. Name\n"
						+"2. Phone Number\n"
						+"3. Email\n"
						+">");
				int choice = input.nextInt();
				input.nextLine();
				
				do {
					switch (choice) {
						case 1:
							System.out.print("Type in the new name: ");
							arrClient[i].setName(input.nextLine());
							break;
						case 2:
							System.out.print("Type in the new phone number: ");
							arrClient[i].setPhoneNumber(input.nextLong());
							input.nextLine();
							break;
						case 3:
							System.out.print("Type in the new email: ");
							arrClient[i].setEmail(input.nextLine());
							break;
						default:
							System.out.print("Wrong input! Try again >");
							break;
					}
				} while (choice > 3 || choice < 1);
				System.out.println("Changed Sucessfully!");
			}
		}
		
		// If the item with the provided ID is not found
		if (found == false) {
			System.out.println("Client does not exist");
		}
		
		found = false;
	}
	
	// Method for deleting a client
	public static void deleteClient() {
		System.out.print("Which client would you like to delete (ID)?: ");
		String id = input.nextLine();
		
		for (int i = 0; i<arrClient.length; i++) {
			//Checks if the ID of the client matches the provided ID 
			if (arrClient[i].getID().equals(id)) {
				found = true;
				--countClient;
				arrClient[i] = null;
				Client[] temporaryArray = new Client[countClient];
				// Copy clients before the removed item to the temporary array
				for (int j = 0; j < i; j++) {
					temporaryArray[j] = arrClient[j];
				}
				
				// Copy clients after the removed item to the temporary array, adjusting the index
				for (int k = i; k < countClient; k++) {
					temporaryArray[k] = arrClient[k+1];
				}
				
				//Updates the client array
				arrClient = temporaryArray;
				System.out.println("Client Deleted Sucessfully!");
			}
		}
		
		// If the item with the provided ID is not found
		if (found == false) {
			System.out.println("Client does not exist!");
		}
		
		found = false;
	}
	
	// Method that will lease an item to a client
	public static void leaseItemToClient() {
		System.out.print("Enter the client's ID: ");
	    String clientID = input.nextLine();
	    
	    for (int i = 0; i<arrClient.length; i++) {
	    	//Checks if the ID of the client matches the provided ID 
	        if (arrClient[i].getID().equals(clientID)) {
	            found = true;
	            
	            // Display available items
	            System.out.println("Available Items:");
	            // Iterate through each item category and display items that are not leased
	            for (int j = 0; j<arrBooks.length; j++) {
	                if (!isItemLeased(arrBooks[j])) {
	                    System.out.println(arrBooks[j].toString());
	                }
	            }
	            for (int j = 0; j<arrJournals.length; j++) {
	                if (!isItemLeased(arrJournals[j])) {
	                    System.out.println(arrJournals[j].toString());
	                }
	            }
	            for (int j = 0; j<arrMedia.length; j++) {
	                if (!isItemLeased(arrMedia[j])) {
	                    System.out.println(arrMedia[j].toString());
	                }
	            }
	            for (int j = 0; j<arrOtherItems.length; j++) {
	                if (!isItemLeased(arrOtherItems[j])) {
	                    System.out.println(arrOtherItems[j].toString());
	                }
	            }
	            
	            // Select an item to lease
	            System.out.print("Enter the ID of the item to lease: ");
	            String itemID = input.nextLine();
	            boolean leased = false;
	            
	            // Find the item and add it to the client's leased items array
	            for (int j = 0; j<arrBooks.length; j++) {
	                if (arrBooks[j].getID().equals(itemID) && !isItemLeased(arrBooks[j])) {
	                	arrClient[i].addLeasedItem(arrBooks[j]);
	                    System.out.println("Item leased successfully!");
	                    leased = true;
	                    break;
	                }
	            }
	            for (int j = 0; j<arrJournals.length; j++) {
	                if (arrJournals[j].getID().equals(itemID) && !isItemLeased(arrJournals[j])) {
	                	arrClient[i].addLeasedItem(arrJournals[j]);
	                    System.out.println("Item leased successfully!");
	                    leased = true;
	                    break;
	                }
	            }
	            for (int j = 0; j<arrMedia.length; j++) {
	                if (arrMedia[j].getID().equals(itemID) && !isItemLeased(arrMedia[j])) {
	                	arrClient[i].addLeasedItem(arrMedia[j]);
	                    System.out.println("Item leased successfully!");
	                    leased = true;
	                    break;
	                }
	            }
	            for (int j = 0; j<arrOtherItems.length; j++) {
	                if (arrOtherItems[j].getID().equals(itemID) && !isItemLeased(arrOtherItems[j])) {
	                	arrClient[i].addLeasedItem(arrOtherItems[j]);
	                    System.out.println("Item leased successfully!");
	                    leased = true;
	                    break;
	                }
	            }
	            
	            if (leased == false) {
	            	System.out.println("Item not available for lease.");
	            }
	        }
	    }
	    
	 // If the item with the provided ID is not found
	    if (!found) {
	        System.out.println("Client not found.");
	    }
	    
	    found = false;
	}
	
	// Method that checks if an item is leased
	public static boolean isItemLeased(Items item) {
	    for (int i = 0; i<arrClient.length; i++) {
	    	for (int j = 0; j < arrClient[i].getLeased().length; j++) {
	    		if (arrClient[i].getLeased()[j].equals(item)) {
	    			return true;
	    		}
	    	}
		        
	    }
	    
	    return false;
	}
	
	// Method that takes a leased item from a client
	public static void returnItemFromClient() {
		System.out.print("Enter the client's ID: ");
	    String clientID = input.nextLine();
	    
	    for (int i = 0; i<arrClient.length; i++) {
	    	//Checks if the ID of the client matches the provided ID 
	        if (arrClient[i].getID().equals(clientID)) {
	            found = true;
	            
	            System.out.println("Leased Items:");
	            // Iterate through the leased items of the client
	            for (int j = 0; j < arrClient[i].getLeased().length; j++) {
	                if (arrClient[i].getLeased()[j]!= null) {
	                    System.out.println(arrClient[i].getLeased()[j].toString());
	                }
	            }
	    
	            System.out.print("Enter the ID of the item to return: ");
	            arrClient[i].removeLeasedItem(input.nextLine());
	            
	        }
	    }
	    
	 // If the item with the provided ID is not found
	    if (!found) {
	        System.out.println("Client not found.");
	    }
	    
	    found = false;
	}
	
	// Method that shows all items leased by a client
	public static void showLeasedByClient() {
		System.out.print("Enter client ID: ");
	    String clientId = input.nextLine();
	    
	    for (int i = 0; i<arrClient.length; i++) {
	        if (arrClient[i].getID().equals(clientId)) {
	            found = true;
	            
	            if (arrClient[i] != null) {
	            	System.out.println("Items leased by client: ");
	            	// Checks if the client has any leased items
	            	if (arrClient[i].getLeased().length == 0) {
	            		// Iterate through the leased items of the client
		            	for (int j = 0; j<arrClient[i].getLeased().length; j++) {
		            		System.out.println(arrClient[i].getLeased()[j].toString());
		            	} 
	            	} 
	            	
	            	else {
	            		System.out.println("No Leased Items");
	            	}
	            }
	        }
	    }
	    if (!found) {
	        System.out.println("Client not found.");
	    }
	    
	    found = false;
	}
	
	// Method that shows all leased items
	public static void showAllLeased() {
		System.out.println("All leased items:");
	    for (Client client : arrClient) {
	    	// Checks if the client has any leased items
	    	if (client.getLeased().length == 0) {
		        for (Items item : client.getLeased()) {
		            System.out.println(item.toString());
		        }
	    	}
	    }
	}
	
	// Method that gets the biggest book in the library
	public static Books getBiggestBook() {
		// If library has no books
		if (arrBooks.length == 0) {
			return null;
		}
		
		Books biggestBook = arrBooks[0];
		for (int i = 0; i<arrBooks.length; i++) {
			if (arrBooks[i].getNumPages() > biggestBook.getNumPages()) {
				biggestBook = arrBooks[i];
			}
		}
		return biggestBook;
	}
	
	// Method to create a copy of an array of books
	public static Books[] copyBooks(Books[] arrBook) {
		Books[] copyArrBooks = new Books[arrBook.length];
		
		for (int i = 0; i < arrBook.length; i++) {
			copyArrBooks[i] = new Books(arrBook[i]);
		}
		
		return copyArrBooks;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int display_choice;
		int menu_choice;
		
		System.out.println("Welcome to the Fun Reading library manager.\n");
		System.out.println("What would you like to do?");
		System.out.println("   1.   Display the menu.");
        System.out.println("   2.   Run a predefined scenario.");
        System.out.print("Please enter your choice: ");
        display_choice = input.nextInt();
        input.nextLine();
        
        // Displays menu if user chooses number 1
        if (display_choice == 1) {
        	do {
    			System.out.println("\nWhat would you like to do?");
                System.out.println("   1.   Add an item.");
                System.out.println("   2.   Delete an item.");
                System.out.println("   3.   Change information of an item.");
                System.out.println("   4.   List all items in a specific category");
                System.out.println("   5.   Print all items.");
                System.out.println("   6.   Add a client.");
                System.out.println("   7.   Edit a client.");
                System.out.println("   8.   Delete a client.");
                System.out.println("   9.   Lease an item to a client.");
                System.out.println("  10.   Return an item from a client.");
                System.out.println("  11.   Show all items leased by a client.");
                System.out.println("  12.   Show all leased items.");
                System.out.println("  13.   Display the biggest book.");
                System.out.println("  14.   Make a copy of the books array.");
                System.out.println("  15.   Quit");
                System.out.print("Please enter your choice: ");
                menu_choice = input.nextInt();
                input.nextLine();
                
                switch (menu_choice) {
                	case 1:
                		addItem();
                		break;
                	case 2:
                		deleteItem();
                		break;
                	case 3:
                		editItem();
                		break;
                	case 4:
                		listCategory();
                		break;
                	case 5:
                		showAll();
                		break;
                	case 6:
                		addClient();
                		break;
                	case 7:
                		editClient();
                		break;
                	case 8:
                		deleteClient();
                		break;
                	case 9:
                		leaseItemToClient();
                		break;
                	case 10:
                		returnItemFromClient();
                		break;
                	case 11:
                		showLeasedByClient();
                		break;
                	case 12:
                		showAllLeased();
                		break;
                	case 13:
                		System.out.println("The biggest book is " + ((getBiggestBook()!=null)?getBiggestBook().toString():"None"));
                		break;
                	case 14:
                		System.out.println("Books have been copied: \n"+copyBooks(arrBooks).toString());
                		break;
                	case 15:
                		System.out.println("Thank you for using the FunReadings library manager.");
                		break;
                	default:
                		System.out.println("Invalid choice. Please choose a valid option.");
                }
         
    		} while(menu_choice != 15);
        	
        }
        
        // Runs a predefined scenario if user chooses number 2
        else if (display_choice == 2) {
        	 Books[] defined_books = new Books[3];
        	 Journals[] defined_journals = new Journals[3];
        	 Media[] defined_media = new Media[3];
        	 Items[] defined_otherItems = new Items[9];
        	 Client[] defined_clients = new Client[3];
        	 
        	 //Creating objects of type books, journals, media and clients, and storing them in their respective array
        	 defined_books[0] = new Books("Book1", "Author1", 2020, 300);
        	 defined_books[1] = new Books("Book2", "Author2", 2018, 250);
        	 defined_books[2] = new Books("Book1", "Author1", 2020, 300);
        	 arrBooks = defined_books;

        	 defined_journals[0] = new Journals("Journal1", "Author4", 2021, 5);
        	 defined_journals[1] = new Journals("Journal2", "Author5", 2019, 6);
        	 defined_journals[2] = new Journals("Journal3", "Author6", 2017, 7);
        	 arrJournals = defined_journals;

        	 defined_media[0] = new Media("Media1", "Author7", 2022, "DVD");
        	 defined_media[1] = new Media("Media2", "Author8", 2016, "Blu-ray");
        	 defined_media[2] = new Media("Media3", "Author9", 2014, "CD");
        	 arrMedia = defined_media;

        	 defined_clients[0] = new Client("User1", 1234567890, "user1@example.com");
        	 defined_clients[1] = new Client("User2", 1010101010, "user2@example.com");
        	 defined_clients[2] = new Client("User3", 1111111111, "user3@example.com");
        	 arrClient = defined_clients;
        	 
        	 // Display the information of all items and clients
        	 System.out.println(defined_books[0].toString());
             System.out.println(defined_books[1].toString());
             System.out.println(defined_books[2].toString());
             System.out.println(defined_journals[0].toString());
             System.out.println(defined_journals[1].toString());
             System.out.println(defined_journals[2].toString());
             System.out.println(defined_media[0].toString());
             System.out.println(defined_media[1].toString());
             System.out.println(defined_media[2].toString());
             System.out.println(defined_clients[0].toString());
             System.out.println(defined_clients[1].toString());
             System.out.println(defined_clients[2].toString());
             
          // Testing equality of items with other items array
             System.out.println("Equality test 1: " + defined_books[0].equals(defined_media[0]));
             System.out.println("Equality test 2: " + defined_books[0].equals(defined_books[1]));
             System.out.println("Equality test 3: " + defined_books[0].equals(defined_books[2]));
             
             defined_otherItems[0] = defined_books[0];
             defined_otherItems[1] = defined_books[1];
             defined_otherItems[2] = defined_books[2];
             defined_otherItems[3] = defined_journals[0];
             defined_otherItems[4] = defined_journals[1];
             defined_otherItems[5] = defined_journals[2];
             defined_otherItems[6] = defined_media[0];
             defined_otherItems[7] = defined_media[1];
             defined_otherItems[8] = defined_media[2];
             
             System.out.println("The biggest book: " + ((getBiggestBook()!=null)?getBiggestBook().toString():"None"));
             
            // Books[] copied_books = copyBooks(defined_media);
            // System.out.println("Copied Books: ");
           // for (Books book: copied_books) {
            //	System.out.println(book.toString());
 
        }
        
        input.close();
	}

}
