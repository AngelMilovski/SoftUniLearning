import java.util.Scanner;

public class p45_TrainersSalary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberLectures = Integer.parseInt(scan.nextLine());
        double budget = Double.parseDouble(scan.nextLine());
        int Roli = 0;
        int Trofon = 0;
        int Sino = 0;
        int Jelev = 0;
        int RoYaL = 0;
        int other = 0;
        double salaryForLecture = budget / numberLectures;

        for (int i = 0; i < numberLectures; i++) {
            String lecturer = scan.nextLine();
            if (lecturer.equals("Roli")){
                Roli++;
            }else if (lecturer.equals("Trofon")){
                Trofon++;
            }else if (lecturer.equals("Sino")){
                Sino++;
            }else if (lecturer.equals("Jelev")){
                Jelev++;
            }else if (lecturer.equals("RoYaL")){
                RoYaL++;
            }else {
                other++;
            }
        }
        System.out.printf("Jelev salary: %.2f lv%n", Jelev * salaryForLecture);
        System.out.printf("RoYaL salary: %.2f lv%n", RoYaL * salaryForLecture);
        System.out.printf("Roli salary: %.2f lv%n", Roli * salaryForLecture);
        System.out.printf("Trofon salary: %.2f lv%n", Trofon * salaryForLecture);
        System.out.printf("Sino salary: %.2f lv%n", Sino * salaryForLecture);
        System.out.printf("Others salary: %.2f lv%n", other * salaryForLecture);
    }
}
