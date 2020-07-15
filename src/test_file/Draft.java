//package asm_1;
//
//import javax.lang.model.element.AnnotationValue;
//import java.io.*;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
//public class Draft {
//    static Scanner input = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//       addANewContact();
//    }
//    private static void addANewContact() throws IOException
//        {
//        Contact newContact = new Contact (askContactName(), askContactNumber(), askContactEmail(), askContactAddress());
//        System.out.println(newContact);
//    }
//
//    private static String askContactName()
//    {
//        System.out.println("Enter contact name: ");
//        String contactName = input.nextLine();
//        checkContactName(contactName);
//        return contactName;
//    }
//    private static String askContactNumber ()
//    {
//        System.out.println("Enter contact number: ");
//        String contactNumber = input.nextLine();
//        checkContactNumber(contactNumber);
//        return contactNumber;
//    }
//
//
//    private static String askContactEmail ()
//    {
//        System.out.println("Enter contact email: ");
//        String contactEmail = input.nextLine();
//        checkContactEmail(contactEmail);
//        return contactEmail;
//    }
//    private static String askContactAddress ()
//    {
//        System.out.println("Enter contact address:");
//        String contactAddress = input.nextLine();
//        checkContactAddress(contactAddress);
//        return contactAddress;
//    }
//
//    private static void checkContactName (String contactName)
//    {
//        String name_pattern = "^[[a-z-A-Z]{1,}[\\s]]+$";
//        while (!Pattern.matches(name_pattern, contactName))
//        {
//            System.out.println("Invalid contact name!");
//            System.out.println("Enter contact name: ");
//            contactName = input.nextLine();
//        }
//    }
//    private static void checkContactNumber (String contactNumber)
//    {
//        String numberPattern = "^\\d{10,13}$";
//        while (!Pattern.matches(numberPattern, contactNumber))
//        {
//            System.out.println("Invalid contact number!");
//            System.out.println("Enter contact number: ");
//            contactNumber = input.nextLine();
//        }
//        while (Contained(contactNumber))
//        {
//            System.out.println("This contact is duplicated!");
//            System.out.println("Enter contact number: ");
//            contactNumber = input.nextLine();
//        }
//    }
//
//    private static void checkContactEmail (String contactEmail)
//    {
//        String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
//        while (!Pattern.matches(emailPattern, contactEmail))
//        {
//            System.out.println("Invalid contact email!");
//            System.out.println("Enter contact email: ");
//            contactEmail = input.nextLine();
//        }
//
//    }
//
//    private static void checkContactAddress (String contactAddress)
//    {
//        String numberPatter = "^\\d{1,3}[\\s][[a-z-A-Z]{1,}[\\s]]+[\\,][\\s][[\\w]+[\\s]]+[\\,][\\s][[a-z-A-Z]{1,}[\\s]]+$";
//        while (!Pattern.matches(numberPatter, contactAddress))
//        {
//            System.out.println("Invalid contact address!");
//            System.out.println("Enter contact address ");
//            contactAddress = input.nextLine();
//        }
//    }
//
//    private static boolean Contained(String searchString)
//    {
//        try {
//            File file = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\contact.txt");
//            Scanner scanner = new Scanner(file).useDelimiter(";");
//
//            while (scanner.hasNext())
//            {
//                final String lineFromFile = scanner.nextLine();
//                if (lineFromFile.toLowerCase().contains(searchString.toLowerCase()))
//                {
//                    return true;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(" cannot write to file ");
//        }
//        return false;
//    }
//}