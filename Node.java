public class Node{
    Object data;
    Node next;
    
    Node(Object o) {this(o, null);}
    
    Node(Object o, Node nextNode){
        data = o;
        next = nextNode;
    }
}