import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.sql.*;
import java.util.HashMap;

public class FirstOne {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "D:\\chromedriver_win32\\chromedriver.exe");

       HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);  // Download PDF files instead of automatically opening them in Chrome
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);



        WebDriver driver = new ChromeDriver(options);
       Tool tool=new Tool();
        Connection con=tool.linkDatabase();
        try {
            String  Query_SQL="select Path from books;";
            PreparedStatement prestmt = con.prepareStatement(Query_SQL);
            ResultSet rs=prestmt.executeQuery(Query_SQL);
           while (rs.next())
           {
              String url = rs.getString(1);

                  driver.get(url);
           }
          } catch (SQLException e) {
            e.printStackTrace();
        }




}




    public static void PDFDrive()
    {

        Tool tool=new Tool();
        System.setProperty("webdriver.chrome.driver",
                "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = " https://www.pdfdrive.com/";
        driver.get(url);
        tool.WaitTime(2);
        driver.findElement(By.xpath("//*[@id=\"categories\"]/div[1]/ul/li[16]/a")).click();
        tool.WaitTime(2);


        driver.findElement(By.xpath("//*[@id=\"categories subcategories\"]/div/ul/li[5]/a")).click();
        tool.WaitTime(2);
        int size=driver.findElements(By.xpath("/html/body/div[3]/div[1]/div[1]/div[6]/ul/li")).size();

        int pagesize=driver.findElements(By.xpath("/html/body/div[3]/div[1]/div[1]/div[8]/div/ul/li")).size();
        String value="1";
        if(pagesize!=0) {
            value = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[8]/div/ul/li[" + (pagesize - 1) + "]")).getText();
        }

        int t=0;
        for(int i=0;i<Integer.valueOf(value);i++)
        {
            tool.WaitTime(1);
            for(int j=1;j<=size;j++)
            {
                String []name={"Bookname","Path"};
                String []results=new String[2];


                if(!driver.findElements(By.xpath("/html/body/div[3]/div[1]/div[1]/div[6]/ul/li["+j+"]/div/div/div[2]/a/h2")).isEmpty()) {
                    String bookname = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[6]/ul/li[" + j + "]/div/div/div[2]/a/h2")).getText();
                    System.out.println(bookname);
                    results[0]=bookname;

                    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[6]/ul/li["+j+"]/div/div/div[2]/a")).click();
                    tool.WaitTime(2);
                    driver.findElement(By.xpath("//*[@id=\"download-button-link\"]")).click();

                    System.out.println(driver.findElements(By.xpath("//*[@id=\"alternatives\"]/div[1]")).isEmpty());
                    do{
                        tool.WaitTime(2);
                    } while(driver.findElements(By.xpath("//*[@id=\"alternatives\"]/div[1]")).isEmpty());
                    if(!driver.findElements(By.xpath("//*[@id=\"alternatives\"]/div[1]/a")).isEmpty()||!driver.findElements(By.xpath("//*[@id=\"alternatives\"]/div[1]/div/a")).isEmpty())
                    {
                        String path=new String();
                        if(!driver.findElements(By.xpath("//*[@id=\"alternatives\"]/div[1]/a")).isEmpty())
                        {
                            path=driver.findElement(By.xpath("//*[@id=\"alternatives\"]/div[1]/a")).getAttribute("href");
                        }
                        else
                        {
                            path=driver.findElement(By.xpath("//*[@id=\"alternatives\"]/div[1]/div/a")).getAttribute("href")+"\n";
                        }

                        System.out.println(path);
                        results[1]=path;


                    }
                    if(!tool.JudgeBookexsited(bookname))
                    {
                        tool.InsertResults(results,name);
                    }






                    driver.navigate().back();
                    tool.WaitTime(2);
                    driver.navigate().back();
                    tool.WaitTime(2);


                }
            }
            int button=driver.findElements(By.xpath("/html/body/div[3]/div[1]/div[1]/div[8]/div/ul/li")).size();


            if(button!=0) {
                driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[8]/div/ul/li[" + button + "]/a")).click();
            }

        }
        driver.quit();
    }

}
