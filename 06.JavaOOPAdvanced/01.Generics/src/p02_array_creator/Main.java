package p02_array_creator;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(5, "5");
        Integer[] integer = ArrayCreator.create(Integer.class, 5, 5);
        System.out.println(strings.length);
        System.out.println(integer.length);
    }
}
