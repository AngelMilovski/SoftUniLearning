import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class p11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<StudentData> students = new ArrayList<>();

        String line;
        while (true) {
            if ("Students:".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String specialTyNameFirst = tokens[0];
            String specialTyNameSecond = tokens[1];
            String facultyNumber = tokens[2];

            StudentSpecialty studentSpecialty = new StudentSpecialty(specialTyNameFirst + " " + specialTyNameSecond, facultyNumber);

            studentSpecialties.add(studentSpecialty);

        }

        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String facultyNumber = tokens[0];
            String studentFirstName = tokens[1];
            String studentLastName = tokens[2];

            StudentData student = new StudentData(studentFirstName + " " + studentLastName, facultyNumber);

            students.add(student);
        }

        students.sort(Comparator.comparing(StudentData::getStudentName));

        List<String> joined = new ArrayList<>();

//        studentSpecialties.stream()
//                .flatMap(specialty ->
//                        students.stream().filter(student -> {
//                            if (specialty.getFacultyNumber().equals(student.getFacultyNumber())) {
//                                joined.add(String.format("%s %s %s",
//                                        student.getStudentName(),
//                                        student.getFacultyNumber(),
//                                        specialty.getSpecialtyName()));
//                            }
//
//                            return specialty
//                                    .getFacultyNumber()
//                                    .equals(student.getFacultyNumber());
//                        }))
//                .collect(Collectors.toList());

        students.stream()
                .forEach(student ->
                        studentSpecialties.stream().forEach(specialty -> {
                            if (specialty.getFacultyNumber().equals(student.getFacultyNumber())) {
                                System.out.println(String.format("%s %s %s",
                                        student.getStudentName(),
                                        student.getFacultyNumber(),
                                        specialty.getSpecialtyName()));
                            }
                        }));


    }
}

class StudentSpecialty {
    String specialtyName;
    String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return this.specialtyName;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }
}

class StudentData {
    String studentName;
    String facultyNumber;

    public StudentData(String studentName, String facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }
}
