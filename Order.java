public class Order{
    private String custName;
    private String custPhone;
    private String custAdd;
    private String foodName;
    private int foodQtty;
    private String foodSize;
    private double foodPrice;
    private String foodCtgry;
    private Date expireDate;
    private double amount;
    private String status;
    
    public Order(String custName, String custPhone, String custAdd, String foodName, int foodQtty, String foodSize, double foodPrice, 
    String foodCtgry, int day, int month, int year, double amount, String status){
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAdd = custAdd;
        this.foodName = foodName;
        this.foodQtty = foodQtty;
        this.foodSize = foodSize;
        this.foodPrice = foodPrice;
        this.foodCtgry = foodCtgry;
        expireDate = new Date (day, month, year);
        this.amount = amount;
        this.status = status;
    }
    
    public void setAll(String custName, String custPhone, String custAdd, String foodName, int foodQtty, String foodSize, double foodPrice, 
    String foodCtgry, int day, int month, int year, double amount, String status){
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAdd = custAdd;
        this.foodName = foodName;
        this.foodQtty = foodQtty;
        this.foodSize = foodSize;
        this.foodPrice = foodPrice;
        this.foodCtgry = foodCtgry;
        expireDate = new Date (day, month, year);
        this.amount = amount;
        this.status = status;
    }

    public String getCustName(){return custName;}
    public String getCustPhone(){return custPhone;}
    public String getCustAdd(){return custAdd;}
    public String getFoodName(){return foodName;}
    public int getFoodQtty(){return foodQtty;}
    public String getFoodSize(){return foodSize;}
    public double getFoodPrice(){return foodPrice;} 
    public String getFoodCtgry(){return foodCtgry;}
    public int getDay_ExpireDate(){return expireDate.getDay();}
    public int getMonth_ExpireDate(){return expireDate.getMonth();}
    public int getYear_ExpireDate(){return expireDate.getYear();}
    public double getAmount(){return amount;}
    public String getStatus(){return status;}
    
    public String toString(){
        return String.format ("|%-15s|%-16s|%-23s|%-18s|%-15s|%-13s|%-13s|%-14s|%-13s|%-13s|%-15s|",custName ,custPhone, custAdd, foodName, foodQtty, foodSize,
        foodPrice, foodCtgry, expireDate.toString(), amount, status);
    }
}