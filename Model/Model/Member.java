package asm_1.Model;

import java.time.LocalDate;

/**
 * 
 */
public class Member {
    private String fullName;
    private String id;
    private String phone;
    private String email;
    private String address;
    private LocalDate expiredDate;
    private String status;

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

    /**
     * @param fullName
     * @param id 
     * @param phone 
     * @param email 
     * @param address 
     * @param expiredDate
     * @param status

     */
    public Member(String fullName, String id, String phone, String email, String address, String expiredDate, String status) {
        this.fullName = fullName;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.expiredDate= LocalDate.parse(expiredDate);
        this.status = status;
    }


    /**
     * @return
     */
    public String toString() {
        return fullName +";"+id+";"+phone+";"+email+";"+address+";"+expiredDate+";"+status+";";
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


}