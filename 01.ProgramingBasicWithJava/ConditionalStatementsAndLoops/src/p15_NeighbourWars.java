import javax.xml.bind.SchemaOutputResolver;
        import java.util.Scanner;

public class p15_NeighbourWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int PeshoDamage = Integer.parseInt(scan.nextLine());
        int GoshoDamage = Integer.parseInt(scan.nextLine());
        int PeshoHealth = 100;
        int GoshoHealth = 100;
        int turn = 0;

        while (PeshoHealth >= 1 && GoshoHealth >= 1) {
            turn++;
            if (turn % 2 == 1) {
                GoshoHealth -= PeshoDamage;
                if (GoshoHealth < 1) {
                    System.out.println(String.format("Pesho won in %dth round.", turn));
                    break;
                }
                System.out.println(String.format("Pesho used Roundhouse kick and reduced Gosho to %d health.", GoshoHealth));
            }else {

                PeshoHealth -= GoshoDamage;
                if (PeshoHealth < 1){
                    System.out.println(String.format("Gosho won in %dth round.", turn));
                    break;
                }
                System.out.println(String.format("Gosho used Thunderous fist and reduced Pesho to %d health.", PeshoHealth));
            }if (turn % 3 == 0){
                PeshoHealth += 10;
                GoshoHealth += 10;
            }
        }
    }
}
