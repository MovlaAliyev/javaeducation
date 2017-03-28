class Literals{

  public static void main(String[] args){
    //integer literals start

    // integer decimal
    int decVal = 2;
    System.out.println("Dec values: " + decVal);

    // integer octal
    int zero  = 0;
    int one   = 01;
    int six   = 06;
    int seven = 07;
    int eight = 010;
    int nine  = 011;
    System.out.println("Octal numbers: "      + zero  +
                        " " + one     + " "   + six   +
                        " " + seven   + " "   + eight +
                        " " + nine);
    // integer hex
    int a = 0x01;
    int b = 0X8abc;
    int c = 0xDead;

    System.out.println("Hex numbers: " + a + " " + b + " " + c);

    //integer literals end

    //binary literals start
    int binaryLiteral  = 0b11;   //3
    int binaryLiteral2 = 0b1000; //8
    int binaryLiteral3 = 0B1001; //9

    System.out.println("Binary numbers: " + binaryLiteral + " " + binaryLiteral2 +  " "
                                          + binaryLiteral3);

    //binary literals end

    //float-point literals start
    float h  = 100.343f;
    float i  = 100.343F;

    double j = 13231.4334D;
    double k = 43243.4334D;
    double l = 2013;
    double m = 24.5;

    //float-point literals ends

    //character literals start

    char charA = 'a';
    char charB = 'b';
    char charC = (char) 9000;
    char charD = (char) -20;
    char charE = '\'';
    char charF = '\"';

    //character literals end


  }

}
