package asm_1.Model;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 */
public class Book extends Item{

    /**
     * Default constructor
     * @param next
     *
     */
    public Book() throws FileNotFoundException {
        super();
        this.authors = null;
        this.edition = null;
        this.isbn = null;
        numberOfCopy = 0;
    }

    private String authors;
    private String edition;
    private String isbn;
    public static int numberOfCopy;


    /**
     * @param title 
     * @param authors 
     * @param edition 
     * @param publication 
     * @param year 
     * @param isbn 
     * @param language 
     * @param subject 
     * @param status
     */
    public Book(String id,String title,String authors,String edition,String publication,String year,String isbn,String language,String subject,String status) {
        super(id,title,publication,year,language,subject,status);
        this.authors = authors;
        this.edition = edition;
        this.isbn = isbn;
        numberOfCopy ++;
    }

    /**
     * @return
     */
    public String toString() {
        return id  +"; "+ title +"; "+ authors +"; "+ edition +"; "+ publication +"; "+ year +"; "+ isbn +"; "+ language +"; "+ subject +"; "+ status;
    }

    public String getId() {
        return id;
    }

    /**
     * @param authors 
     * @return
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * @param edition 
     * @return
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @param isbn 
     * @return
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @param title 
     * @return
     */
    public void setTitle(String title) {
      this.title = title;
    }

    /**
     * @param publication 
     * @return
     */
    public void setPublication(String publication) {
        this.publication = publication;
    }

    /**
     * @param year 
     * @return
     */
    public void setYear(String year) {
       this.year = year;
    }

    /**
     * @param language 
     * @return
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @param subject 
     * @return
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @param status 
     * @return
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param id
     * @return
     */
    public void setId(String id) {
        this.id = id;
    }
}