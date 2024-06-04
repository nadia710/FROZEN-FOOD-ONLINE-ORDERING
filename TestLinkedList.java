import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class TestLinkedList{
    public static void main (String [] args) throws IOException {
        try{
            BufferedReader input = new BufferedReader(new FileReader ("sample.txt"));
            PrintWriter output = new PrintWriter(new FileWriter ("output.txt"));
            String data = null;
            Scanner scan = new Scanner(System.in);
            
            LinkedList orders = new LinkedList();
            LinkedList unpaid = new LinkedList();
            LinkedList paid = new LinkedList();
            LinkedList search = new LinkedList();
            
            while((data = input.readLine()) != null){
                StringTokenizer input1 = new StringTokenizer(data, ",");
                String custName = input1.nextToken();
                String custPhone = input1.nextToken();
                String custAdd = input1.nextToken();
                String foodName = input1.nextToken();
                int foodQtty = Integer.parseInt(input1.nextToken());
                String foodSize = input1.nextToken();
                double foodPrice = Double.parseDouble(input1.nextToken());
                String foodCtgry = input1.nextToken();
                int day = Integer.parseInt(input1.nextToken());
                int month = Integer.parseInt(input1.nextToken());
                int year = Integer.parseInt(input1.nextToken());
                double amount = Double.parseDouble(input1.nextToken());
                String status = input1.nextToken();
                
                Order order = new Order(custName, custPhone, custAdd, foodName, foodQtty, foodSize, foodPrice, foodCtgry, day, month, year, amount, status);
                
                orders.insertAtBack(order);
            }
            Order o = null;
            
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            output.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            o = (Order) orders.getFirst();
            while(o != null){
                output.println(o.toString());
                o = (Order) orders.getNext();
            }
            
            /**To remove the customers that haven't paid from list*/
            //Removing unpaid customer from list
            o = (Order) orders.getFirst();
            while(o != null){
                if(o.getStatus().equalsIgnoreCase("Paid")){
                    paid.insertAtBack(o);
                }
                else{
                    unpaid.insertAtBack(o);
                }
                o = (Order) orders.getNext();
            }
            //Display the paid customer
            output.println("\n====================================================================================================================================================================================");
            output.println("List of customers that have paid");
            output.println("=====================================================================================================================================================================================");
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            output.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            o = (Order) paid.getFirst();
            while(o != null){
                output.println(o.toString());
                o = (Order) paid.getNext();
            }
            //Display the unpaid customer
            output.println("\n====================================================================================================================================================================================");
            output.println("List of customers that havent paid(Removed)");
            output.println("=====================================================================================================================================================================================");
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            output.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            o = (Order) unpaid.getFirst();
            while(o != null){
               output.println(o.toString());
                o = (Order) unpaid.getNext();
            }
            
            /**To count the total order for each category*/
            int countM = 0;
            int countF = 0;
            int countV = 0;
            output.println("\n=============================================");
            output.println("\tTotal of each category");
            output.println("==============================================");
            o = (Order) orders.getFirst();
            while(o != null){
                if(o.getFoodCtgry().equalsIgnoreCase("Meat")){
                    countM++;
                }
                else if(o.getFoodCtgry().equalsIgnoreCase("Fruits")){
                    countF++;
                }
                else{
                    countV++;
                }
                o = (Order) orders.getNext();
            }
            
            output.println("\nMeat : " + countM);
            output.println("Fruits : " + countF);
            output.println("Vegetables : " + countV);
            
            /**To search customers details*/
            boolean found = false;
            String curr = null;
            Order obj = null;
            System.out.println("Enter customer name : ");
            String name = scan.next();
            o = (Order) orders.getFirst();
            while(o != null){
                if(o.getCustName().equalsIgnoreCase(name)){
                    found = true;
                    search.insertAtBack(o);
                }
                o = (Order) orders.getNext();
            }
            if(!found){
                System.out.println("Invalid Customer Name");
            }
            
            o = (Order) search.getFirst();
            while(o != null){
                System.out.println(o.toString());
                curr = o.getStatus();
                
                o = (Order) search.getNext();
            }

            /**To update payment status*/
            output.println("\n=====================================================================================================================================================================================");
            output.println("Updated list");
            output.println("=====================================================================================================================================================================================");
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            output.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            output.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    
            if(found){
                System.out.println("Current payment status : " + curr);
                System.out.println("\nDo you want to update payment status [Y - YES || N -NO]");
                char update = scan.next().charAt(0);
                String payUpdate = null;
                if(update == 'Y' || update == 'y'){
                    System.out.println("Enter updated payment status : ");
                    payUpdate = scan.next();
            
                    o = (Order) search.getFirst();
                    while(o != null){
                        output.println(o.toString());
                        output.println("\nUpdated Payment Status : " + payUpdate);
                        
                        o = (Order) search.getNext();
                    }
                }
                else{
                    output.println("This list is empty!!");
                }
            }
            
            /**To calculate the total amount for each customer*/
            output.println("\n=============================================");
            output.println("Total for each customer");
            output.println("=============================================");
            o = (Order) orders.getFirst();
            while(o != null){
                double t = 0.00;
                String cn = o.getCustName();
                
                while(o != null && o.getCustName().equalsIgnoreCase(cn)){
                    t += o.getAmount();
                    o = (Order) orders.getNext();
                }
                output.println(cn + " : " + t);
            }
            
            input.close();
            output.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("File Not Found");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}