package set.Ordination;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String name;
    private final Long registration;
    private final double grade;


    public Student(String name, long registration, double grade) {
        this.name = name;
        this.registration = registration;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Long getRegistration() {
        return registration;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getRegistration() == student.getRegistration();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistration());
    }

    @Override
    public String toString() {
        return '[' +
                "name= " + name + '\'' +
                ", registration= " + registration +
                ", grade= " + grade +
                ']';
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }
}