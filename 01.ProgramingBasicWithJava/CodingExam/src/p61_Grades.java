import java.util.Scanner;

public class p61_Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numberStudent = Double.parseDouble(scan.nextLine());
        double topStudent = 0.0;
        double goodStudents = 0.0;
        double betweenThreeAndFour = 0.0;
        double fail = 0.0;
        double average = 0.0;

        for (int i = 0; i < numberStudent; i++) {
            double examEvaluation = Double.parseDouble(scan.nextLine());
            average += examEvaluation;
            if (examEvaluation >= 5.00){
                topStudent++;
            }else if (examEvaluation >= 4.00 && examEvaluation <= 4.99){
                goodStudents++;
            }else if (examEvaluation >= 3.00 && examEvaluation <= 4.99){
                betweenThreeAndFour++;
            }else {
                fail++;
            }
        }
        double percentAverage = average / numberStudent;
        double percentTopStudent = topStudent / numberStudent * 100;
        double percentGoodStudents = goodStudents / numberStudent * 100;
        double percentBetweenThreeAndFour = betweenThreeAndFour / numberStudent * 100;
        double percentFail = fail / numberStudent * 100;

        System.out.printf("Top students: %.2f%%%n", percentTopStudent);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentGoodStudents);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", percentBetweenThreeAndFour);
        System.out.printf("Fail: %.2f%%%n", percentFail);
        System.out.printf("Average: %.2f%n", percentAverage);
    }
}
