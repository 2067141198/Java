package Person;

public class Person implements Comparable<Person>{
    String name;
    int age;
    int rank;

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "rank=" + rank +
                '}';
    }
}
