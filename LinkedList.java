public class LinkedList{
    private Node firstNode;
    private Node lastNode;
    private Node currNode;
    private int size;
    
    public LinkedList(){
        firstNode = lastNode = currNode = null;
        size = 0;
    }
    
    public void insertAtFront(Object insertItem){
        if (isEmpty()){
            firstNode = lastNode = new Node(insertItem);
        }
        else{
            firstNode = new Node(insertItem, firstNode);
        }
    }
    
    public void insertAtBack(Object insertItem){
        if(isEmpty()){
            firstNode = lastNode = new Node(insertItem);
        }
        else{
            lastNode = lastNode.next = new Node(insertItem);
        }
    }
    
    public Object removeFromFront() throws EmptyListException{
        Object removeItem = null;
        
        if(isEmpty()){
            throw new EmptyListException();
        }
        removeItem = firstNode.data;
        
        if(firstNode.equals(lastNode)){
            firstNode = lastNode = null;
        }
        else{
            firstNode = firstNode.next;
        }
        return removeItem;
    }
    
    public Object removeFromBack() throws Exception{
        Object removeItem = null;
        
        if(isEmpty()){
            throw new EmptyListException();
        }
        removeItem = lastNode.data;
        
        if(firstNode.equals(lastNode)){
            firstNode = lastNode = null;
        }
        else{
            Node current = firstNode;
            while(current.next != lastNode){
                current = current.next;
            }
            lastNode = current;
            current.next = null;
        }
        return removeItem;
    }
    
    public Object removeFromSecond(){
        Object removeItem = null;
        
        if(isEmpty() || firstNode.next == null){
            removeItem = null;
        }
        else{
            Node current = firstNode.next;
            removeItem = current.data;
            if(firstNode.next != lastNode){
                firstNode.next = current.next;
                lastNode = current.next;
                current.next = null;
            }
        }
        return removeItem;
    }
    
    public boolean isEmpty(){return firstNode == null;}
    
    public Object getFirst(){
        if(isEmpty()){return null;}
        else{
            currNode = firstNode;
            return currNode.data;
        }
    }
    
    public Object getNext(){
        if(currNode != lastNode){
            currNode = currNode.next;
            return currNode.data;
        }
        else{return null;}
    }
    
    public int size(){
        Node temp = firstNode;
        int count = 0;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }
}