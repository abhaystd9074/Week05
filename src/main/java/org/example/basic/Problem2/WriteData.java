package org.example.basic.Problem2;


import java.io.BufferedWriter;
import java.io.FileWriter;


public class WriteData {
    public static void main(String[] args) {
        try{
            String path="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\basic\\Problem2\\input.csv";
            FileWriter fr=new FileWriter(path);
            BufferedWriter br=new BufferedWriter(fr);
            br.write("ID,Name,Department,Salary\n");
            br.write("104,Abhay Gautam,Finance,62000\n");
            br.write("105,Tikesh Kardate,Sales,58000\n");
            br.write("105,Tikesh Kardate,Sales,58000\n");
            br.write("105,Tikesh Kardate,Sales,58000\n");
            br.write("105,Tikesh Kardate,Sales,58000\n");
            System.out.println("data added successfully: ");
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}



