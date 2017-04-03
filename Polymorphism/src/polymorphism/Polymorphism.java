package polymorphism;


public class Polymorphism {

   
    public static void main(String[] args) {
       Salary s = new Salary("Movla Aliyev", "Azerbaijan Baku", 3, 2.400);
       Person p = new Salary("Fuad", "AZ Baku", 4, 3.000);
       
       System.out.println("Call mailCheck using Salary reference ");
       s.mailCheck();
       System.out.println("Call mailCheck using Employee reference ");
       p.mailCheck();
    }
    
}
