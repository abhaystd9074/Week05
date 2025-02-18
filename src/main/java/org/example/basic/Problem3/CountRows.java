package org.example.basic.Problem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        try{
            String path="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\basic\\Problem1\\empdata.csv";
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s; int count=0;
            while((s=br.readLine())!=null){
                String []rows=s.split(",");
                for(String it:rows){
                    System.out.print(it);
                }
                System.out.println();
                count++;
            }
            count--;
            System.out.println("ther are total "+ count +" lines ");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
