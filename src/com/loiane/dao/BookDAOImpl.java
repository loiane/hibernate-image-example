package com.loiane.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.loiane.hibernate.HibernateUtil;
import com.loiane.model.Book;

/**
 * Book DAO
 * Interacts with database.
 * Implemented for academic purposes.
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class BookDAOImpl {
	
	
	/**
	 * Inserts a row in the BOOK table.
	 * Do not need to pass the id, it will be generated.
	 * @param book 
	 * @return an instance of the object Book
	 */
	public Book saveBook(Book book)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return book;
	}
	
	
	/**
	 * Delete a book from database
	 * @param bookId id of the book to be retrieved
	 */
	public Book getBook(Long bookId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Book book = (Book) session.get(Book.class, bookId);
			return book;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
