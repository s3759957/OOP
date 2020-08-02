package asm_1.Model;

import java.io.FileNotFoundException;

/**
 * 
 */
public class Book {

    /**
     * Default constructor
     * @param
     *
     */
    public Book() throws FileNotFoundException {
        authors = null;
        edition = null;
        isbn = null;
        id = null;
        title = null;
        publication = null;
        year = null;
        language = null;
        subject = null;
        status = null;
        numberOfCopy = 0;

    }

    private String authors;
    private String edition;
    private String isbn;
    private String id;
    private String title;
    private String publication;
    private String year;
    private String language;
    private String subject;
    private String status;
    private int numberOfCopy;

    /**
     * @param id
     * @param title 
     * @param authors 
     * @param edition 
     * @param publication 
     * @param year 
     * @param isbn 
     * @param language 
     * @param subject 
     * @param status
     * @param numberOfCopy
     */
    public Book(String id,String title,String authors,String edition,String publication,String year,String isbn,String language,String subject,String status,int numberOfCopy) {
        this.authors = authors;
        this.edition = edition;
        this.isbn = isbn;
        this.id = id;
        this.title = title;
        this.publication = publication;
        this.year = year;
        this.language = language;
        this.subject = subject;
        this.status = status;
        this.numberOfCopy = numberOfCopy;

    }

    /**
     * @return
     */
    public String toString() {
        return id  +";"+ title +";"+ authors +";"+ edition +";"+ publication +";"+ year +";"+ isbn +";"+ language +";"+ subject +";"+ status+";"+ numberOfCopy+";";
    }

    public String getId() {
        return id;
    }
    public int getNumberOfCopy() {
        return numberOfCopy;
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

    /**
     * @param numberOfCopy
     * @return
     */
    public void setNumberOfCopy(int numberOfCopy) {
        this.numberOfCopy = numberOfCopy;
    }
}