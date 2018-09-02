package mankind;

import mankind.constants.ConditionsForNamesSalaryAndWorkHours;
import mankind.constants.ExceptionMessages;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < ConditionsForNamesSalaryAndWorkHours.FACULTY_NUMBER_MIN_LENGTH
                || facultyNumber.length() > ConditionsForNamesSalaryAndWorkHours.FACULTY_NUMBER_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FACULTY_NUMBER_LENGTH_EXCEPTION_MESSAGE);
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder student = new StringBuilder();
        student.append(super.toString())
                .append(NEW_LINE)
                .append("Faculty number: ").append(this.facultyNumber);
        return student.toString();
    }
}
