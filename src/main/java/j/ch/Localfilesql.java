package j.ch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class Localfilesql {
    private static Localfilesql me;

   private Set<String> set = new HashSet<>();
    private Localfilesql() {
    }

    public static Localfilesql getInstance() {
        if (me == null) {
            me = new Localfilesql();
        }
        return me;
    }

     interface lister
    {
        void onadd(String d);
    }

    public  void add(String sql) {
     boolean b =set.add(sql);
        if (b) {
            for (lister ll : listers) {
                ll.onadd(sql);
            }
        }
    }

   private Set<lister> listers = new HashSet<>();
    public static void addliser(lister lister) {
        getInstance().listers.add(lister);
    }
}
