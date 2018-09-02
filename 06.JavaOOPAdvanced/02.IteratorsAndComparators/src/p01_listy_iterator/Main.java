package p01_listy_iterator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String debug = "";
        ListyIterator<String> stringListyIterator = null;
        for (String line = reader.readLine(); !line.equalsIgnoreCase("End"); line = reader.readLine()) {

            String[] command = line.split("\\s+");

            switch (command[0]) {
                case "Create":
                    stringListyIterator = new ListyIterator<>(Arrays.stream(command).skip(1).toArray(String[]::new));
                    break;
                case "HasNext":
                    System.out.println(stringListyIterator.iterator().hasNext());
                    break;
                case "Move":
                    System.out.println(stringListyIterator.move());
                    break;
                case "Print":
                    try {
                        stringListyIterator.print();

                    } catch (IllegalArgumentException iao) {
                        System.out.println(iao.getMessage());
                    }
                    break;
                case "PrintAll":
                    stringListyIterator.printAll();
            }
        }

    }
}
