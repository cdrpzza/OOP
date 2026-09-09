

package abana_exercisem3;
import java.util.Scanner;

public class ABANA_Exercise1M3 {
    public static void main(String[] args) {
        double hours_worked;
        double hourly_rate;
        double gross_salary;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter hours worked: ");
        hours_worked = sc.nextDouble();
        
        System.out.print("Enter hourly rate: ");
        hourly_rate = sc.nextDouble();
        
        gross_salary = hours_worked * hourly_rate;
        
        System.out.println("Gross Salary: " + gross_salary);
        
        
        
        
        
        
        
    }
    
}
