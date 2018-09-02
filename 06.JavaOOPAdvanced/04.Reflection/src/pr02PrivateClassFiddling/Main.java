package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final String NEEDED_FIELD_NAME = "innerValue";

    public static void main(String[] args) throws IOException, InstantiationException {

        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

        String blackBoxPathName = "pr02PrivateClassFiddling.com.";
        String blackBoxClassName = "BlackBoxInt";

        BlackBoxInt blackBoxInt;

        try {
            final Class<?> blackBoxIntClass = Class.forName(blackBoxPathName + blackBoxClassName);
            Constructor<?> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();

            String line;

            while (true) {
                if ("END".equals(line = reader.readLine())) {
                    break;
                }

                String[] tokens = line.split("_");

                Method declaredMethod = blackBoxInt.getClass().getDeclaredMethod(tokens[0], int.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, Integer.parseInt(tokens[1]));

                final Field declaredField = blackBoxInt.getClass().getDeclaredField(NEEDED_FIELD_NAME);
                declaredField.setAccessible(true);
                System.out.println(declaredField.get(blackBoxInt));
            }

        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchFieldException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
