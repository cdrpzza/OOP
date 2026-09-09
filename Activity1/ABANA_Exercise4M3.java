
package abana_exercisem3;
import java.util.Scanner;

public class ABANA_Exercise4M3 {
    public static void main(String[] args){
        double weight;
        double height;
        double bmi;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter weight in kilograms: ");
        weight = sc.nextDouble();
        
        System.out.print("Enter height in meters: ");
        height = sc.nextDouble();
        
        bmi = weight / (height * height);
        
        System.out.println("BMI: approximately " + bmi);
    }
}
