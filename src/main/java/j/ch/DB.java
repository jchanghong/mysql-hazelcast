package j.ch;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by jiang on 2016/10/30 0030.
 */
public class DB implements Logmy{
    private static DB instanse;

    public static DB getInstance() {
        if (instanse == null) {
            instanse = new DB();
        }
        return instanse;
    }
    String url = "jdbc:mysql://localhost:3306/mysql?useSsl=false";
    String user = "root";
    String pass = "0000";

    Connection connection;
    private DB() {
        try {
//            File file = new File("info.txt");
//                Scanner s = new Scanner(new FileInputStream(file));
//                pass = s.nextLine().trim();
//                s.close();

            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void exesql(String sql) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {

                statement.execute(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new DB().exesql("show databases  #fromjdbc  #fromjdbc || 1477895804");
    }
}
