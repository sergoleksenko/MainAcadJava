
/**
 * Created by Serg on 3/12/18.
 */
public class JavaProject {
    public static int i = 1;

    public static void main(String[] arg) {
        Utils.printEvenNumbers(1, 100);

        try {
            System.out.println("Exception handling in try/catch:");
            System.out.println(i / 0);
        }
        catch (Exception ex) {
            System.out.println("\tSorry. You tried " + i + " " + ex.getMessage());
        }

        GlobalVariable globalVariable = new GlobalVariable();
        globalVariable.setStr("Hello!");
        System.out.println("Your string from GlobalVariable class is \"" + globalVariable.getStr() + "\"");
    }
}
