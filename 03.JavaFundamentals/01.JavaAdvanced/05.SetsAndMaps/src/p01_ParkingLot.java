import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p01_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Set<String> carsNumbers = new HashSet<>();
        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }
            String[] tokens = line.split(",\\s+");
            String direction = tokens[0];
            switch (direction) {
                case "IN":
                    carsNumbers.add(tokens[1]);
                    break;
                case "OUT":
                    carsNumbers.remove(tokens[1]);
                    break;
            }
        }
        if (!carsNumbers.isEmpty()) {
            for (String carsNumber : carsNumbers) {
                System.out.println(carsNumber);
            }
        } else {
            System.out.println("Parking Lot is Empty".trim());
        }
    }
}
