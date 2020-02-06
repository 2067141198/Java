package day04;

class Person1 {
    static int age;
    String name;

    {
        name = "1234";
        age = 1;
    }

    public void show() {
        class Son {
            String className;

            public void show() {
                System.out.println(className);
            }
        }
    }

    static class Son {
        String className;

        public void show() {
            System.out.println(className);
        }
    }

    //Son son = new Son();
}

public class Person {
    public static void main(String[] args) {
        Person1.Son son = new Person1.Son();
        son.show();
    }
}

