/**
 * 
 */
package com.pack;

import java.math.BigDecimal;

/**
 * @author bhavya
 * 
 *         Class to hold properties for Book
 *
 */
public class Book {

	private String title;

	private String author;

	private BigDecimal price;

	private int quantity;

	public Book(String title, String author, BigDecimal cost, int quantity) {

		this.title = title;
		this.author = author;
		this.price = cost;
		this.quantity = quantity;
	}

	public String toString() {

		return "Title: " + this.title + ", Author: " + this.author
				+ ", Price: " + this.price + ", Quantity: " + this.quantity;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
