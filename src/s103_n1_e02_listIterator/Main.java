package s103_n1_e02_listIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        // List.of() is immutable, so we wrap it in an ArrayList to get a mutable list
        List<Integer> original = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> reversed = new ArrayList<>();

        // listIterator(index) starts the cursor AT that index; size() = after the last element
        ListIterator<Integer> it = original.listIterator(original.size());

        while (it.hasPrevious()) {
            reversed.add(it.previous());
        }

        System.out.println("Original: " + original); // [1, 2, 3, 4, 5]
        System.out.println("Reversed: " + reversed); // [5, 4, 3, 2, 1]
    }
}