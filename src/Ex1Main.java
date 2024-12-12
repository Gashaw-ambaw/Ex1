import java.util.ArrayList;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit" ,base = "";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                if (Ex1.isNumber(num1)) {
                    //Print that the number is ok
                    System.out.println("num1= "+ num1+ "  is number: true , value:"+ Ex1.number2Int(num1));
                    //Enter the second one

                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    if (Ex1.isNumber(num2)  && !num2.equals("quit")) {
                        //Print that the number is ok
                        System.out.println("num2= "+ num2+ "is number: true , value:"+ Ex1.number2Int(num2));
                        //Enter the second one
                        //num2 = sc.next();

                        System.out.println("Enter a base for output: (a number [2,16] ");
                        base = sc.next();
                        int sum=Ex1.number2Int(num1)+Ex1.number2Int(num2);
                        int multi=Ex1.number2Int(num1)*Ex1.number2Int(num2);
                        System.out.println(num1+" + "+num2+" = "+ sum );
                        System.out.println(num1+" * "+num2+" = "+ multi );


                        String[] marco = {num1,num2,String.valueOf(sum),String.valueOf(multi)};

                        int index=Ex1.maxIndex(marco);
                        System.out.println("Max number over ["+num1+","+num2+","+sum+","+multi+"] is: " + marco[index]);
                    } else {

                    }
                } else {
                }





            }
        }
        System.out.println("quiting now...");
    }
}
