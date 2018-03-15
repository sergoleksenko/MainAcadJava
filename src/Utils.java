import java.util.Random;

/**
 * Created by Serg on 3/15/18.
 */
public class Utils {

    private static final int MIN = 0;
    private static final int MAX = 100;

    public static int getRandomInt() {
        return new Random().nextInt((MAX - MIN) + 1);
    }
}
