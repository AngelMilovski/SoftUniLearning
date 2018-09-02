package p10_tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private BufferedReader reader;
    private Tuple<Object, Object> tuple;

    public Main() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        List<Tuple<Object, Object>> tuples = new ArrayList<>();
//        Tuple<Object, Object> tuple = null;
        for (int i = 0; i < 3; i++) {
            String[] tokens = reader.readLine().split("\\s+");
           getSwitch(tokens, i, tuples);
        }
        print(tuples);
    }

    private void print(List<Tuple<Object,Object>> tuples) {
        tuples.forEach(System.out::println);
    }


    private void getSwitch(String[] tokens, int i, List<Tuple<Object, Object>> tuples) {

        switch (i) {
            case (0):
                String allName = tokens[0] + " " + tokens[1];
                String city = tokens[2];
                this.tuple = new Tuple<>(allName, city);
                tuples.add(this.tuple);
                break;
            case (1):
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                this.tuple = new Tuple<>(name, age);
                tuples.add(this.tuple);
                break;
            case (2):
                int integer = Integer.parseInt(tokens[0]);
                double doubl = Double.parseDouble(tokens[1]);
                this.tuple = new Tuple<>(integer, doubl);
                tuples.add(this.tuple);
                break;
        }
    }

    public static void main(String[] args) throws IOException {

        Main starter = new Main();
        starter.run();
    }
}
