package org.example.intermediate.Problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try{
            String path="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\intermediate\\Problem4\\studentdata.csv";
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s; int count=0;
            while((s=br.readLine())!=null){
                String []rows=s.split(",");
                if(count==0) {
                    System.out.println(rows[0] + " " + rows[1] + " " + rows[2]);
                    count++;
                }
                  else{
                    int a = Integer.parseInt(rows[2]);
                    if (a > 80) {
                        System.out.println(rows[0] + " " + rows[1] + " " + rows[2]);
                    }
                }

            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
