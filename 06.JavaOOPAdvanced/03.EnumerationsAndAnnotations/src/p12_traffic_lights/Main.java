package p12_traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        LightSwitcher lightSwitcher = new LightSwitcher();

        String[] tokens = reader.readLine().split("\\s+");
        for (String colorOfLight : tokens) {
            lightSwitcher.addTrafficLight(new TrafficLight(colorOfLight));
        }

        int numberOfChangeSignal = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        while (numberOfChangeSignal-- > 0) {
            lightSwitcher.switchSignal();

            for (TrafficLight trafficLight : lightSwitcher.getSwitcher()) {
                result.append(trafficLight).append(" ");
            }

            result.append(System.lineSeparator());
        }

        System.out.println(result.toString().trim());
    }
}