package list.Ordination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOrdination {
    List<Integer> integerList;

    public NumberOrdination() {
        this.integerList = new ArrayList<>();
    }

    public void addNumber(int number) {
        integerList.add(number);
    }

    public void ascOrder() {
        Collections.sort(integerList);
    }

    public void descOrder(){
        integerList.sort(Collections.reverseOrder());
    }

    public List<Integer> getList(){
        return integerList;
    }

    public static void main(String[] args) {
        NumberOrdination numberList = new NumberOrdination();

        numberList.addNumber(2);
        numberList.addNumber(23);
        numberList.addNumber(21);
        numberList.addNumber(2);

        System.out.println("Normal: " + numberList.getList());
        numberList.ascOrder();
        System.out.println("Ascendant: " + numberList.getList());
        numberList.descOrder();
        System.out.println("Descendent: " + numberList.getList());
    }
}
