package customexception;

public class InheritingExceptions {
    public void f() throws CustomException{
        System.out.println("Throw CustomException from f()");
        throw new CustomException();
    }
    
    public static void main(String[] args) {
        InheritingExceptions ie = new InheritingExceptions();
        try{
            ie.f();
        }catch(CustomException e){
            e.printStackTrace();
        }
    }
}
