/**
 * 
 */
package com.pack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author bhavya
 *
 */
public class BookListImpl implements BookList {
	private List<Book> booksList = new ArrayList<Book>();

	/**
	 * Method to load the static list of Books
	 * 
	 * @return List of Books from Book Store
	 */
	public List<Book> loadBooks() {

		booksList.add(new Book("Mastering едц ", "Average Swede",
				new BigDecimal("762.00"), 15));
		booksList.add(new Book("How To Spend Money", "Rich Bloke",
				new BigDecimal("1000000.00"), 1));
		booksList.add(new Book("Generic Title", "First Author", new BigDecimal(
				"185.50"), 5));
		booksList.add(new Book("Generic Title", "Second Author",
				new BigDecimal("1748.00"), 3));
		booksList.add(new Book("Random Sales", "Cunning Bastard",
				new BigDecimal("999.00"), 20));
		booksList.add(new Book("Random Sales", "Cunning Bastard",
				new BigDecimal("499.00"), 3));
		booksList.add(new Book("Desired", "Rich Bloke",
				new BigDecimal("564.50"), 0));
		return booksList;
	}

	/*
	 * 
	 * Method to list books based on user input.
	 * 
	 * User inputs 'All' to get all the books in the Store. User inputs specific
	 * Title or Author get respective book data
	 */
	@Override
	public Book[] list(String searchString) {
		// TODO Auto-generated method stub

		List<Book> booksListNew = new ArrayList<Book>();
//		System.out.println("search String " + searchString);
		for (Book book : booksList) {
			if (book != null && searchString.equalsIgnoreCase("All")) {
				booksListNew.add(book);
			} else if (book != null
					&& searchString != null
					&& ((StringUtils.containsIgnoreCase(book.getTitle(),
							searchString)) || (StringUtils.containsIgnoreCase(
							book.getAuthor(), searchString)))) {
				booksListNew.add(book);
			}
		}

		Book[] bookObj = booksListNew.toArray(new Book[booksListNew.size()]);
		System.out.println("===== List of books : ===== ");
		for (Book book : bookObj) {
			System.out.println(book.toString());
		}
		return bookObj;

	}

	/*
	 * 
	 * Method to add a new book to his basket
	 * 
	 * @return true if new book was added successfully
	 * @return false if adding new book failed
	 * 
	 */
	@Override
	public boolean add(Book book, int quantity) {
		// TODO Auto-generated method stub
		BigDecimal totalPrice = new BigDecimal(0.0);
		if (isValidField(book.getPrice(), book.getQuantity())) {
			booksList.add(book);
			for (Book bookObject : booksList) {
				System.out.println(bookObject.toString());
			}
			for (int i = 0; i < booksList.size(); i++) {

				totalPrice = totalPrice.add(booksList.get(i).getPrice());

			}
			System.out.println("===== Total Price of Books in your Basket: ===== "
					+ totalPrice);
			return true;
		}

		return false;
	}

	/**
	 * @param books
	 * @return true if deletion of selected book is successful
	 * @return false if deletion of selected book fails
	 */
	public boolean remove(Book book) {

		// System.out.println("number of books before:  " + booksList.size());
		BigDecimal totalPrice = new BigDecimal(0.0);
		Iterator itr = booksList.iterator();
		while (itr.hasNext()) {

			Book bookObj = (Book) itr.next();

			if ((bookObj.getTitle().equalsIgnoreCase(book.getTitle()))
					&& (bookObj.getAuthor().equalsIgnoreCase(book.getAuthor()) && (bookObj
							.getPrice().equals(book.getPrice()) && (bookObj
							.getQuantity() == book.getQuantity())))) {
				itr.remove();
				// System.out.println("number of books after new: "
				// + booksList.size());

				for (int i = 0; i < booksList.size(); i++) {
					totalPrice = totalPrice.add(booksList.get(i).getPrice());

				}
				System.out.println("=== List of books in your basket after remove : =====");
				
				for (Book bookObject : booksList) {
					System.out.println(bookObject.toString());
				}

				System.out.println("===== Total Price of Books in your Basket: ====="
						+ totalPrice);
				
				return true;

			}
		}
		return false;
	}

	/**
	 * @param price
	 * @param quantity
	 * @return true if Price and Quantity are numeric
	 * @return false if Price and Quantity are not numeric
	 */
	public boolean isValidField(BigDecimal price, int quantity) {

		if (NumberUtils.isNumber(String.valueOf(price))
				&& NumberUtils.isNumber(String.valueOf(quantity))) {
			return true;
		}
		return false;
	}

	/**
	 * Method to return the status of buying a book
	 */
	@Override
	public int[] buy(Book... books) {
		// TODO Auto-generated method stub
		int[] bookStatus = null;
		for (Book book : books) {
			bookStatus = inStock(book.getTitle(), book.getAuthor(),
					String.valueOf(book.getPrice()), book.getQuantity());

		}

		return bookStatus;
	}

	/**
	 * 
	 * Method will return the stock availability of the book
	 * 
	 * User to input the title and quantity of the book he wishes to buy
	 * 
	 * @param title
	 * @param quantity
	 * @return 0 if Book is available
	 * @return 1 if Book is not available
	 * @return 2 if Book does not exist
	 */
	public int[] inStock(String title, String author, String price, int quantity) {
		// int[] bookStatus = { 0, 1, 2 };
		int[] stockStatus = new int[3];
		int j = 0;

		for (int i = 0; i < booksList.size(); i++) {
			if ((title.equalsIgnoreCase(booksList.get(i).getTitle()))
					&& (author.equalsIgnoreCase(booksList.get(i).getAuthor()))
					&& (price.equalsIgnoreCase(String.valueOf(booksList.get(i)
							.getPrice())))) {
				if (quantity <= booksList.get(i).getQuantity()) {
					stockStatus[j] = 0;
					break;
				} else {
					stockStatus[j] = 1;
					break;
				}
			} else {
				stockStatus[j] = 2;
			}

		}

		return stockStatus;

	}

}
