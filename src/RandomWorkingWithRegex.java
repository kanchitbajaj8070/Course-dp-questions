import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RandomWorkingWithRegex {
    public static void main(String[] args) {
       /*
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String words = s.next();
            boolean b=Pattern.matches("[-*+/]",words);
            if(b)
            {
                System.out.println(words);
            }
            else
            {
                System.out.println(words+"this is a operand");
            }
*/
       String a="*";
        System.out.println(Pattern.matches("[/*+-]",a));
        }
    }

