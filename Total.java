public class Total{
    private double amount;
    private String status;
    
    public Total(double amount, String status){
        this.amount = amount;
        this.status = status;
    }
    
    public void setAll(double amount, String status){
        this.amount = amount;
        this.status = status;
    }
    
    public double getAmount(){return amount;}
    public String getStatus(){return status;}
    
    public String toString(){
        return "\nTotal : RM " + amount + "\nStatus Payment : " + status;
    }
}