package org.example.intermediate.Problem5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        try{
            String path="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\basic\\Problem1\\empdata.csv";
            String target="Michael Brown";
            System.out.println("target employee is: "+ target);
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null){
                String []rows=s.split(",");

              if(rows[1].equals(target))
                System.out.println(rows[0] + " " + rows[1] + " " + rows[2]+" "+rows[3]);
                }


        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
