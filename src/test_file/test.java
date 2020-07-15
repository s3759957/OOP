package test_file;

////package test_file;
////import javafx.application.Application;
////import javafx.scene.Scene;
////import javafx.scene.image.Image;
////import javafx.scene.image.ImageView;
////import javafx.scene.layout.GridPane;
////import javafx.stage.Stage;
////public class test extends Application
////{
////    @Override
////    public void start(Stage primaryStage)
////    {
////        GridPane pane = new GridPane();
////        Image img1 = new Image("test_file/test/61WA33Ou-BL._AC_SX466_.jpg");
////        Image img2 = new Image("test_file/test/quoc-ky-canada.jpg");
////        Image img3 = new Image("test_file/test/2000px-Flag_of_Vietnam.svg.png");
////        Image img4 = new Image("test_file/test/475px-Flag_of_the_United_States_(1820–1822).svg.png");
////        ImageView imgView1 = new ImageView(img1);
////        ImageView imgView2 = new ImageView(img2);
////        ImageView imgView3 = new ImageView(img3);
////        ImageView imgView4 = new ImageView(img4);
////        pane.add(imgView1, 1, 0);
////        pane.add(imgView2, 0, 1);
////        pane.add(imgView3, 1, 1);
////        pane.add(imgView4, 0, 0);
////        Scene scene = new Scene(pane);
////        primaryStage.setTitle("Nations Flag");
////        primaryStage.setScene(scene);
////        primaryStage.show();
////    }
////    public static void main(String[] args)
////    {
////        launch(args);
////    }
////}

import java.util.Arrays;

//class EarlyBindingSuper {
//    // An instance variable
//    public String str = "EarlyBindingSuper";
//    // A static variable
//    public static int count = 100;
//    void print() {
//        System.out.println("Inside EarlyBindingSuper.print()");
//    }
//}
//class EarlyBindingSub extends EarlyBindingSuper{
//    public String str = "EarlyBindingSub";
//    public static int count = 200;
//    @Override
//    void print() {
//        System.out.println("Inside EarlyBindingSub.print()");
//    }
//}
//public class test{
//    public static void main(String[] args) {
//        EarlyBindingSuper ebSuper = new EarlyBindingSuper();
//        EarlyBindingSub ebSub = new EarlyBindingSub();
//        System.out.println(ebSuper.str);
//        System.out.println(ebSuper.count);
//        ebSuper.print();
//        System.out.println(ebSub.str);
//        System.out.println(ebSub.count);
//        ebSub.print();
//        System.out.println(((EarlyBindingSuper)ebSub).str);
//        System.out.println(((EarlyBindingSuper)ebSub).count);
//        ((EarlyBindingSuper)ebSub).print();
//        ebSuper = ebSub;
//        System.out.println(ebSuper.str);
//        System.out.println(ebSuper.count);
//        ebSuper.print();
//    }
//}
//class Animal {
//
//    String name;
//
//    // A method to print the
//    // nature of the class
//    void nature()
//    {
//        System.out.println("Animal");
//    }
//}
//
//// A Fish class which extends the
//// animal class
//class Fish extends Animal {
//
//    String color;
//
//    // Overriding the method to
//    // print the nature of the class
//    @Override
//    void nature()
//    {
//        System.out.println("Aquatic Animal");
//    }
//}
//
//// Demo class to understand
//// the concept of upcasting
//public class test {
//
//    // Driver code
//    public static void main(String[] args)
//    {
//        // Creating an object to represent
//        // Parent p = new Child();
//        Animal a = new Fish();
//
//        // The object 'a' has access to
//        // only the parent's properties.
//        // That is, the colour property
//        // cannot be accessed from 'a'
//        a.name = "GoldFish";
//
//        // This statement throws
//        // a compile-time error
//        // a.color = "Orange";
//
//        // Creating an object to represent
//        // Child c = new Child();
//        Fish f = new Fish();
//
//        // The object 'f' has access to
//        // all the parent's properties
//        // along with the child's properties.
//        // That is, the colour property can
//        // also be accessed from 'f'
//        f.name = "Whale";
//        f.color = "Blue";
//
//        // Printing the 'a' properties
//        System.out.println("Object a");
//        System.out.println("Name: " + a.name);
//
//        // This statement will not work
//        // System.out.println("Fish1 Color" +a.color);
//
//        // Access to child class - overriden method
//        // using parent reference
//        a.nature();
//
//        // Printing the 'f' properties
//        System.out.println("Object f");
//        System.out.println("Name: " + f.name);
//        System.out.println("Color: " + f.color);
//        f.nature();
//    }
//}
class ComparablePerson implements Comparable<ComparablePerson> {
    private String firstName;
    private String lastName;

    public ComparablePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int compareTo(ComparablePerson anotherPerson) {
        int diff = getLastName().compareTo(anotherPerson.getLastName());
        if (diff == 0) {
            diff = getFirstName().compareTo(anotherPerson.getFirstName());
        }
        return diff;
    }
}
    public class test {
        public static void main(String[] args) {
            ComparablePerson[] persons = new
                    ComparablePerson[]{
                    new ComparablePerson("John",
                            "Jacobs"),
                    new ComparablePerson("Jeff",
                            "Jacobs"),
                    new ComparablePerson("Wally",
                            "Inman")};
            Arrays.sort(persons);
        }
    }

