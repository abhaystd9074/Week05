package org.example.basic.Problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvFile {
    public static void main(String[] args) {
    try{
        String path="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\basic\\Problem1\\empdata.csv";
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
         String line;
         while((line = br.readLine()) != null){
             String []rows=line.split(",");
             for(String it:rows){
                 System.out.print(it+" ");
             }
             System.out.println();

         }
    }
    catch(IOException e){
        System.out.println(e.getMessage());
    }
    }
}
