package com.pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author bhavya
 * 
 *         Main class to implement Book Store
 *
 */
public class BookStoreMain {

	public static void main(String[] args) {
		BookListImpl bli = new BookListImpl();
		//Load the static list of books			
		bli.loadBooks();
		String userChoice;
		boolean quit = false;
		do {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			System.out.println();
			System.out.println("Online Book Store : ");
			System.out.println("1) List Books by Title / Author");
			System.out.println("2) Add Book ");
			System.out.println("3) Remove Book ");
			System.out.println("4) Buy a Book ");
			System.out.println("5) Quit");
			System.out.println();
			System.out.print("Enter your choice : ");
			try {
				userChoice = br.readLine();

				switch (userChoice) {
				case "1":
					System.out
							.println("Enter 'All' to list all books or Title/Author of the book");
					String bookChoice = br.readLine();
					Book[] obj = bli.list(bookChoice);
					if (obj.length == 0) {
						System.out.println("Book not found !");
					}
					break;
				case "2":
					// Add a new book to his basket
					System.out.println("Enter Title: ");
					String title = br.readLine();
					System.out.println("Enter Author: ");
					String author = br.readLine();
					System.out.println("Enter price: ");
					String price = br.readLine();
					System.out.println("Enter Quantity: ");
					String quantity = br.readLine();

					if (title != null && author != null && price != null
							&& quantity != null) {
						try {
							Book newBook = new Book(title, author,
									new BigDecimal(price),
									Integer.valueOf(quantity));
							System.out.println("===== Total Books in your basket: =====");
							boolean bookAdded = bli.add(newBook,
									Integer.valueOf(quantity));
							if (bookAdded) {
								System.out.println("===== New book added ===== ");
							} else {
								System.out.println("Please enter valid input");
							}
						} catch (NumberFormatException nfe) {
							System.out
									.println("Invalid price. Please enter valid input");
						}
					} else {
						System.out.println("Please enter valid input");

					}

					break;
				case "3":
					System.out.println("Enter Title: ");
					String remBookTitle = br.readLine();
					System.out.println("Enter Author: ");
					String remBookAuthor = br.readLine();
					System.out.println("Enter Price: ");
					String remBookPrice = br.readLine();
					System.out.println("Enter Quantity: ");
					String remBookQty = br.readLine();
					
					Book remBook = new Book(remBookTitle, remBookAuthor, new BigDecimal(remBookPrice), Integer.valueOf(remBookQty));
					boolean removeStatus = bli.remove(remBook);
					System.out.println("Status of remove of selected book: " + removeStatus);
					
					break;
				case "4":
					// User inputs the Book Title and Quantity he wants to buy
					System.out.println("Enter Title : ");
					String buyTitle = br.readLine();
					System.out.println("Enter Author: ");
					String buyAuthor = br.readLine();
					System.out.println("Enter Price: ");
					String buyPrice = br.readLine();
					System.out.println("Enter Quantity : ");
					String buyQuantity = br.readLine();
					if (buyTitle != null && buyQuantity != null) {
						Book buyBook = new Book(buyTitle, buyAuthor,
								new BigDecimal(buyPrice),
								Integer.valueOf(buyQuantity));
						int[] buyStatus = bli.buy(buyBook);

						if (buyStatus[0] == 0) {
							System.out.println("===== OK, Book Available ===== ");
						} else if (buyStatus[0] == 1) {
							System.out.println("===== NOT_IN_STOCK =====");
						} else if (buyStatus[0] == 2) {
							System.out.println("===== DOES_NOT_EXIST =====");

						}
					} else {
						System.out.println("Please enter valid input");
					}

					break;
				case "5":
					System.out.println("===== Quitting program !! =====");
					quit = true;
					break;
				default:
					System.out.println("\nInvalid Choice");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (!quit);

	}
}
