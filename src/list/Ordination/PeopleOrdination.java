package list.Ordination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PeopleOrdination {
    List<Person> personList;

    public PeopleOrdination() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(String name, int age, double height) {
        Person person = new Person(name, age, height);
        personList.add(person);
    }

    public List<Person> orderByAge() {
        List<Person> orderedList = new ArrayList<>(personList);
        Collections.sort(orderedList);
        return orderedList;
    }

    public List<Person> orderByHeight(){
        List<Person> orderedList = new ArrayList<>(personList);
        orderedList.sort(new ComparatorByHeight());
        return orderedList;
    }

    public static void main(String[] args) {
        PeopleOrdination peopleList = new PeopleOrdination();

        peopleList.addPerson("Luis", 22, 1.71);
        peopleList.addPerson("Leandro", 30, 1.83);
        peopleList.addPerson("Marcos", 13, 1.56);
        peopleList.addPerson("Felipe", 20, 1.73);
        peopleList.addPerson("Fernando", 66, 1.78);

        System.out.println(peopleList.orderByAge());
        System.out.println(peopleList.orderByHeight());
    }
}

class ComparatorByHeight implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return Double.compare(p1.getHeight(), p2.getHeight());
    }
}
