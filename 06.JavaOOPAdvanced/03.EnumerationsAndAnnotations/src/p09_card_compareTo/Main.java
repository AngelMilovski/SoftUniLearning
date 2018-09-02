package p09_card_compareTo;

import p09_card_compareTo.annotation.MyAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input = reader.readLine();

        Class<?> neededClass = input.equals("Rank") ? Rank.class : Suit.class;

        getMyAnnotation(neededClass);
    }

    private static void getMyAnnotation(Class<?> rankClass) {
        if (rankClass.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = rankClass.getAnnotation(MyAnnotation.class);
            print(annotation);
        }
    }

    private static void print(MyAnnotation annotation) {
        System.out.println(String.format("Type = %s, Description = %s.", annotation.type(), annotation.description()));
    }
}
