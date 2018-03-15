/**
 * Created by Serg on 3/12/18.
 */
public class MainAcadJava {

    public static void main(String[] arg) {
        Calc calc = new Calc();

        System.out.println(calc.summ(Utils.getRandomInt(), Utils.getRandomInt()));
    }
}
