package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath() ;
        System.out.println(courseFile);
        int linecount=0;
        //String relativelyPath=System.getProperty("user.dir");
//String file=vars.get("file");
        /*File infile= new File(courseFile+"\\Case_Test.cxv"));
        String line= "";
        BufferedReader reader=new BufferedReader(new FileReader(infile));
        while ((line = reader.readLine()) != null) {
            linecount++;
        }
        System.out.println(linecount);*/


    }
}
