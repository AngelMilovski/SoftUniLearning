import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        String input;
        List<Name> people = new ArrayList<>();

        while (true) {
            if ("END".equals(input = reader.readLine())) {
                break;
            }
            String[] tokens = input.split("\\s+");
            int group = Integer.parseInt(tokens[2]);
            String firstName = tokens[0];
            String lastName = tokens[1];
            String fullName = firstName + " " + lastName;
            Name name = new Name(group, fullName);
            people.add(name);
        }
        String debug = "";
        Map<Integer, List<Name>> peopleByGroup = people.stream().collect(Collectors.groupingBy(Name::getGroup));
//        peopleByGroup.forEach((key, value) -> {
//            System.out.println(String.format("%d - %s", key,
//                    value.stream().map(Name::getName).collect(Collectors.joining(","))));
//        });
        peopleByGroup.forEach((key, value) ->
                System.out.println(String.format("%d - %s", key,
                        String.join(", ",
                                value.stream().map(Name::getName).collect(Collectors.toList())))));
    }
}

class Name {
    private String name;
    private int group;


    public Name(int group, String name) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
