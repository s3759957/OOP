package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * 
 */
public class Menu {

    /**
     * Default constructor
     */
    public Menu() {
        fileBook = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Books.txt");
        fileJournal = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Journals.txt");
        fileDvd = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\DVDs.txt");
        fileMember = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Members.txt");
    }

    protected File fileBook;
    protected File fileJournal;
    protected File fileDvd;
    protected File fileMember;

//    public Menu(File fileBook, File fileJournal, File fileDvd, File fileMember) {
//
//    }

    /**
     * @return
     */
    public void displayMenu() {
        // TODO implement here

    }

    /**
     * @return
     */
    public int getOption() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public void quit() {
        // TODO implement here

    }

    /**
     * main starts here
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        File fileBook = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Books.txt");
        File fileJournal = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Journals.txt");
        File fileDvd = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\DVDs.txt");
        File fileMember = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Members.txt");

        //to create object Item & Member
        Item item = new Item();
        MemberList memberList = new MemberList();

//        //Book
//
//        Scanner scannerBook = new Scanner(fileBook);
//        while (scannerBook.hasNext()) {
//            Book info = new Book(scannerBook.next(";"),scannerBook.next(";"),scannerBook.next(";"),scannerBook.next(";"),scannerBook.nextInt(),scannerBook.next(";"),scannerBook.next(";"),scannerBook.next(";"),scannerBook.nextLine());
//            item.books.add(info);
//        }
//
//        //Journals
//
//        Scanner scannerJournal = new Scanner(fileBook);
//
//        while (scannerJournal.hasNext()) {
//            Journal info = new Journal(scannerJournal.next(";"),scannerJournal.next(";"),scannerJournal.nextInt(),scannerJournal.next(";"),scannerJournal.next(";"),scannerJournal.next(";"),scannerJournal.nextLine());
//            item.journals.add(info);
//        }
//
//        //DVDs
//
//        Scanner scannerDvd = new Scanner(fileBook);
//
//        while (scannerDvd.hasNext()) {
//            Dvd info = new Dvd(scannerDvd.next(";"),scannerDvd.next(";"),scannerDvd.next(";"),scannerDvd.nextInt(),scannerDvd.next(";"),scannerDvd.next(";"),scannerDvd.nextLine());
//            item.dvds.add(info);
//        }
//
//        //Members
//
//        Scanner scannerMember = new Scanner(fileMember);
//
//        while (scannerMember.hasNext()) {
//            Member info = new Member(scannerMember.next(";"),scannerMember.next(";"),scannerMember.next(";"),scannerMember.next(";"),scannerMember.next(";"), new SimpleDateFormat("dd-mm-yyyy").parse(scannerMember.next(";")),scannerMember.nextLine());
//            memberList.members.add(info);
//        }
    }


}