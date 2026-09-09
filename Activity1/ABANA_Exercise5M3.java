
package abana_exercisem3;
import java.util.Scanner;

public class ABANA_Exercise5M3 {
    public static void main (String[] args){
        double quiz;
        double project;
        double exam;
        double grade;
        final double QUIZ_WEIGHT = 0.3;
        final double PROJECT_WEIGHT = 0.3;
        final double EXAM_WEIGHT = 0.4;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter quiz grade: ");
        quiz = sc.nextDouble();
        System.out.print("Enter project grade: ");
        project = sc.nextDouble();
        System.out.print("Enter exam grade: ");
        exam = sc.nextDouble();
        
        grade = (quiz * QUIZ_WEIGHT) + (project * PROJECT_WEIGHT) + (exam * EXAM_WEIGHT);
        
        System.out.println("Final Grade: " + grade);
        
        
    }
}
