import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p12_Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String[] robotsData = reader.readLine().split(";");
        String[] robots = new String[robotsData.length];
        int[] processTime = new int[robotsData.length];
        int[] robotsCounter = new int[robotsData.length];
        for (int i = 0; i < robotsData.length; i++) {
            String[] currentRobot = robotsData[i].split("-");
            robots[i] = currentRobot[0];
            processTime[i] = Integer.parseInt(currentRobot[1]);
        }
        String[] times = reader.readLine().split(":");
        long hours = Long.parseLong(times[0]) * 60 * 60;
        long minutes = Byte.parseByte(times[1]) * 60;
        long seconds = Byte.parseByte(times[2]);
        long currentSeconds = hours + minutes + seconds;
        StringBuilder result = new StringBuilder();
        ArrayDeque<String> products = new ArrayDeque<>();

        String product;
        while (!"End".equals(product = reader.readLine())) {
            products.offer(product);
        }
        while (!products.isEmpty()) {
            currentSeconds++;
            for (int i = 0; i < robots.length; i++) {
                if (robotsCounter[i] > 0) {
                    robotsCounter[i]--;
                }
            }
            String currentProduct = products.poll();
            boolean isProductTaken = false;
            for (int i = 0; i < robots.length; i++) {
                if (robotsCounter[i] == 0) {
                    robotsCounter[i] = processTime[i];
                    isProductTaken = true;
                    result.append(String.format("%s - %s %s", robots[i], currentProduct, getCurrentTime(currentSeconds)))
                            .append(System.lineSeparator());
                    break;
                }
            }
            if (!isProductTaken) {
                products.offer(currentProduct);
            }
        }
        System.out.println(result);
    }

    private static String getCurrentTime(long currentSeconds) {
        long sec = currentSeconds % 60;
        long min = (currentSeconds / 60) % 60;
        long h = (currentSeconds / (60 * 60)) % 24;
        return String.format("[%02d:%02d:%02d]", h, min, sec);
    }
}

