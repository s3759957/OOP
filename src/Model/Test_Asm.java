package asm_1.Model_lastest;

import java.io.FileNotFoundException;

public class Test_Asm {
    public static void main(String[] args) throws FileNotFoundException {
        MemberList model = new MemberList();
        model.registerNewMember("Tuyet Ngan;3759954;0367001111;s3759954@rmit.edu.vn;20 Cancun;2021-02-10;active;NOne;ef;ed;sd;ge;");
        model.searchMembers("Ngan");
        Item item = new Item();
        item.addItem("B3;Arthur adwd;d efwe;3th;Scotland;2004;879-5645-545-45;French;History;available;1;");
        item.searchItems("History");
        item.updateItemInfo("B2","B3;Arthur adwd;d efwe;3th;Scotland;2004;879-5645-545-45;French;History;available;1;");
        item.searchItems("History");
    }
}
