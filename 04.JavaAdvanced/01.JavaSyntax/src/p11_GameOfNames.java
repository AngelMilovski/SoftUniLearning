import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11_GameOfNames {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        LinkedHashMap<String, Integer> playersScore = new LinkedHashMap<>();

        byte numberPlayers = Byte.parseByte(reader.readLine());

        for (int i = 0; i < numberPlayers; i++) {
            playersScore.put(reader.readLine(), Integer.parseInt(reader.readLine()));
        }
        for (Map.Entry<String, Integer> kvp:playersScore.entrySet()) {
            char[] name = kvp.getKey().toCharArray();
            int score = kvp.getValue();

            for (int i = 0; i < name.length; i++) {
                if (name[i] % 2 == 0){
                    score += name[i];
                }else{
                    score -= name[i];
                }
            }
            playersScore.put(kvp.getKey(), score);
        }
        Collection highestScore = playersScore.values();
        String theBestPlayer = Collections.max(playersScore.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
        System.out.printf("The winner is %s - ", theBestPlayer);
        System.out.print(Collections.max(highestScore) + " points");
        System.out.println();
    }
}

