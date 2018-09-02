package mankind;

import mankind.constants.ConditionsForNamesSalaryAndWorkHours;
import mankind.constants.ExceptionMessages;

public class Worker extends Human {
    private static final int WORK_HOURS_PER_WEEK = 7;

    private Double weekSalary;
    private Double workHours;

    public Worker(String firstName, String lastName, double salary, double workHours) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setWorkHours(workHours);

    }

    private void setSalary(double salary) {
        if (salary < ConditionsForNamesSalaryAndWorkHours.VALID_MIN_SALARY) {
            throw new IllegalArgumentException();
        }
        this.weekSalary = salary;
    }

    private void setWorkHours(double workHours) {
        if (workHours < ConditionsForNamesSalaryAndWorkHours.MIN_WORK_HOURS
                || workHours > ConditionsForNamesSalaryAndWorkHours.MAX_WORK_HOURS) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_WORKING_HOURS_EXCEPTION_MESSAGE);
        }
        this.workHours = workHours;
    }
    private double getWorkHours() {
        return this.workHours;
    }

    private double getSalaryPerHour() {
        double salaryPerHour = this.weekSalary / (WORK_HOURS_PER_WEEK * this.getWorkHours());
        return salaryPerHour;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() < ConditionsForNamesSalaryAndWorkHours.LAST_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_WORKER_LAST_NAME_EXCEPTION_MESSAGE);
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder worker = new StringBuilder();
        worker.append(super.toString())
                .append(NEW_LINE)
                .append("Week Salary: ").append(String.format("%.2f", this.weekSalary))
                .append(NEW_LINE)
                .append("Hours per day: ").append(String.format("%.2f", this.workHours))
                .append(NEW_LINE)
                .append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()));
        return worker.toString();
    }
}
