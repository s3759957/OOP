package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.FieldPosition;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class Menu {
    private ItemList itemList;
    private MemberList memberList;
    private TransactionList transactionList;
    /**
     *
     */
    public Menu() throws FileNotFoundException {
        itemList = new ItemList();
        memberList = new MemberList();
        transactionList = new TransactionList(itemList,memberList);
    }

    public Menu(ItemList itemList, MemberList memberList, TransactionList transactionList) {
        this.itemList = itemList;
        this.memberList = memberList;
        this.transactionList = transactionList;
    }


    public void searchWithKeywords(String keywords, Object object) {
        String regex = ".*"+keywords+".*";
        ArrayList<String> array;
        if (object instanceof MemberList) {
            array = new ArrayList<>();
            for (Member elm : memberList.members) {
                if (elm.toString().matches(regex)) {
                    array.add(elm.toString()+transactionList.getPenaltyRecord(elm.getId())+transactionList.getCurrentLoanInfo(elm.getId()));
                }
            }
            if (array.isEmpty()) {
                System.out.println("No match found !!!");
            } else {
                displaySearchedResults(array);
            }
        } else if (object instanceof ItemList) {
            array = new ArrayList<>();
            for (Book elm : itemList.books) {
                if (elm.toString().matches(regex)) {
                    array.add(elm.toString());
                }
            }
            for (Journal elm : itemList.journals) {
                if (elm.toString().matches(regex)) {
                    array.add(elm.toString());
                }
            }
            for (Dvd elm : itemList.dvds) {
                if (elm.toString().matches(regex)) {
                    array.add(elm.toString());
                }
            }
            if (array.isEmpty()) {
                System.out.println();
                System.out.println("NO match found !!!");
                System.out.println();
            } else {
                displaySearchedResults(array);
            }
        }
    }

    /**
     * displaySearchedResults method created to display searched items for MemberList and ItemList
     * to avoid duplication
     */
    public void displaySearchedResults(ArrayList<String> array) {

        String command = "n";
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (command.equals("q") == false){
            //Heading of page
            System.out.println("**************************************");
            for (int i = count; i < count + 10; i ++) {
                if (i< array.size()) {
                    System.out.println(array.get(i));
                } else {
                    System.out.println();
                }
            }
            //Footing of page
            System.out.println("**************************************");
            System.out.print("press 'n' to go to the next page, 'p' to go to the previous page, and 'q' for quit: ");
            command = scanner.next();
            if (command.equals("n")) {
//              one more if clause to check if array is out of bound
                if (array.size()-count>10){count += 10;}
                else {count = 0;}
            } else if (command.equals("p")) {
//              one more if clause to check if array is out of bound
                if (count > 0) {count -= 10;}
                else if (array.size()%10==0){count = 10*(array.size()/10)-10;}
                else {count = 10*(array.size()/10);}
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
    public void saveData(String file, Object object) throws FileNotFoundException {
        File newFile = new File(file);
        PrintWriter printWriter = new PrintWriter(newFile);
        if (object instanceof Book) {
            for (int i = 0; i < itemList.books.size(); i++) {
                printWriter.write(itemList.books.get(i).toString() + "\n");
            }
        } else if (object instanceof Journal) {
            for (int i = 0; i < itemList.journals.size(); i++) {
                printWriter.write(itemList.journals.get(i).toString() + "\n");
            }
        } else if (object instanceof Dvd) {
            for (int i = 0; i < itemList.dvds.size(); i ++) {
                printWriter.write(itemList.dvds.get(i).toString() + "\n");
            }
        } else if (object instanceof Member) {
            for (int i = 0; i < memberList.members.size(); i++) {
                printWriter.write(memberList.members.get(i).toString() + "\n");
            }
        } else if (object instanceof Transaction) {
            for (int i = 0; i < transactionList.transactions.size(); i++) {
                printWriter.write(transactionList.transactions.get(i).toString() + "\n");
            }
        }
        printWriter.close();
    }

    /**
     * @return
     */
    public void displayMenu() {
        System.out.println("Welcome to QuickLib!!!");
        System.out.println("**************************************");
        System.out.println("1. Search items by keywords");
        System.out.println("2. Add new item");
        System.out.println("3. Update item info");
        System.out.println("4. Search members by keywords");
        System.out.println("5. Register new member");
        System.out.println("6. Update member info");
        System.out.println("7. Borrow items");
        System.out.println("8. Return items");
        System.out.println("9. Save data");
        System.out.println("10. Quit");
        System.out.println("**************************************");
        System.out.print("Enter a function (1-10):");

    }

    /**
     *
     */
    public void getOption(int option) throws FileNotFoundException {
        Scanner scannerOption = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Insert keyword: ");
                String input = scannerOption.nextLine();
                searchWithKeywords(input, itemList);
                break;
            case 2:
                System.out.print("Insert information: ");
                input = scannerOption.nextLine();
                itemList.addItem(input);
                break;
            case 3:
                System.out.print("Insert ID: ");
                String input1 = scannerOption.nextLine();
                System.out.print("Insert new information: ");
                input = scannerOption.nextLine();
                itemList.updateItemInfo(input1, input);
                break;
            case 4:
                System.out.print("Insert keyword: ");
                input = scannerOption.nextLine();
                searchWithKeywords(input, memberList);
                break;
            case 5:
                System.out.print("Insert information: ");
                input = scannerOption.nextLine();
                memberList.registerNewMember(input);
                break;
            case 6:
                System.out.print("Insert ID: ");
                input1 = scannerOption.nextLine();
                System.out.print("Insert new information: ");
                input = scannerOption.nextLine();
                memberList.updateMemberInfo(input1, input);
                break;
            case 7:
                System.out.print("Insert ID of member who borrows: ");
                input1 = scannerOption.nextLine();
                System.out.print("Insert ID of item to borrow: ");
                input = scannerOption.nextLine();
                transactionList.borrowItems(input1, input);
                break;
            case 8:
                System.out.print("Insert ID of member who returns: ");
                input1 = scannerOption.nextLine();
                System.out.print("Insert ID of item to returns: ");
                input = scannerOption.nextLine();
                transactionList.returnItems(input1, input);
                break;
            case 9:
                saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Books.txt", itemList.books.get(0));
                saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Journals.txt", itemList.journals.get(0));
                saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Dvds.txt", itemList.dvds.get(0));
                saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Members.txt", memberList.members.get(0));
                saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Transactions.txt", transactionList.transactions.get(0));
                System.out.println("Saved !!!");
                break;
            case 10:
                System.out.println("Au Revoir !!! (Good-Bye in French) ");
                quit();
        }
    }

    /**
     *
     */
    public void quit() throws FileNotFoundException {
        saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Books.txt", itemList.books.get(0));
        saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Journals.txt", itemList.journals.get(0));
        saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Dvds.txt", itemList.dvds.get(0));
        saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Members.txt", memberList.members.get(0));
        saveData("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Transactions.txt", transactionList.transactions.get(0));
        System.exit(1);
    }

    /**
     * main starts here
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        //to create object Item & Member
        Menu menu = new Menu();
        int input = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.displayMenu();
            input = scanner.nextInt();
            menu.getOption(input);
        }

    }
}