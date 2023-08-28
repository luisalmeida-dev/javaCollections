package list.Ordination;

public class Person implements Comparable<Person>{
    private final String name;
    private final int age;
    private final double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return '[' +
                "name= " + name +
                " age= " + age +
                " height= " + height +
                ']';
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(age, p.age);
    }
}
