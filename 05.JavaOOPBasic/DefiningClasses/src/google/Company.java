package google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.setName(name);
        this.setDepartment(department);
        this.setSalary(salary);
    }

    public Company() {
        this.setName("Pesho");
        this.setDepartment("A1");
        this.setSalary(0.0d);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.getName(), this.getDepartment(), this.getSalary());
    }
}
