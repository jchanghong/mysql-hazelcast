package j.ch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class File implements  Logmy,Localfilesql.lister{

    public File() {

        Localfilesql.addliser(this);
    }
    public void upsql() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    List<String> sql=reader.lines().collect(Collectors.toList());
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    upsql1(sql);
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (true);
            }
        }).start();
    }

    private void upsql1(List<String> sql) {
        sql.forEach(aa -> Localfilesql.getInstance().add(aa));
    }

    public static void main(String[] args) throws InterruptedException {

        new File().upsql();
        String ff = "dddd  || 4444";
        Timesql timesql = new Timesql("dddddd || 555");
        Timesql timesql1 = new Timesql("dddddd || 555");
        System.out.println(timesql.equals(timesql1));
    }

    @Override
    public void onadd(String d) {
        Main.list.add(d);
//        log("onadd" + d);
    }
}
