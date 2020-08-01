package asm_1.Model;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Transaction {
    public Transaction() {
        memberId = "none";
        itemId = "none";
        penaltyRecord = 0;
        status = null;
    }
    private String memberId;
    private String itemId;
    private LocalDate borrowDate;
    protected double penaltyRecord;
    private String status;

    // status: (Borrowing| Returned)

    public Transaction( String memberId, String itemId, String borrowDate, double penaltyRecord, String status) {
        this.memberId = memberId;
        this.itemId = itemId;
        this.borrowDate = LocalDate.parse(borrowDate);
        this.penaltyRecord = penaltyRecord;
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getItemId() {
        return itemId;
    }

    public LocalDate getborrowDate() {
        return borrowDate;
    }

    public double getPenaltyRecord() {
        return penaltyRecord;
    }

    public String getStatus() {
        return status;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setborrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setPenaltyRecord(double penaltyRecord) {
        this.penaltyRecord = penaltyRecord;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
