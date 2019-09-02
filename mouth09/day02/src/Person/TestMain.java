package Person;

import java.util.Arrays;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        Random random = new Random(20190902);
        for (int i = 0; i < 10; i++) {
            people[i] = new Person();
            people[i].rank = random.nextInt(50);
        }
        System.out.println(Arrays.toString(people));
        PersonMergeSort.mergeSort(people, new PersonRankWithComparator());
        System.out.println(Arrays.toString(people));
    }
}
