import java.lang.*;
import java.util.ArrayList;
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
import java.util.Iterator;

public class TestQueue{
    public static void main(String [] args) throws Exception, IOException{
        try{
            BufferedReader inFile = new BufferedReader(new FileReader("sample.txt"));
            PrintWriter outFile = new PrintWriter (new FileWriter ("outputQ.txt"));
            String data = null;
            Scanner scan = new Scanner (System.in);
            
            Queue orderQ = new Queue();
            Queue temp = new Queue();
            Queue tempQ = new Queue();
            Queue unpaid = new Queue();
            Queue paid = new Queue();
            Queue tempUnpaid = new Queue();
            Queue m = new Queue();
            Queue fruit = new Queue();
            Queue veg = new Queue();
            Queue search = new Queue();
            Queue searchTemp = new Queue();
            
            while ((data = inFile.readLine()) != null){
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
                
                orderQ.enqueue(order);
            }
            
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            outFile.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    
            while(!orderQ.isEmpty()){
                Order o = (Order) orderQ.dequeue();
                tempQ.enqueue(o);
                temp.enqueue(o);
                outFile.println(o);
                    
                if(o.getFoodCtgry().equalsIgnoreCase("Meat")){
                    m.enqueue(o);
                }
                else if(o.getFoodCtgry().equalsIgnoreCase("Fruits")){
                    fruit.enqueue(o);
                }
                else if(o.getFoodCtgry().equalsIgnoreCase("Vegetables")){
                    veg.enqueue(o);
                }
            }
            
            Order o = null;
            
            /**To remove the customers that haven't paid from list*/
            //Removing unpaid customer from list
            while(!tempQ.isEmpty()){
                o = (Order) tempQ.dequeue();
                
                if(o.getStatus().equalsIgnoreCase("Paid")){
                    paid.enqueue(o);
                }
                else{
                    unpaid.enqueue(o);
                }
                orderQ.enqueue(o);
            }
            //Display paid customers
            outFile.println("\n=====================================================================================================================================================================================");
            outFile.println("List of customers that have paid");
            outFile.println("=====================================================================================================================================================================================");
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            outFile.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            while(!paid.isEmpty()){
                o = (Order) paid.dequeue();
                outFile.println(o);
            }
            //Display the removed customers
            outFile.println("\n=====================================================================================================================================================================================");
            outFile.println("List of customers that havent paid (Removed)");
            outFile.println("====================================================================================================================================================================================");
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            outFile.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
             while(!unpaid.isEmpty()){
                o = (Order) unpaid.dequeue();
                tempUnpaid.enqueue(o);
                
                outFile.println(o);
            }
            
            /**To count the total order for each category*/
            outFile.println("\n=============================================");
            outFile.println("\tTotal of each category");
            outFile.println("==============================================");
            outFile.println("Meat : " + m.size());
            outFile.println("Fruits : " + fruit.size());
            outFile.println("Vegetables : " + veg.size());
            
            /**To search customers details*/
            boolean found = false;
            String curr = null;
            System.out.println("Enter customer name : ");
            String name = scan.next();
            while(!orderQ.isEmpty()){
                o = (Order) orderQ.dequeue();
                if(o.getCustName().equalsIgnoreCase(name)){
                    found = true;
                    search.enqueue(o);
                }
                tempQ.enqueue(o);
            }
            while(!search.isEmpty()){
                o = (Order) search.dequeue();
                if(found){
                    System.out.println(o);
                    curr = o.getStatus();
                }
                searchTemp.enqueue(o);
            }
            if(!found){
                System.out.println("Invalid Customer Name!!");
            }
            
            /**To update payment status*/
            outFile.println("\n=====================================================================================================================================================================================");
            outFile.println("Updated list");
            outFile.println("=====================================================================================================================================================================================");
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            outFile.println(String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",
            "Customer Name", "Customer Phone", "Customer Address", "Food Name", "Food Quantity", 
            "Food Size", "Food Price", "Food Category", "Expire Date", "Amount(RM)", "Payment Status"));
            outFile.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(found){
                System.out.println("Current payment status : " + curr);
                System.out.println("Do you want to update payment status [Y - YES || N - NO]");
                char update = scan.next().charAt(0);
                String payUpdate = null;
                
                if(update == 'Y' || update == 'y'){
                    System.out.println("Current payment status : " + curr);
                    System.out.println("Enter updated payment status : ");
                    payUpdate = scan.next();
                    
                    while(!searchTemp.isEmpty()){
                        o = (Order) searchTemp.dequeue();
                        outFile.println(o);
                        outFile.println("\nUpdated Payment Status : " + payUpdate);
                    }
                }
                else{
                    outFile.println("The list is Empty!!");
                }
            }
            
            /**To calculate the total amount for each customer*/
            outFile.println("\n=============================================");
            outFile.println("Total for each customer");
            outFile.println("=============================================");
            while(!temp.isEmpty()){
                o = (Order) temp.dequeue();
                orderQ.enqueue(o);
                
                double t = o.getAmount();
                String cn = o.getCustName();
                
                for(int i=0; i<temp.size(); i++){
                    Order currOrder = (Order) temp.dequeue();
                    if(currOrder.getCustName().equalsIgnoreCase(cn)){
                        t += currOrder.getAmount();
                    }
                    else{
                        temp.enqueue(currOrder);
                    }
                }
                outFile.println(o.getCustName() + " : " + t);
            }
            
            outFile.close();
            inFile.close();
        }             
                       
        catch(FileNotFoundException ex){
            System.out.println("File Not Found");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
