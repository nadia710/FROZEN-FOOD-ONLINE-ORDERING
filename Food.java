public class Food{
    private String foodName;
    private int foodQtty;
    private String foodSize;
    private double foodPrice;
    private String foodCtgry;
    //private double foodTot;
    private Date expireDate;
    private char order;
    
    public Food(String foodName, int foodQtty, String foodSize, double foodPrice, String foodCtgry, /*double foodTot*/ int day, int month, int year, char order){
        this.foodName = foodName;
        this.foodQtty = foodQtty;
        this.foodSize = foodSize;
        this.foodPrice = foodPrice;
        this.foodCtgry = foodCtgry;
        //this.foodTot = foodTot;
        expireDate = new Date (day, month, year);
        this.order = order;
    }
    
    public void setAll(String foodName, int foodQtty, String foodSize, double foodPrice, String foodCtgry, /*double foodTot,*/ int day, int month, int year, char order){
        this.foodName = foodName;
        this.foodQtty = foodQtty;
        this.foodSize = foodSize;
        this.foodPrice = foodPrice;
        this.foodCtgry = foodCtgry;
        //this.foodTot = foodTot;
        expireDate.setDate(day, month, year);
        this.order = order;
    }
    
    public String getFoodName(){return foodName;}
    public int getFoodQtty(){return foodQtty;}
    public String getFoodSize(){return foodSize;}
    public double getFoodPrice(){return foodPrice;}
    public String getFoodCtgry(){return foodCtgry;}
    //public double getFoodTot(){return foodTot;}
    public int getDay_ExpireDate(){return expireDate.getDay();}
    public int getMonth_ExpireDate(){return expireDate.getMonth();}
    public int getYear_ExpireDate(){return expireDate.getYear();}
    public char getOrder(){return order;}
    
    public String toString(){
        return "\nFood Name : " + foodName + "\nFood Quantity : " + foodQtty + "\nFood Size : " + foodSize + "\nFood Price : RM " + foodPrice + "\nFood Category : " + foodCtgry /*+ "\nTotal : RM " + foodTot*/ + "\nExpire Date : " + expireDate.toString() + "\nOrder : " + order;
    }
}