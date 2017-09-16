package dotthis;


public class DotThis {
    
    void f(){System.out.println("DotThis.f()");}
    public class Inner{
        public DotThis outter(){
            return DotThis.this;
        }
    }
    
    private Inner inner(){return new Inner();}
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dtio = new DotThis().new Inner();
        
        
        DotThis.Inner dti = dt.inner();
        dti.outter().f();
    }
    
}
