import java.util.Scanner;
import java.util.TreeSet;

public class p02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        TreeSet<String> quests = new TreeSet<>();
        while (true) {
            if ("PARTY".equals(line = scan.nextLine())) {
                break;
            }
            quests.add(line);
        }
        while (true) {
            if ("END".equals(line = scan.nextLine())) {
                break;
            }
            quests.remove(line);
        }
        System.out.println(quests.size());
        for (String quest : quests) {
            System.out.println(quest);
        }
    }
}