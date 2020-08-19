package dev.hirooka;

public class Employee {
    public Employee(String name) {
        this.name = name;
    }

    final String name;

    public String getName() {
        return name;
    }
}
