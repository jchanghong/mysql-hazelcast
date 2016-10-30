package j.ch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class File implements  Logmy{

    public File() {

    }
    public void upsql() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test");
        log(inputStream.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        reader.lines().forEach(c -> Main.list.add(c));
    }

}
