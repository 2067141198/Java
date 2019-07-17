import java.util.ArrayList;

public class Dome01ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("张三",20);
        Student s2 = new Student("李四",21);
        Student s3 = new Student("王五",22);
        Student s4 = new Student("赵六",23);
        Student s5 = new Student("孙七",24);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("姓名是：" + stu.getName() + "  年龄是：" + stu.getAge());
        }
    }
}
