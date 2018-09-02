package p11_threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private BufferedReader reader;

    public Main() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];
        String address = tokens[2];
        String town = tokens[3];

        Threeuple<Tuple<String, String>, String, String> nameAddressAndTown = new Threeuple<>(new Tuple<>(firstName, lastName),
                address, town);

        tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        int beerLiters = Integer.parseInt(tokens[1]);
        boolean isDrunk = tokens[2].equals("drunk");

        Threeuple<String, Integer, Boolean> nameBeerLitersAndDrunkOrNot = new Threeuple<>(name, beerLiters, isDrunk);

        tokens = reader.readLine().split("\\s+");
        name = tokens[0];
        double accountBalance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];

        Threeuple<String, Double, String> nameBankNameAndAccountBalance = new Threeuple<>(name, accountBalance, bankName);

        print(nameAddressAndTown, nameBeerLitersAndDrunkOrNot, nameBankNameAndAccountBalance);
    }

    private void print(Threeuple<Tuple<String, String>, String, String> nameAddressAndTown,
                       Threeuple<String, Integer, Boolean> nameBeerLitersAndDrunkOrNot,
                       Threeuple<String, Double, String> nameBankNameAndAccountBalance) {

        System.out.println(String.format("%s %s -> %s -> %s",
                nameAddressAndTown.getFirstItem().getFirstName(),
                nameAddressAndTown.getFirstItem().getLastName(),
                nameAddressAndTown.getSecondItem(),
                nameAddressAndTown.getThirdItem()));

        System.out.println(String.format("%s -> %d -> %s",
                nameBeerLitersAndDrunkOrNot.getFirstItem(),
                nameBeerLitersAndDrunkOrNot.getSecondItem(),
                nameBeerLitersAndDrunkOrNot.getThirdItem()));

        System.out.println(String.format("%s -> %s -> %s",
                nameBankNameAndAccountBalance.getFirstItem(),
                nameBankNameAndAccountBalance.getSecondItem(),
                nameBankNameAndAccountBalance.getThirdItem()));
    }

    public static void main(String[] args) throws IOException {
        Main starter = new Main();
        starter.run();
    }
}