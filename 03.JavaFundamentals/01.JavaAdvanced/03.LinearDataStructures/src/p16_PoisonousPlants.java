import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p16_PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int[] plants = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            plants[i] = Integer.parseInt(input[i]);
        }
        int[] days = new int[plants.length];
        ArrayDeque<Integer> proximityStack = new ArrayDeque<>();
        proximityStack.push(0);

        for (int i = 1; i < plants.length; i++)
        {
            int maxDays = 0;

            while (!proximityStack.isEmpty() && plants[proximityStack.peek()] >= plants[i])
            {
                maxDays = Math.max(maxDays, days[proximityStack.pop()]);
            }
            if (!proximityStack.isEmpty())
            {
                days[i] = maxDays + 1;
            }
            proximityStack.push(i);
        }

        System.out.println(getMax(days));
    }

    private static int getMax(int[] days) {
        int max = 0;
        for (int i = 0; i < days.length - 1; i++) {
            int biggerNum = 0;
            if (days[i] > days[i + 1]) {
                biggerNum = days[i];
            } else {
                biggerNum = days[i + 1];
            }
            if (max < biggerNum) {
                max = biggerNum;
            }
        }
        return max;
    }
}