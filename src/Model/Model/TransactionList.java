package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionList {
    public TransactionList() throws FileNotFoundException {
        transactions = new ArrayList<>();

        //Transactions File 
        File fileTransaction = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Transactions.txt");
        Scanner scannerTransaction = new Scanner(fileTransaction);
        scannerTransaction.useDelimiter(";");

        while (scannerTransaction.hasNext()) {
            Transaction info = new Transaction(scannerTransaction.next(),scannerTransaction.next(),scannerTransaction.next(),scannerTransaction.nextDouble(),scannerTransaction.next());
            transactions.add(info);
            //nextLine here to jump to the following line after one is done scanning
            scannerTransaction.nextLine();
        }
    }
    ArrayList<Transaction> transactions;

    /**
     *
     */
    public void borrowItems(String memberId, String itemId) {
        int countItems = 0;
        for (int i =0; i < transactions.size(); i ++){
            if (transactions.get(i).getMemberId().equals(memberId) && transactions.get(i).getStatus() == "Borrowing") {
                countItems ++;
            }
        }
        if (countItems == 5) {
            System.out.println("Member has reached the limit of the number of items allowed (5 items ). Cannot borrow more !!!");
        }
        Transaction newTransaction = new Transaction(memberId,itemId, LocalDate.now().toString(),0, "Borrowing");
        transactions.add(newTransaction);
    }

    /**
     *
     */
    public void returnItems(String memberId, String itemId) {
        for (int i = 0; i < transactions.size(); i++){
            if (transactions.get(i).getMemberId() == memberId) {
                transactions.get(i).setStatus("Returned");
                long numberOfOverdueDays = ChronoUnit.DAYS.between(transactions.get(i).getborrowDate(),LocalDate.now());

                if (transactions.get(i).getItemId().matches("B.*")) {
                    if (numberOfOverdueDays > 14) {
                        System.out.println("***********************************************************************");
                        System.out.println("Member: " + transactions.get(i).getMemberId());
                        System.out.println("Overdue for: "+numberOfOverdueDays+" days");
                        System.out.println("Overdue Fee: " + numberOfOverdueDays*0.1 + "$");
                        System.out.println("Total Penalty Record: "+transactions.get(i).getPenaltyRecord() + numberOfOverdueDays* 0.1+" $");
                        System.out.println("***********************************************************************");
                        transactions.get(i).setPenaltyRecord(transactions.get(i).getPenaltyRecord() + numberOfOverdueDays* 0.1);
                    }
                } else if (transactions.get(i).getItemId().matches("(D.*)|(J.*)")) {
                    System.out.println("***********************************************************************");
                    System.out.println("Member: " + transactions.get(i).getMemberId());
                    System.out.println("Overdue for: "+numberOfOverdueDays+" days");
                    System.out.println("Overdue Fee: " + numberOfOverdueDays*0.1 + "$");
                    System.out.println("Total Penalty Record: "+transactions.get(i).getPenaltyRecord() + numberOfOverdueDays* 0.1+" $");
                    System.out.println("***********************************************************************");
                    transactions.get(i).setPenaltyRecord(transactions.get(i).getPenaltyRecord() + numberOfOverdueDays* 0.1);
                }
                break;
            }
        }

    }
}
