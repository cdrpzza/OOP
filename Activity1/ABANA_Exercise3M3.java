
package abana_exercisem3;
import java.util.Scanner;

public class ABANA_Exercise3M3 {
    public static void main(String[] args){
    double celsius;
    double fahrenheit;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter temperature in celsius: ");
    celsius = sc.nextDouble();
    
    fahrenheit = (celsius * 9.0/5.0) + 32;
    
    System.out.println("Fahrenheit: " + fahrenheit);
    }
}
