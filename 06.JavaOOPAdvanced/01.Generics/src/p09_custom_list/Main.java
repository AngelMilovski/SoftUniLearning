package p09_custom_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private BufferedReader reader;

    public Main() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() throws IOException {
        MyList<String> myList = new MyArrayList<>();
        for (String line = reader.readLine(); !("END").equals(line); line = reader.readLine()) {
            String[] commandArgs = line.split(" ");
            getSwitch(commandArgs, myList);
        }
    }

    private void getSwitch(String[] commandArgs, MyList<String> myList) {
        switch (commandArgs[0]) {
            case "Add":
                myList.add(commandArgs[1]);
                break;
            case "Remove":
                myList.remove(Integer.parseInt(commandArgs[1]));
                break;
            case "Contains":
                System.out.println(myList.contains(commandArgs[1]));
                break;
            case "Swap":
                myList.swap(Integer.valueOf(commandArgs[1]), Integer.valueOf(commandArgs[2]));
                break;
            case "Greater":
                System.out.println(myList.countGreaterThan(commandArgs[1]));
                break;
            case "Max":
                System.out.println(myList.getMax());
                break;
            case "Min":
                System.out.println(myList.getMin());
                break;
            case "Sort":
                myList.sort();
                break;

            case "Print":
                myList.foreach();
                break;
        }
    }

    public static void main(String[] args) throws IOException {

        Main engine = new Main();
        engine.run();
    }
}

