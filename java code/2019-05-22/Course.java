// class Person {
	// String name;
	// int age;
	
	
	// void print() {
		// System.out.println("name = " + name + " age = " + age);
	// }
// }

// public class Course {
	// public static void main(String[] args) {
		// //只定义了一个引用变量，没有真正的创建对象
		// Person person = null;
		// //如何创建对象
		// person = new Person();
		
		// person.name = "中国人";
		// person.age = 5000;
		// person.print();
	// }
// }

class Group {
	//属性
	String groupName;//名字
	int groupStudentNum;//人数
	
	//方法
	//构造方法
	Group(String n, int m) {
		groupName = n;
		groupStudentNum = m;
	}
	
	void print(String s) {
		System.out.println(s + groupName + "的" + groupStudentNum + "位同学们");
	}
}

//一个文件中只允许一个public修饰的类，这个类名与文件名一致
public class Course {
	public static void main(String[] args) {
		// Group group = new Group();
		// group.groupName = "java10班";
		// group.groupStudentNum = 50;
		// group.print("欢迎来到比特， ");
		
		Group group2 = new Group("java10班", 50);
		group2.print("欢迎来到比特， ");
	}
}