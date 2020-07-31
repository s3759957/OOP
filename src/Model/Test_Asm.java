package asm_1.Model;

import java.io.FileNotFoundException;

public class Test_Asm {
    public static void main(String[] args) throws FileNotFoundException {
        MemberList model = new MemberList();
        model.registerNewMember("Tuyet Ngan;3759954;0367001111;s3759954@rmit.edu.vn;20 Cancun;2021-02-10;active;NOne;ef;ed;sd;ge;");
        model.searchMembers("Ngan");
        Item item = new Item();
//        item.searchItems("History");
    }
}
