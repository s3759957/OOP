package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionList {
    ArrayList<Transaction> transactions;

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


    /**
     * displaySearchedResults method created to display searched items for MemberList and ItemList
     * to avoid duplication
     */
    protected void displaySearchedResults(ArrayList<String> array) {

        String command = "n";
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (command.equals("q") == false){
            //Heading of page
            System.out.println("***********************************************************************");
            for (int i = count; i < count + 10; i ++) {
                if (i< array.size()) {
                    System.out.println(array.get(i));
                } else {
                    System.out.println();
                }
            }
            //Footing of page
            System.out.println("***********************************************************************");
            System.out.print("press 'n' to go to the next page, 'p' to go to the previous page, and 'q' for quit: ");
            command = scanner.next();
            if (command.equals("n")) {
//              one more if clause to check if array is out of bound
                if (array.size()-count>10){count += 10;}
            } else if (command.equals("p")) {
//              one more if clause to check if array is out of bound
                if (count > 0) {count -= 10;}
            } else if (command.equals("q")) {
                break;
            } else {
                System.out.println("INVALID INPUT !!!");
                break;
            }
        }

    }

    /**
     *
     */
    public void borrowItems(String memberId, String itemId) {
        int countItems = 0;
        for (int i =0; i < transactions.size(); i ++){
            if (transactions.get(i).getMemberId().equals(memberId) && transactions.get(i).getStatus() == "on loan") {
                countItems ++;
            }
        }
        if (countItems == 5) {
            System.out.println("Member has reached the limit of the number of items allowed (5 items ). Cannot borrow more !!!");
        }
        Transaction newTransaction = new Transaction(memberId,itemId, LocalDate.now().toString(),0, "on loan");
        transactions.add(newTransaction);
    }

    /**
     *
     */
    public void returnItems(String memberId, String itemId) {
        for (int i = 0; i < transactions.size(); i++){
            if (transactions.get(i).getMemberId() == memberId) {
                transactions.get(i).setStatus("Returned");
                long numberOfOverdueDays = ChronoUnit.DAYS.between(transactions.get(i).getBorrowDate(),LocalDate.now());

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
                    if (numberOfOverdueDays > 7) {
                        System.out.println("***********************************************************************");
                        System.out.println("Member: " + transactions.get(i).getMemberId());
                        System.out.println("Overdue for: " + numberOfOverdueDays + " days");
                        System.out.println("Overdue Fee: " + numberOfOverdueDays * 0.1 + "$");
                        System.out.println("Total Penalty Record: " + transactions.get(i).getPenaltyRecord() + numberOfOverdueDays * 0.1 + " $");
                        System.out.println("***********************************************************************");
                        transactions.get(i).setPenaltyRecord(transactions.get(i).getPenaltyRecord() + numberOfOverdueDays * 0.1);
                    }
                }
                break;
            }
        }

    }
}
