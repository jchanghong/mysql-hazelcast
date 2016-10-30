package j.ch;

import com.hazelcast.config.Config;
import com.hazelcast.core.*;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class Main implements Logmy,ItemListener<String>{
    public static HazelcastInstance hazelcast = null;
    public static IList<String> list = null;
    static {
        Config config = new Config();
        hazelcast = Hazelcast.newHazelcastInstance(config);
        list = hazelcast.getList("list");
    }

    public Main() {
        list.addItemListener(this, true);
    }

    public static void main(String[] args) throws InterruptedException {
        Main me = new Main();
        list.add("hello");
        new File().upsql();


    }

    /**
     * Invoked when an item is added.
     *
     * @param item the added item
     */
    @Override
    public void itemAdded(ItemEvent<String> item) {
        log("itemadd " + item.getItem() + "from:" + item.getMember().toString());
        log(String.valueOf(item.getMember() == hazelcast.getCluster().getLocalMember()));
    }

    /**
     * Invoked when an item is removed.
     *
     * @param item the removed item.
     */
    @Override
    public void itemRemoved(ItemEvent<String> item) {
        log("itemadd " + item.getItem() + "from:" + item.getMember().toString());
    }
}

