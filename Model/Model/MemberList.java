package asm_1.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 */
public class MemberList {
    protected ArrayList<Member> members;
    private File fileMember;

    /**
     * Default constructor
     */
    public MemberList() throws FileNotFoundException {
        members = new ArrayList<Member>();

        //File Members
        fileMember = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Members.txt");
        Scanner scannerMember = new Scanner(fileMember);
        scannerMember.useDelimiter(";");

        while (scannerMember.hasNext()) {
            Member info = new Member(scannerMember.next(),scannerMember.next(),scannerMember.next(),scannerMember.next(),scannerMember.next(),scannerMember.next(), scannerMember.next());
            members.add(info);
            //nextLine here to jump to the following line after one is done scanning
            scannerMember.nextLine();
        }
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