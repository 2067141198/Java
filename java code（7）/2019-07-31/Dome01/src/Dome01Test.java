public class Dome01Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("张三", 20);
        System.out.println("s1的姓名是：" + s1.getName() + ",年龄是：" + s1.getAge());
        System.out.println("s2的姓名是：" + s2.getName() + ",年龄是：" + s2.getAge());
    }
}
