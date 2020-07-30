import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, FileNotFoundException {
////        String str1 = "Book";
////        String str2 = ".*shit";
////        String str3 = ".*";
////        System.out.println(str1);
////        System.out.println(str1.matches(str2+str3));
//        String str = "Shit";
//        Class obj = Class.forName(str);
////        Shit obj = new Shit();
////        System.out.println(obj.getName());
//        Method m = obj.getMethod("takeOne",obj);

        LocalDate c1 = LocalDate.now();
        String pat = "dd-MM-yyyy";
        String c2 = c1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(c2.toString());
        LocalDate v1 = LocalDate.parse("01-01-2020", DateTimeFormatter.ofPattern(pat));
        System.out.println(v1.toString());
        LocalDate c3 = LocalDate.of(2020,7,2);
        System.out.println(ChronoUnit.DAYS.between(c3,c1));

        String [] str = new String[4];
        str[0]="er ";
        str[1]="oir ";
        str[2]="est ";
        System.out.println(str[0]+str[1]+str[2]+str[3]);
        File file = new File("C:\\Users\\User\\IdeaProjects\\Java Project\\src\\asm_1\\Model\\Journals.txt");
        Scanner in = new Scanner(file);
        in.useDelimiter(";");
        String pattern = "[0-9]*";
        while (in.hasNext()) {
            String line = in.nextLine();
            System.out.println(line);
        }
    }
    }
