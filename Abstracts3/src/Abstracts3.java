import java.time.LocalDate;

abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int birthdayYear;

    public Person(String firstName, String lastName, int birthdayYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayYear = birthdayYear;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthdayYear;
    }
}

class Employee extends Person {
    protected LocalDate hireDate;
    protected String companyName;
    protected double salary;

    public Employee(String firstName, String lastName, int birthdayYear, LocalDate hireDate, String companyName, double salary) {
        super(firstName, lastName, birthdayYear);
        this.hireDate = hireDate;
        this.companyName = companyName;
        this.salary = salary;
    }

    public int getJobSeniority() {
        return LocalDate.now().getYear() - hireDate.getYear();
    }

    public double getSalary() {
        return salary;
    }
}

final class Manager extends Employee {
    private final double bonus;

    public Manager(String firstName, String lastName, int birthdayYear, int hireYear, String companyName, double salary, double bonus) {
        super(firstName, lastName, birthdayYear, LocalDate.of(hireYear, 1, 1), companyName, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return "Manager with lastName " + lastName + " and age " + getAge() + " has salary " + getSalary();
    }
}

public class Abstracts3 {
    public static void main(String[] args) {
        Manager manager = new Manager("Jan", "Kowalski", 1990, 2010, "PJATK", 2000d, 100d);
        System.out.println(manager);
    }
}