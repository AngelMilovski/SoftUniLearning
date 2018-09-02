package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));


        for (String modifier = reader.readLine(); !modifier.equals("HARVEST"); modifier = reader.readLine()) {

            printFields(modifier);

        }
    }

    private static Field[] getDeclaredFields(String modifier) {


            final Class<?> richSoilLandClass = RichSoilLand.class;

            switch (modifier) {
                case "private":
                    return Arrays.stream(richSoilLandClass.getDeclaredFields())
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .toArray(Field[]::new);

                case "protected":
                    return Arrays.stream(richSoilLandClass.getDeclaredFields())
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .toArray(Field[]::new);

                case "public":
                    return Arrays.stream(richSoilLandClass.getDeclaredFields())
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .toArray(Field[]::new);

                case "all":
                    return richSoilLandClass.getDeclaredFields();

                    default:
                        return null;
            }
    }

    private static void printFields(String modifier) {
        Field[] fields = getDeclaredFields(modifier);
        assert fields != null;
        Arrays.stream(fields).forEach(field -> {
            System.out.println(String.format("%s %s %s",
                    Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName()));
        });
    }
}
