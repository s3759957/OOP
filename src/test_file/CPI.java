package test_file;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CPI
{
    static Scanner input = new Scanner (System.in);
    static Scanner fileScanner;
    static File sourceFile = new File ("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\contact.txt");
    static String contactName;
    static String contactNumber;
    static String contactEmail;
    static String contactAddress;
    static BufferedReader br;
    static String line;

    public static void main (String[] args) throws IOException
    {
       do {
           displayMenu();
           String userInput = input.nextLine();
           try {
               Integer.parseInt(userInput);
           } catch (Exception e) {
               System.out.println("Invalid input!");
               continue;
           }
           if (Integer.parseInt(userInput) <= 0 || Integer.parseInt(userInput) > 9)
           {
               System.out.println("Invalid input!");
               continue;
           }
           switch ( Integer.parseInt(userInput))
           {
               case 1 : loadContactsFromFile();
               case 2 : loadContactsFromFile();
               case 3 : addANewContact();
               case 4 : editAContact();
               case 6 : searchContact();
               case 9 : { System.out.println("Goodbye!");
                           System.exit(1);
                         }
           }
       } while (true);

    }

    private static void displayMenu ()
    {
        System.out.println("1. Load contacts from file." +
                "\n2. View all contacts." +
                "\n3. Add a new contact." +
                "\n4. Edit a contact." +
                "\n5. Delete a contact." +
                "\n6. Search contact list." +
                "\n7. Sort contact list." +
                "\n8. Save contact to file." +
                "\n9. Quit" +
                "\nSelect a function (1-9): ");
    }
    private static void loadContactsFromFile()
    {
            try {
                Scanner myReader = new Scanner(sourceFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Cannot read file!");
            }
    }

    private static void addANewContact() throws IOException
    {
      Contact newContact = new Contact (askContactName(), askContactNumber(), askContactEmail(), askContactAddress());
      writeToFile(newContact);
    }
    private static void writeToFile (Contact newContact) throws IOException
    {
        FileWriter fileWriter = new FileWriter(sourceFile, true);
        PrintWriter output = new PrintWriter(fileWriter);
        output.println(newContact.toString());
        output.close();
    }

    private static String askContactName()
    {
        System.out.println("Enter contact name: ");
        contactName = input.nextLine();
        String name_pattern = "^[[a-z-A-Z]{1,}[\\s]]+$";

        while (!Pattern.matches(name_pattern, contactName))
        {
            System.out.println("Invalid contact name!");
            System.out.println("Enter contact name: ");
            contactName = input.nextLine();
        }
        return contactName;
    }

    private static String askContactNumber ()
    {
        System.out.println("Enter contact number: ");
        contactNumber = input.nextLine();

        String numberPattern = "^\\d{10,13}$";
        while (!Pattern.matches(numberPattern, contactNumber))
        {
            System.out.println("Invalid contact number!");
            System.out.println("Enter contact number: ");
            contactNumber = input.nextLine();
        }
        while (Contained(contactNumber))
        {
            System.out.println("This contact is duplicated!");
            System.out.println("Enter contact number: ");
            contactNumber = input.nextLine();
        }
        return contactNumber;
    }

    private static String askContactEmail ()
    {
        System.out.println("Enter contact email: ");
        contactEmail = input.nextLine();

        String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        while (!Pattern.matches(emailPattern, contactEmail))
        {
            System.out.println("Invalid contact email!");
            System.out.println("Enter contact email: ");
            contactEmail = input.nextLine();
        }
        return contactEmail;
    }
    private static String askContactAddress ()
    {
        System.out.println("Enter contact address:");
        contactAddress = input.nextLine();

        String numberPatter = "^\\d{1,3}[\\s][[a-z-A-Z]{1,}[\\s]]+[\\,][\\s][[\\w]+[\\s]]+[\\,][\\s][[a-z-A-Z]{1,}[\\s]]+$";
        while (!Pattern.matches(numberPatter, contactAddress))
        {
            System.out.println("Invalid contact address!");
            System.out.println("Enter contact address ");
            contactAddress = input.nextLine();
        }
        return contactAddress;
    }

    private static void editAContact ()
    {

    }

    public static void searchContact () throws FileNotFoundException {
        contactName = askContactName();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) { // open file foobar.txt
            while ((line = br.readLine()) != null) { //read file line by line in a loop
                if (line.toLowerCase().contains(contactName.toLowerCase())) // check if line contain that word then prints the line
                    System.out.println(line);
                else
                    System.out.println("Cannot find that contact!");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean Contained(String searchString)
    {
        try {
            File file = new File("/Users/macbook/Desktop/OOP/Assignment/src/Contact.txt");
            Scanner scanner = new Scanner(file).useDelimiter(";");

            while (scanner.hasNext())
            {
                 line = scanner.nextLine();
                if (line.toLowerCase().contains(searchString.toLowerCase()))
                {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(" cannot write to file ");
        }
        return false;
    }
}
