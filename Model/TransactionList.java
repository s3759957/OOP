package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionList {
    protected ArrayList<Transaction> transactions;
    private ItemList itemList;
    private MemberList memberList;
    private File fileTransaction;

    public TransactionList(ItemList itemList, MemberList memberList) throws FileNotFoundException {
        transactions = new ArrayList<>();
        this.itemList = itemList;
        this.memberList = memberList;
        //Automatically Load Transactions File Into Class
        fileTransaction = new File("src\\asm_1\\Model\\Transactions.txt");
        Scanner scannerTransaction = new Scanner(fileTransaction);
        scannerTransaction.useDelimiter(";");

        while (scannerTransaction.hasNext()) {
            Transaction info = new Transaction(scannerTransaction.next(), scannerTransaction.next(), scannerTransaction.next(), scannerTransaction.nextDouble(), scannerTransaction.next());
            transactions.add(info);
            //nextLine here to jump to the following line after one is done scanning
            scannerTransaction.nextLine();
        }
    }

    /**
     *
     */
    public void borrowItems(String memberId, String itemId) {
        int countItems = 0;
        int checkItem = 0;
//      To check if user insert right ID
        if (checkId(memberId,itemId) == true) {return;}
//      To check if the member borrowed fewer than 5 items
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getMemberId().equals(memberId) && transactions.get(i).getStatus() == "on loan") {
                countItems++;
            }
        }
        if (countItems >= 5) {
            System.out.println("Member has reached the limit of the number of items allowed (5 items). Cannot borrow more !!!");
        }
        if (updateItemStatus(itemId, -1) == true) {
            Transaction newTransaction = new Transaction(memberId, itemId, LocalDate.now().toString(), 0, "on loan");
            transactions.add(newTransaction);
            System.out.println("Transaction complete !!!");
        } else {
            System.out.println("Item is not available !!!");
        }

    }

    /**
     *
     */
    public void returnItems(String memberId, String itemId) {
        //      To check if user insert right ID
        if (checkId(memberId,itemId) == false) {
            System.out.println("Wrong ID info !!!");
            return;
        }
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getMemberId().equals(memberId)) {
                transactions.get(i).setStatus("Returned");
                long numberOfOverdueDays = ChronoUnit.DAYS.between(transactions.get(i).getBorrowDate(), LocalDate.now());

                if (transactions.get(i).getItemId().matches("B.*")) {
                    if (numberOfOverdueDays > 14) {
                        System.out.println("**************************************");
                        System.out.println("Member: " + transactions.get(i).getMemberId());
                        System.out.println("Overdue for: " + numberOfOverdueDays + " days");
                        System.out.println("Overdue Fee: " + numberOfOverdueDays * 0.1 + "$");
                        System.out.println("Total Penalty Record: " + transactions.get(i).getPenaltyRecord() + numberOfOverdueDays * 0.1 + " $");
                        System.out.println("**************************************");
                        transactions.get(i).setPenaltyRecord(transactions.get(i).getPenaltyRecord() + numberOfOverdueDays * 0.1);
                    }
                } else if (transactions.get(i).getItemId().matches("(D.*)|(J.*)")) {
                    if (numberOfOverdueDays > 7) {
                        System.out.println("**************************************");
                        System.out.println("Member: " + transactions.get(i).getMemberId());
                        System.out.println("Overdue for: " + numberOfOverdueDays + " days");
                        System.out.println("Overdue Fee: " + numberOfOverdueDays * 0.1 + "$");
                        System.out.println("Total Penalty Record: " + transactions.get(i).getPenaltyRecord() + numberOfOverdueDays * 0.1 + " $");
                        System.out.println("**************************************");
                        transactions.get(i).setPenaltyRecord(transactions.get(i).getPenaltyRecord() + numberOfOverdueDays * 0.1);
                    }
                }

            } else {
                System.out.println("No such member found!!");
                break;
            }
//          To update Item status
            updateItemStatus(itemId, +1);
            System.out.println("Transaction complete !!!");
        }
    }

    /**
     * To update numberOfCopy and Status of items in ItemLIst
     * Used in borrowItems() and returnItems()
     */
    public boolean updateItemStatus(String itemId, int newNumber) { /* newNumber = (1|-1)*/

        if (itemId.matches("B.*")) {        /* To update numberOfCopy and Status of items in ItemLIst*/
            for (int i = 0; i < itemList.books.size(); i++) {
                if (itemList.books.get(i).getId().equals(itemId)) {
                    if (itemList.books.get(i).getNumberOfCopy() == 0 && newNumber == -1) {
                        return false;
                    }
                    itemList.books.get(i).setNumberOfCopy(itemList.books.get(i).getNumberOfCopy() + newNumber);
                    if (itemList.books.get(i).getNumberOfCopy() <= 0) {
                        itemList.books.get(i).setStatus("on loan");
                    }
                    if (itemList.books.get(i).getNumberOfCopy() == 1 && newNumber == 1) {
                        itemList.books.get(i).setStatus("available");
                    }
                }
            }
            return true;
        } else if (itemId.matches("J.*")) {
            for (int i = 0; i < itemList.journals.size(); i++) {
                if (itemList.journals.get(i).getId().equals(itemId)) {
                    if (itemList.journals.get(i).getNumberOfCopy() == 0 && newNumber == -1) {
                        return false;
                    }
                    itemList.journals.get(i).setNumberOfCopy(itemList.journals.get(i).getNumberOfCopy() + newNumber);
                    if (itemList.journals.get(i).getNumberOfCopy() <= 0) {
                        itemList.journals.get(i).setStatus("on loan");
                    }
                    if (itemList.journals.get(i).getNumberOfCopy() == 1 && newNumber == 1) {
                        itemList.journals.get(i).setStatus("available");
                    }
                }
            }
            return true;
        } else if (itemId.matches("D.*")) {
            for (int i = 0; i < itemList.dvds.size(); i++) {
                if (itemList.dvds.get(i).getId().equals(itemId)) {
                    if (itemList.dvds.get(i).getNumberOfCopy() == 0 && newNumber == -1) {
                        return false;
                    }
                    itemList.dvds.get(i).setNumberOfCopy(itemList.dvds.get(i).getNumberOfCopy() + newNumber);
                    if (itemList.dvds.get(i).getNumberOfCopy() <= 0) {
                        itemList.dvds.get(i).setStatus("on loan");
                    }
                    if (itemList.dvds.get(i).getNumberOfCopy() == 1 && newNumber == 1) {
                        itemList.dvds.get(i).setStatus("available");
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     */
    public String getCurrentLoanInfo(String id) {
        String outcome = "Items currently on loan: ";
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getMemberId().equals(id) && transactions.get(i).getStatus().equals("on loan")) {
                outcome += transactions.get(i).getItemId() + ";";
            }
        }
        if (outcome.equals("Items currently on loan: ")) {
            outcome += "None";
        }
        return outcome;
    }

    /**
     *
     */
    public String getPenaltyRecord(String id) {
        String outcome = "Past Penalty Record: ";
        double record = 0;
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getMemberId().equals(id)) {
                record += transactions.get(i).getPenaltyRecord();
            }
        }
        outcome += record+";";
        return outcome;
    }
    /**
     *
     */
    public boolean checkId(String memberId, String itemId) {
        int answer = 0;
        for (int i = 0; i < memberList.members.size(); i++) {
            if (memberId.matches(memberList.members.get(i).getId())) {
                break;
            }
            if (i == memberList.members.size()) {
                System.out.println("No member ID found !!!");
                answer = 1;
            }
        }
        if (itemId.matches("B.*")) {
            for (int i = 0; i < itemList.books.size(); i++) {
                if (memberId.matches(itemList.books.get(i).getId())) {
                    break;
                }
                if (i == itemList.books.size()) {
                    System.out.println("No Item ID found !!!");
                    answer = 1;
                }
            }
        } else if (itemId.matches("J.*")) {
            for (int i = 0; i < itemList.journals.size(); i++) {
                if (memberId.matches(itemList.journals.get(i).getId())) {
                    break;
                }
                if (i == itemList.journals.size()) {
                    System.out.println("No item ID found !!!");
                    answer = 1;
                }
            }
        } else if (itemId.matches("D.*")) {
            for (int i = 0; i < itemList.dvds.size(); i++) {
                if (memberId.matches(itemList.dvds.get(i).getId())) {
                    break;
                }
                if (i == itemList.dvds.size()) {
                    System.out.println("No item ID found !!!");
                    answer = 1;
                }
            }
        } else {
            System.out.println("No item ID found !!!");
            answer = 1;
        }
        if (answer == 1) {
            return false;
        } else{
            return true;
        }
    }
}



