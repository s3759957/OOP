package asm_1.Model;

import java.io.FileNotFoundException;

/**
 * 
 */
public class Journal{

    /**
     * Default constructor
     */
    public Journal() throws FileNotFoundException {
        issn = null;
        id = null;
        title = null;
        publication = null;
        year = null;
        language = null;
        subject = null;
        status = null;
        numberOfCopy = 0;

    }

    private String issn;
    private String id;
    private String title;
    private String publication;
    private String year;
    private String language;
    private String subject;
    private String status;
    private int numberOfCopy;



    /**
     * @param title 
     * @param publication 
     * @param year 
     * @param issn 
     * @param language 
     * @param subject 
     * @param status
     * @param numberOfCopy
     */
    public Journal(String id,String title, String publication, String year, String issn, String language, String subject, String status, int numberOfCopy) {
        this.issn = issn;
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
        return id +";"+title +";"+ publication +";"+ year +";"+ issn +";"+ language +";"+ subject +";"+ status+";"+ numberOfCopy+";";
    }

    public String getId() {
        return id;
    }
    public int getNumberOfCopy() {
        return numberOfCopy;
    }

    /**
     * @param issn
     * @return
     */
    public void setIssn(String issn) {
        this.issn = issn;
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