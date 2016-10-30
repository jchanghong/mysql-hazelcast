package j.ch;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public interface Logmy {
    default void log(String s) {
        System.out.println(s);
    }
}
