//import statements involve of input stream io package
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class ReadFile{
    public static void main(String[]args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name : ");
        String name = scanner.next();
        
        //Define and create File object
        File file = new File(name);
        //Exception Handler
        
        try{
            //define and create read file bufferedReader from FileReader
            FileReader ma = new FileReader(file);
            BufferedReader in = new BufferedReader(ma);
            
            //process involve in reading File using method readLine
            String s;
            s = in.readLine();
            
            while(s != null){
                System.out.println("Read : " +s);
                s = in.readLine();
            }
            
            //close the File Reader class Buffereader and FileReader
            in.close();
        }
        catch(FileNotFoundException e1){
            System.err.println("File not found : " + file);
        }
        catch(IOException e2){
            e2.printStackTrace();
        }

    }
    
}

