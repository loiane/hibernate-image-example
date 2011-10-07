package com.loiane.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.loiane.dao.BookDAOImpl;
import com.loiane.model.Book;

/**
 * Test Case
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class TestBookDAO {
	
	private static BookDAOImpl bookDAO;

	@BeforeClass
	public static  void runBeforeClass() {
		bookDAO = new BookDAOImpl();
	}

	@AfterClass
	public static void runAfterClass() {
		bookDAO = null;
	}

	/**
	 * Test method for {@link com.loiane.dao.BookDAOImpl#saveBook()}.
	 */
	@Test
	public void testSaveBook() {
		
		//File file = new File("images\\extjsfirstlook.jpg"); //windows
		File file = new File("images/extjsfirstlook.jpg");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	        FileInputStream fileInputStream = new FileInputStream(file);
	        fileInputStream.read(bFile);
	        fileInputStream.close();
        } catch (Exception e) {
	        e.printStackTrace();
        }
        
        Book book = new Book();
        book.setName("Ext JS 4 First Look");
        book.setImage(bFile);
        
        bookDAO.saveBook(book);
        
        assertNotNull(book.getId());
	}

	/**
	 * Test method for {@link com.loiane.dao.BookDAOImpl#getBook()}.
	 */
	@Test
	public void testGetBook() {
		
		Book book = bookDAO.getBook((long) 1);
		
		assertNotNull(book);
		
		try{
        	//FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows
        	FileOutputStream fos = new FileOutputStream("images/output.jpg"); 
            fos.write(book.getImage());
            fos.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
