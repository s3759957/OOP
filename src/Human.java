public class Human {
    String name;
    String gender;
    static int numOfHuman = 0;
    int num;
    Human(){
        numOfHuman ++;
    }
    static int getNumOfHuman() {
        return numOfHuman;
    }
}

