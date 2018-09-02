package p04_create_annotation;


public class Main {


    public static void main(String[] args) {

        Class<? extends Test> testClass = Test.class;

        if (testClass.isAnnotationPresent(Subject.class)) {
            Subject annotation = testClass.getAnnotation(Subject.class);

            System.out.println(annotation.toString());
        }
    }


}
