package set.Ordination;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class StudentManager {
    private final Set<Student> students;

    public StudentManager() {
        this.students = new HashSet<>();
    }

    public void addStudent(String name, long registration, double grade) {
        students.add(new Student(name, registration, grade));
    }

    public void removeStudent(long registration) {
        students.removeIf(Student -> Student.getRegistration().equals(registration));
    }

    public Set<Student> orderByName() {
        return new TreeSet<>(students);
    }

    public Set<Student> orderByGrade() {
        Set<Student> orderedSet = new TreeSet<>(new ComparatorByGrade());
        orderedSet.addAll(students);
        return orderedSet;
    }

    public Set<Student> getAll() {
        return students;
    }

    public static void main(String[] args) {
        StudentManager students = new StudentManager();

        System.out.println("Students: " + students.getAll());

        students.addStudent("Luis", 1L, 3.2);
        students.addStudent("Lucas", 2L , 7.3);
        students.addStudent("Sterzada", 3L, 9.3);
        students.addStudent("Carucs", 4L, 6.9);

        System.out.println("Students: " + students.getAll());
        System.out.println("Order by name: " + students.orderByName());
        System.out.println("Order by grade: " + students.orderByGrade());
    }
}

class ComparatorByGrade implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getGrade(), o2.getGrade());
    }
}
