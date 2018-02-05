import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p12_VehiclePark {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        List<String> vehicle = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String incomingRequests = reader.readLine();

        int count = 0;

        while (!incomingRequests.equals("End of customers!")) {
            String[] dataCar = incomingRequests.split(" ");
            String type = dataCar[0].toLowerCase();
            String seats = dataCar[2];
            if (vehicle.contains(type.charAt(0) + seats)){
                    System.out.println(String.format("Yes, sold for %d$", Integer.parseInt(seats) * type.charAt(0)));
                    count++;
                    vehicle.remove(type.charAt(0) + seats);
            }else{
                System.out.println("No");
            }
            incomingRequests = reader.readLine();
        }
        System.out.println(String.format("Vehicles left: %s", String.join(", ", vehicle)));
        System.out.println(String.format("Vehicles sold: %d", count));
    }
}