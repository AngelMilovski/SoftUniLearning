import java.util.Scanner;

public class p09_CharacterStats {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int currentHealth = Integer.parseInt(scan.nextLine());
        int maxHealth = Integer.parseInt(scan.nextLine());
        int currentEnergy = Integer.parseInt(scan.nextLine());
        int maxEnergy = Integer.parseInt(scan.nextLine());
        int emptyHealth = maxHealth - currentHealth;
        int emptyEnergy = maxEnergy - currentEnergy;

        System.out.println(String.format("Name: %s", name));
        System.out.println(String.format("Health: |%s%s|",
                repeatSrt("|", currentHealth),
                repeatSrt(".", emptyHealth)));
        System.out.println(String.format("Energy: |%s%s|",
                repeatSrt("|", currentEnergy),
                repeatSrt(".", emptyEnergy)));
    }
    public static String repeatSrt(String str, int count){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
