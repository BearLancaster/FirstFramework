import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.*;

public class Tool {






    public void WaitTime(int time)
    {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public Connection linkDatabase()
    {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/ben_test_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String USER="Ben";
        String PASS="129301Zl";
        String SQL="";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean JudgeBookexsited(String result)
    {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/ben_test_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String USER="Ben";
        String PASS="129301Zl";
        String SQL="";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();

            String Query_SQL="select count(1) from books where Bookname=\""+result+"\";";
            PreparedStatement prestmt=conn.prepareStatement(Query_SQL);
            ResultSet rs=prestmt.executeQuery(Query_SQL);
            int value=0;
            while(rs.next())
            {
                value=rs.getInt(1);
            }
            conn.close();
            if(value>0)
            {return true;}
            else
            {return false;}



        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }


    }

    public void InsertResult(String result,String name)
    {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/ben_test_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String USER="Ben";
        String PASS="129301Zl";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();

            String insert_SQL="insert into books("+name+") values (\""+result+"\")";
            PreparedStatement prestmt=conn.prepareStatement(insert_SQL);
            prestmt.execute(insert_SQL);
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void InsertResults(String[] result, String[] name)
    {

        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/ben_test_database?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String USER="Ben";
        String PASS="129301Zl";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            String Insert_SQL_F="insert into books(";
            String Insert_SQL_S=") values (";
            String Insert_SQL_T=")";
            for(int i=0;i<result.length;i++)
            {
                if(i==result.length-1)
                {
                    Insert_SQL_F+=name[i];
                    Insert_SQL_S+="\""+result[i]+"\"";
                }
                else
                {
                    Insert_SQL_F+=name[i]+",";
                    Insert_SQL_S+="\""+result[i]+"\""+",";
                }


            }
            String insert_SQL=Insert_SQL_F+Insert_SQL_S+Insert_SQL_T;

            PreparedStatement prestmt=conn.prepareStatement(insert_SQL);
            prestmt.execute();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
