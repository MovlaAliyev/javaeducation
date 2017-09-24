
package genericlinkedstack;


public class GenericLinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;

        public Node() {
            item = null;
            next = null;
        }
        
        public Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        
        public boolean end(){
            return item == null 
                   &&
                   next == null;
        }
    }
    
    private Node<T> top = new Node<T>();
    
    public void push(T item){
        top = new Node<T>(item, top);
    }
    
    public T pop(){
        T result = top.item;
        if(!top.end())
            top = top.next;
        
        return result;
    }
    
    public static void main(String[] args) {
        GenericLinkedStack<String> list = new GenericLinkedStack<>();
        list.push("Test1");
        list.push("Test2");
        list.push("Test3");
        list.push("Test4");
        
        String s;
        
        while((s = list.pop()) != null)
            System.out.println(s);
    }
    
}
