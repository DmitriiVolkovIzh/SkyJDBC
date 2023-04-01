package sky.project.models;

import java.util.Objects;

public class Employee {

    private String firstName;

    private String lastName;

    private Integer age;

    private City city;

    public Employee(String firstName, String lastName, Integer age, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return  firstName +
                " " + lastName + " " +
                 age+ " " + "Город: " + city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(age, employee.age) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, city);
    }
}
