package asm_1.Model;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * 
 */
public class Member {

    /**
     * Default constructor
     */
    public Member() {
        fullName = null;
        id = null;
        phone = null;
        email = null;
        address = null;
        status = null;

    }

    private String fullName;
    private String id;
    private String phone;
    private String email;
    private String address;
    private LocalDate expiredDate;
    private String status;
    private String [] itemsBorrowed = new String[5];  /*id of items*/
    private String [] dueDayOfItem = new String[5];



    /**
     * @param fullName
     * @param id 
     * @param phone 
     * @param email 
     * @param address 
     * @param expiredDate
     * @param status
     */
    public Member(String fullName, String id, String phone, String email, String address, String expiredDate, String status, String item0, String item1, String item2,String item3,String item4) {
        this.fullName = fullName;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.expiredDate= LocalDate.parse(expiredDate);
        this.status = status;
        this.itemsBorrowed[0] = item0;
        this.itemsBorrowed[1] = item1;
        this.itemsBorrowed[2] = item2;
        this.itemsBorrowed[3] = item3;
        this.itemsBorrowed[4] = item4;

    }

    /**
     * return Borrowed Items without getting null character when member didn't borrow full 5 items
     * loop start at [1] because value[0] is a blank character " "
     */

    public String getItemsBorrowed() {
        String fullItemsBorrowed = "";
        for (int i = 0; i< 4; i++){
            if (itemsBorrowed[i] != "none"){
                fullItemsBorrowed += (itemsBorrowed[i] + ";");
            }
        }
        return fullItemsBorrowed;
    }

    /**
     * @return
     */
    public String toString() {
        return fullName +";"+id+";"+phone+";"+address+";"+expiredDate+";"+status+";"+getItemsBorrowed();
    }

    /**
     * a getId() Method for use in section "Update Member Info"
     */
    public String getId() {
        return id;
    }

    /**
     * @param fullName
     * @return
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param phone 
     * @return
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param email 
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param address 
     * @return
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param expiredDate
     * @return
     */
    public void setExpiredDate(String expiredDate) {
        this.expiredDate= LocalDate.parse(expiredDate);
    }

    /**
     * @param status 
     * @return
     */
    public void setStatus(String status) {
        this.status = status;
    }


    public void setItemsBorrowed(String itemsBorrowed, int index) {
        this.itemsBorrowed[index] = itemsBorrowed;
    }


}