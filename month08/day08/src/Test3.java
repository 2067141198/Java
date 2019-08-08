/*final*/ class Animal{
    public void shout() {
        System.out.println("动物在叫...");
    }
}

class Dog extends Animal {
    public void shout() {
        super.shout();
        System.out.println("汪汪汪...");
    }
}

class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵...");
    }
}

public class Test3 {
    public static void main(String[] args) {
        Animal an = new Dog();
        an.shout();
        Animal an2 = new Cat();
        an2.shout();
        Animal an3 = new Animal();
        an3.shout();
    }
}
