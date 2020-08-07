package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ItemList {
    protected ArrayList<Book> books;
    protected ArrayList<Journal> journals;
    protected ArrayList<Dvd> dvds;
    private File fileBook;
    private File fileJournal;
    private File fileDvd;

    /**
     * Default constructor
     */
    public ItemList() throws FileNotFoundException {
        books = new ArrayList<Book>();
        journals = new ArrayList<Journal>();
        dvds = new ArrayList<Dvd>();
        fileBook = new File("src\\asm_1\\Model\\Books.txt");
        fileJournal = new File("src\\asm_1\\Model\\Journals.txt");
        fileDvd = new File("src\\asm_1\\Model\\Dvds.txt");

        //Book

        Scanner scannerBook = new Scanner(fileBook);
        scannerBook.useDelimiter(";");
        while (scannerBook.hasNext()) {
            Book info = new Book(scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.next(), scannerBook.nextInt());
            books.add(info);

            //nextLine here to jump to the following line after one's done scanning
            scannerBook.nextLine();
        }

        //Journals

        Scanner scannerJournal = new Scanner(fileJournal);
        scannerJournal.useDelimiter(";");

        while (scannerJournal.hasNext()) {
            Journal info = new Journal(scannerJournal.next(), scannerJournal.next(), scannerJournal.next(), scannerJournal.next(), scannerJournal.next(), scannerJournal.next(), scannerJournal.next(), scannerJournal.next(), scannerJournal.nextInt());
            journals.add(info);

            //nextLine here to jump to the following line after one is done scanning
            scannerJournal.nextLine();
        }

        //DVDs

        Scanner scannerDvd = new Scanner(fileDvd);
        scannerDvd.useDelimiter(";");

        while (scannerDvd.hasNext()) {
            Dvd info = new Dvd(scannerDvd.next(), scannerDvd.next(), scannerDvd.next(), scannerDvd.next(), scannerDvd.next(), scannerDvd.next(), scannerDvd.next(), scannerDvd.next(), scannerDvd.nextInt());
            dvds.add(info);

            //nextLine here to jump to the following line after one is done scanning
            scannerDvd.nextLine();
        }
    }

    /**
     * to add new Item, user need to type in the type of that item and following by all its info
     */
    public void addItem(String information) {
        try {
            String[] info = information.split(";");
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
                for (int i = 0; i < books.size(); i++) {
                    //                the new item doesn't need to match the old item with ID and numberOfCopy - all same to books, journals and dvds
                    if (books.get(i).toString().matches(".*" + info[1] + ";" + info[2] + ";" + info[3] + ";" + info[4] + ";" + info[5] + ";" + info[6] + ";" + info[7] + ";" + info[8] + ".*")) {
                        books.get(i).setNumberOfCopy(books.get(i).getNumberOfCopy() + newBook.getNumberOfCopy());
                        System.out.println("Item exists. Automatically Updated the Current Item");
                        break;
                    }
                    if (i == books.size()) {
                        books.add(newBook);
                        break;
                    }
                }

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
                for (int i = 0; i < journals.size(); i++) {
                    if (journals.get(i).toString().matches(".*" + info[1] + ";" + info[2] + ";" + info[3] + ";" + info[4] + ";" + info[5] + ";" + info[6] + ".*")) {
                        journals.get(i).setNumberOfCopy(books.get(i).getNumberOfCopy() + newJournal.getNumberOfCopy());
                        break;
                    }
                    if (i == journals.size()) {
                        journals.add(newJournal);
                        break;
                    }
                }
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
                for (int i = 0; i < dvds.size(); i++) {
                    if (dvds.get(i).toString().matches(".*" + info[1] + ";" + info[2] + ";" + info[3] + ";" + info[4] + ";" + info[5] + ";" + info[6] + ".*")) {
                        dvds.get(i).setNumberOfCopy(books.get(i).getNumberOfCopy() + newDvd.getNumberOfCopy());
                        break;
                    }
                    if (i == dvds.size()) {
                        dvds.add(newDvd);
                        break;
                    }
                }
            } else {
                System.out.println("Error. Information is wrong !!!");
            }
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println("An error is has occurred. The error is: " + msg);
        }
    }

    /**
     *
     */
    public void updateItemInfo(String id, String newInformation) {
        try {
            if (id.matches("B.*")) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId().equals(id)) {
                        books.remove(i);
                        addItem(newInformation);
                        break;
                    }
                }
            } else if (id.matches("J.*")) {
                for (int i = 0; i < journals.size(); i++) {
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
            } else {
                System.out.println("Error. Information is wrong !!!");
            }
        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println("An error is has occurred. The error is: " + msg);
        }
    }


}

