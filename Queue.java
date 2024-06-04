import java.util.*;

public class Queue{
    protected LinkedList list;
    
    public Queue(){
        list = new LinkedList();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int size(){
        return list.size();
    }
    
    public void enqueue(Object element){
        list.insertAtBack(element);
    }
    
    public Object dequeue(){
        return list.removeFromFront();
    }
    
    public Object front(){
        return list.getFirst();
    }
}