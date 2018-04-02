
/**
 * Created by Serg on 3/15/18.
 */
public class Utils {
    public static void printEvenNumbers(int start, int count) {
        System.out.println("Even numbers from " + start + "to " + count + ":");
        for (int i = start; i <= count; i++) {
            if (i % 2 == 0) {
                System.out.print(i + "\t");
            }
        }
        System.out.println();
    }
}
