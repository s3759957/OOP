package test_file;

public class Contact {
    String contactName, contactNumber, contactEmail, contactAddress;
    public Contact () {

    }
    public Contact (String contactName, String contactNumber, String contactEmail, String contactAddress) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.contactAddress = contactAddress;
    }

    public String getContactName () {
        return this.contactName;
    }
    public String getContactNumber () {
        return this.contactNumber;
    }
    public String getContactEmail () {
        return this.contactEmail;
    }
    public String getContactAddress () {
        return this.contactAddress;
    }

    public void setContactName (String contactName) {
        this.contactName = contactName;
    }
    public void setContactNumber (String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setContactEmail (String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public void setContactAddress (String contactAddress) {
        this.contactAddress = contactAddress;
    }

}
