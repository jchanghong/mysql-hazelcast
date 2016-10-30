package j.ch;

import com.hazelcast.config.Config;
import com.hazelcast.core.*;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class Main implements Logmy{
    public static void main(String[] args) {
        Main me = new Main();
        Config config = new Config();

        HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance(config);
        IList list = hazelcast.getList("list");
        ItemListener lis11=new ItemListener() {
            @Override
            public void itemAdded(ItemEvent item) {
                me.log("itemadd "+item.getItem()+"from:"+item.getMember().toString());
                me.log(String.valueOf(item.getMember()==hazelcast.getCluster().getLocalMember()));
            }

            @Override
            public void itemRemoved(ItemEvent item) {
                me.log("itemadd "+item.getItem()+"from:"+item.getMember().toString());
            }
        };
        list.addItemListener(lis11, true);
        list.add("hello");


    }
}

