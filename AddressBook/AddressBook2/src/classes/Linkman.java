package classes;

public class Linkman implements Comparable<Linkman>{
    private String name;

    public Linkman(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public int compareTo(Linkman linkman) {
        return this.name.compareTo(linkman.name);
    }
}
