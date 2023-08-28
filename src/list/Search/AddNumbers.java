package list.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddNumbers {
    List<Integer> numberList;

    public AddNumbers() {
        this.numberList = new ArrayList<>();
    }

    public void addNumber(int number) {
        numberList.add(number);
    }

    public int sumNumbers() {
        return numberList.stream().reduce(0, Integer::sum);
    }

    public int higherNumber(){
        return Collections.max(numberList);
    }

    public int loweNumber(){
        return Collections.min(numberList);
    }

    public List<Integer> getNumbers(){
        return numberList;
    }

    public static void main(String[] args) {
        AddNumbers numberList = new AddNumbers();

        System.out.println("Lista: " + numberList.getNumbers());
        numberList.addNumber(1);
        numberList.addNumber(3);
        numberList.addNumber(10);
        numberList.addNumber(42);
        numberList.addNumber(321);
        numberList.addNumber(22);

        System.out.println("List: " + numberList.getNumbers());
        System.out.println("Sum: " + numberList.sumNumbers());
        System.out.println("Higher Number: " + numberList.higherNumber());
        System.out.println("Lower Number: " + numberList.loweNumber());
    }
}
