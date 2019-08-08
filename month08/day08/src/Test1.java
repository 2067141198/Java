public class Test1 {
    public static void main(String[] args) {
        B b = new B();
        b.test();
    }

    void test() {
        System.out.println("A");
    }
}

class B extends Test1 {
    void test() {
        super.test();
        System.out.println("B");
    }
}