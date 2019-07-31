
class Father {
    private String name = "zhangjun";

    class Child {
        public void introFather() {
            System.out.println("name = " + name);
        }
    }
}

public class FatherAndChild {
    public static void main(String[] args) {
        Father.Child ch = new Father().new Child();
        ch.introFather();
    }
}
