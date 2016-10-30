package j.ch;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class Timesql implements Logmy {
    long aLong;
    String sql;
    public Timesql(String sql) {
        String[] strings = sql.split("\\s+\\|\\|\\s+");
        aLong = Long.valueOf(strings[1]);
        this.sql = strings[0];
    }

    @Override
    public String toString() {
        return sql+aLong;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Timesql)) {
            return false;
        }
        return ((Timesql) obj).aLong == aLong && sql.equals(((Timesql) obj).sql);
    }
}
