class VariableScope{

  static int count = 20; // static variable
  String s;              // instance variable
  int i;                 // instance variable


  {
    s = "initalization block";
    int block = 250;
  }

  // constructor
  public VariableScope(){
    System.out.println(s);
    i += 10;
    int j = 100;
  }

  int coolMethod(){
    int k = 25; //local variable

    for(int t = 0; t < 10; t++)
      k += k + t;

    return k;
  }

  public static void main(String[] args){
    VariableScope vs = new VariableScope();

    System.out.println("cool method result: "   + vs.coolMethod());
    System.out.print("method1 method result: ");
    VariableScope.method1();

  }

  static void method1(){
    int y = 10;
    System.out.println(y);
  }


}
