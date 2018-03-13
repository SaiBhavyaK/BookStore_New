/**
 * 
 */
package com.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pack.BookListImpl;
import com.pack.BookStoreMain;
import com.pack.Book;

/**
 * @author bhavya
 *
 */
public class BookStoreMainTest {

	Book addBook = new Book("Test Title", "Test author", new BigDecimal(100), 5);
	Book remBook = new Book("Generic Title", "First Author", new BigDecimal(
			"185.50"), 5);

	Book buyBook = new Book("Generic Title", "First Author", new BigDecimal(
			"185.50"), 4);
	// BookStoreMain bsm = new BookStoreMain();
	BookListImpl bli = new BookListImpl();

	/**
	 * Test method for {@link com.pack.BookStoreMain#add(com.pack.Book, int)}.
	 */
	@Test
	public void testAdd() {
		bli.loadBooks();
		assertTrue(bli.add(addBook, 2));
	}

	/**
	 * Test method for {@link com.pack.BookStoreMain#remove(com.pack.Book, int)}
	 * .
	 */
	@Test
	public void testRemove() {
		bli.loadBooks();
		assertTrue(bli.remove(remBook));
	}

	/**
	 * Test method for {@link com.pack.BookStoreMain#buy(com.pack.Book[])}.
	 */
	@Test
	public void testBuy() {
		bli.loadBooks();
		assertNotNull(bli.buy(buyBook));

	}

}
