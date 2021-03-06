package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Item extends Menu{

    /**
     * Default constructor
     */
    public Item() throws FileNotFoundException {

        books = new ArrayList<Book>();
        journals = new ArrayList<Journal>();
        dvds = new ArrayList<Dvd>();

        fileBook = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Books.txt");
        fileJournal = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Journals.txt");
        fileDvd = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\DVDs.txt");

        //Book
        
        Scanner scannerBook = new Scanner(fileBook);
        scannerBook.useDelimiter(";");

        while (scannerBook.hasNext()) {
            Book info = new Book(scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.next(),scannerBook.nextInt());
            books.add(info);

            //nextLine here to jump to the following line after one's done scanning
            scannerBook.nextLine();
        }

        //Journals

        Scanner scannerJournal = new Scanner(fileJournal);
        scannerJournal.useDelimiter(";");
        
        while (scannerJournal.hasNext()) {
            Journal info = new Journal(scannerJournal.next(),scannerJournal.next(),scannerJournal.next(),scannerJournal.next(),scannerJournal.next(),scannerJournal.next(),scannerJournal.next(),scannerJournal.next(),scannerJournal.nextInt());
            journals.add(info);

            //nextLine here to jump to the following line after one is done scanning
            scannerJournal.nextLine();
        }

        //DVDs

        Scanner scannerDvd = new Scanner(fileDvd);
        scannerDvd.useDelimiter(";");
        
        while (scannerDvd.hasNext()) {
            Dvd info = new Dvd(scannerDvd.next(),scannerDvd.next(),scannerDvd.next(),scannerDvd.next(),scannerDvd.next(),scannerDvd.next(),scannerDvd.next(),scannerDvd.next(),scannerDvd.nextInt());
            dvds.add(info);

            //nextLine here to jump to the following line after one is done scanning
            scannerDvd.nextLine();
        }
    }



    protected ArrayList<Book> books;
    protected ArrayList<Journal> journals;
    protected ArrayList<Dvd> dvds;

    protected File fileBook;
    protected File fileJournal;
    protected File fileDvd;



//    public String getId() {
//        return id;
//    }

    /**
     * to search Items, keywords are turned into a regex
     * method matches() is to find the item that matches the regex
     */
    public void searchItems(String keywords) {
        String regex = ".*"+keywords+".*";
        //Heading of page
        System.out.println("***********************************************************************");

        for(Book elm:books) {
            if (elm.toString().matches(regex)) {
                System.out.println(elm.toString());
            }
        }
        for(Journal elm:journals) {
            if (elm.toString().matches(regex)) {
                System.out.println(elm.toString());
            }
        }
        for(Dvd elm:dvds) {
            if (elm.toString().matches(regex)) {
                System.out.println(elm.toString());
            }
        }
        //Footing of page
        System.out.println("***********************************************************************");

    }

    /**
     * to add new Item, user need to type in the type of that item and following by all its info
     */
    public void addItem(String information) throws FileNotFoundException {
        String [] info = information.split(";");
        if (info[0].matches("B.*")) {
            Book newBook = new Book();
            newBook.setId(info[0]);
            newBook.setTitle(info[1]);
            newBook.setAuthors(info[2]);
            newBook.setEdition(info[3]);
            newBook.setPublication(info[4]);
            newBook.setYear(info[5]);
            newBook.setIsbn(info[6]);
            newBook.setLanguage(info[7]);
            newBook.setSubject(info[8]);
            newBook.setStatus(info[9]);
            newBook.setNumberOfCopy(Integer.parseInt(info[10]));
            books.add(newBook);
        } else if (info[0].matches("J.*")) {
            Journal newJournal = new Journal();
            newJournal.setId(info[0]);
            newJournal.setTitle(info[1]);
            newJournal.setPublication(info[2]);
            newJournal.setYear(info[3]);
            newJournal.setIssn(info[4]);
            newJournal.setLanguage(info[5]);
            newJournal.setSubject(info[6]);
            newJournal.setStatus(info[7]);
            newJournal.setNumberOfCopy(Integer.parseInt(info[8]));
            journals.add(newJournal);
        } else if (info[0].matches("D.*")) {
            Dvd newDvd = new Dvd();
            newDvd.setId(info[0]);
            newDvd.setTitle(info[1]);
            newDvd.setAuthors(info[2]);
            newDvd.setPublication(info[3]);
            newDvd.setYear(info[4]);
            newDvd.setLanguage(info[5]);
            newDvd.setSubject(info[6]);
            newDvd.setStatus(info[7]);
            newDvd.setNumberOfCopy(Integer.parseInt(info[8]));
            dvds.add(newDvd);
        }
    }

    /**
     * 
     */
    public void updateItemInfo(String id, String newInformation) throws FileNotFoundException {

            if (id.matches("B.*")) {
                for (int i=0;i<books.size();i++){
                    if (books.get(i).getId().equals(id)) {
                        books.remove(i);
                        addItem(newInformation);
                        break;
                    }
                }
            } else if (id.matches("J.*")) {
                for (int i=0;i<journals.size();i++){
                    if (journals.get(i).getId().equals(id)) {
                        journals.remove(i);
                        addItem(newInformation);
                        break;
                    }
                }
            } else if (id.matches("D.*")) {
                for (int i = 0; i < dvds.size(); i++) {
                    if (dvds.get(i).getId().equals(id)) {
                        dvds.remove(i);
                        addItem(newInformation);
                        break;
                    }
                }
            }
    }


    /**
     *
     */
    public void borrowItems() {
        // TODO implement here
    }

    /**
     *
     */
    public void returnItems() {
        // TODO implement here
    }

    /**
     *
     */
    public void saveData() {
        // TODO implement here
    }

}

