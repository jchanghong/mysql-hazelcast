package j.ch;

import com.hazelcast.config.Config;
import com.hazelcast.core.*;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.MapListener;

import javax.swing.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class Main implements Logmy,EntryAddedListener<String,String>{
    public static HazelcastInstance hazelcast = null;
    public static IMap<String,String> list = null;
    static {
//        File file = new File("info.txt");
//        if (!file.exists()) {
//            JOptionPane.showMessageDialog(null, "建立info.txt文件。设置root的密码");
//            System.exit(0);
//        }
        Config config = new Config();
        hazelcast = Hazelcast.newHazelcastInstance(config);
        list = hazelcast.getMap("map");
    }

    public Main() {
        list.addEntryListener(this, true);
    }

    public static void main(String[] args) throws InterruptedException {

         new Main();
        JOptionPane.showMessageDialog(null, "启动完成");
    }

    @Override
    public void entryAdded(EntryEvent<String, String> event) {

            String ip= event.getMember().getAddress().toString();
      String local= hazelcast.getCluster().getLocalMember().getAddress().toString();
        if (ip.equals(local)) {
            return;
        }
        String sql = event.getValue();
        if (sql.contains("fromjdbc")) {
            log("sql jdbc exit");
            return;
        }
        DB.getInstance().exesql(sql+"  # fromjdbc \n");
        log(ip+sql);

    }
}

