package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 */
public class MemberList extends TransactionList{

    /**
     * Default constructor
     */
    public MemberList() throws FileNotFoundException {
        members = new ArrayList<Member>();

        //File Members
        File fileMember = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Members.txt");
        Scanner scannerMember = new Scanner(fileMember);
        scannerMember.useDelimiter(";");

        while (scannerMember.hasNext()) {
            Member info = new Member(scannerMember.next(),scannerMember.next(),scannerMember.next(),scannerMember.next(),scannerMember.next(),scannerMember.next(), scannerMember.next());
            members.add(info);
            //nextLine here to jump to the following line after one is done scanning
            scannerMember.nextLine();
        }
    }

    protected ArrayList<Member> members;



//    private void displayMember(ArrayList<String> array) {
//
//        String command = "n";
//        int count = 0;
//        Scanner scanner = new Scanner(System.in);
//
//        while (command.equals("q") == false){
//            //Heading of page
//            System.out.println("***********************************************************************");
//            for (int i = count; i < count + 10; i ++) {
//                if (i< array.size()) {
//                    System.out.println(array.get(i));
//                } else {
//                    System.out.println();
//                }
//            }
//            //Footing of page
//            System.out.println("***********************************************************************");
//            System.out.print("press 'n' to go to the next page, 'p' to go to the previous page, and 'q' for quit: ");
//            command = scanner.next();
//            if (command.equals("n")) {
////              one more if clause to check if array is out of bound
//                if (array.size()-count>10){count += 10;}
//            } else if (command.equals("p")) {
////              one more if clause to check if array is out of bound
//                if (count > 0) {count -= 10;}
//            } else if (command.equals("q")) {
//                break;
//            } else {
//                System.out.println("INVALID INPUT !!!");
//                break;
//            }
//        }
//
//    }


    public void searchMembers(String keywords) {
        String regex = ".*"+keywords+".*";
        ArrayList<String> array = new ArrayList<>();

        for(Member elm:members) {
            if (elm.toString().matches(regex)) {
                array.add(elm.toString());
            }
        }
        displaySearchedResults(array);
    }

    /**
     * information includes fullName, id, phone, email, address, expiredDate, status, itemsBorrowed
     * Borrowed Items don't get listed here as new members don't have a Borrowed Items Record
     */
    public void registerNewMember(String information) {
        String [] info = information.split(";");

            Member newMember = new Member();
            newMember.setFullName(info[0]);
            newMember.setId(info[1]);
            newMember.setPhone(info[2]);
            newMember.setEmail(info[3]);
            newMember.setAddress(info[4]);
            newMember.setExpiredDate(info[5]);
            newMember.setStatus(info[6]);
//            newMember.setItemsBorrowed(info[7],0);
//            newMember.setDueDateOfItem(info[8],0);
//            newMember.setItemsBorrowed(info[9],1);
//            newMember.setDueDateOfItem(info[10],1);
//            newMember.setItemsBorrowed(info[11],2);
//            newMember.setDueDateOfItem(info[12],2);
//            newMember.setItemsBorrowed(info[13],3);
//            newMember.setDueDateOfItem(info[14],3);
//            newMember.setItemsBorrowed(info[15],4);
//            newMember.setDueDateOfItem(info[16],4);
//            newMember.setPenaltyRecord(Double.parseDouble(info[17]));

        members.add(newMember);
    }


    public void updateMemberInfo(String id, String newInformation) {
        for (int i=0;i<members.size();i++){
            if (members.get(i).getId().equals(id)) {
                members.remove(i);
                registerNewMember(newInformation);
                break;
            }
        }
    }

}