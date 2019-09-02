package Person;

import java.util.Comparator;

public class PersonRankWithComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.rank - o2.rank;
    }
}
