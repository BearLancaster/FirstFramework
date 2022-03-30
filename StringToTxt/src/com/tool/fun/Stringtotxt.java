package com.tool.fun;

import java.io.*;

public class Stringtotxt {

    public  int readFileNumber(String pathname) {
        int i=0;

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {


            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);
                i++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }

    public  String[] readFileLine(String pathname,int number) {

        String [] lines=new String[number];

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {

            String line;
            int i=0;



            while ((line = br.readLine()) != null) {


                line=line.substring(line.indexOf("[")+1,line.indexOf("]"));
                System.out.println(line);
                lines[i]=line;


                i++;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void writeFile(String[] datas,int num,String path) {
        try {
            File writeName = new File(path);
            writeName.createNewFile();
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                for(int i=0;i<num;i++)
                {
                    out.write(datas[i]+"\r\n");
                }

                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
