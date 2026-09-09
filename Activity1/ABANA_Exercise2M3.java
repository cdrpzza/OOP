
package abana_exercisem3;

import java.util.Scanner;

public class ABANA_Exercise2M3 {
    public static void main(String[] args){
    double price;
        int quantity;
        double subtotal;
        final double VAT_RATE = 0.12;
        double vat;
        double final_total;
        
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Enter product price: ");
        price = sc.nextDouble();
        
        System.out.print("Enter quantity: ");
        quantity = sc.nextInt();
        
        subtotal = price * quantity;
        vat = subtotal * VAT_RATE;
        final_total = subtotal + vat;
        
        System.out.println();
        System.out.println("Subtotal: " + subtotal);
        System.out.println("VAT: " + vat);
        System.out.println("Total: " + final_total);
        
    }
}
