package polymorphism;


public class Person {
    private String name;
    private String address;
    private int    number;

    public Person(String name, String address, int number) {
        System.out.println("Info about person");
        this.name    = name;
        this.address = address;
        this.number  = number;
    }
    
    public void mailCheck(){
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }
    
    public String toString(){
        return name + " " + address + " " + number;
    }
    
    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }
}
