package asm_1.Model;

import java.time.LocalDate;

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
        penaltyRecord = 0;
    }

    private String fullName;
    private String id;
    private String phone;
    private String email;
    private String address;
    private LocalDate expiredDate;
    private String status;
    private String [] itemsBorrowed = new String[5];  /*id of items*/
    private String [] dueDateOfItem = new String[5];
    private double penaltyRecord;



    /**
     * @param fullName
     * @param id 
     * @param phone 
     * @param email 
     * @param address 
     * @param expiredDate
     * @param status
     * @param penaltyRecord
     */
    public Member(String fullName, String id, String phone, String email, String address, String expiredDate, String status, String item0, String dueDate0, String item1, String dueDate1, String item2, String dueDate2,String item3, String dueDate3,String item4, String dueDate4, double penaltyRecord) {
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
        this.dueDateOfItem[0] = dueDate0;
        this.dueDateOfItem[1] = dueDate1;
        this.dueDateOfItem[2] = dueDate2;
        this.dueDateOfItem[3] = dueDate3;
        this.dueDateOfItem[4] = dueDate4;
        this.penaltyRecord = penaltyRecord;

    }

    /**
     * return Borrowed Items an its due date displayed side to side
     */

    public String getLoanInfo() {
        String fullLoanInfo = "";
        for (int i = 0; i< 4; i++){
            if (itemsBorrowed[i] != "none"){
                fullLoanInfo += (itemsBorrowed[i] + ";" + dueDateOfItem[i] + ";");
            }
        }
        return fullLoanInfo;
    }


    /**
     * @return
     */
    public String toString() {
        return fullName +";"+id+";"+phone+";"+address+";"+expiredDate+";"+status+";"+getLoanInfo()+penaltyRecord;
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

    /**
     * @param penaltyRecord
     * @return
     */
    public void setPenaltyRecord(double penaltyRecord) {
        this.penaltyRecord = penaltyRecord;
    }

    public void setItemsBorrowed(String itemsBorrowed, int index) {
        this.itemsBorrowed[index] = itemsBorrowed;
    }

    public void setDueDateOfItem(String dueDateOfItem, int index) {
        this.dueDateOfItem[index] = dueDateOfItem;
    }


}