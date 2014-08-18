package utils;

/**
 * Created by Przemek Kwiecien on 2014-08-18.
 */
public class Wait {
    public static void waitMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
