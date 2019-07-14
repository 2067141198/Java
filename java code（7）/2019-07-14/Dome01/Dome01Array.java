package Dome01;

/*
* 题目：
* 定义一个数组，用来储存3个Person对象
*
* 数组有一个缺点，一旦创建，程序运行过程中长度是不可以发生变化的
*  */
public class Dome01Array {

    public static void main(String[] args) {
        //首先创建一个长度为3的数字,里面用来存放Person类型的对象
        Person[] array = new Person[3];
        System.out.println(array[0]);

        Person p1 = new Person("张三",18);
        Person p2 = new Person("李四",20);
        Person p3 = new Person("王麻子",25);

        //将p1当中的地址赋值给数组的0号元素位置
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;

        System.out.println(array);

        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(array[i].getName());
            System.out.println(array[i].getAge() );
        }
    }
}
