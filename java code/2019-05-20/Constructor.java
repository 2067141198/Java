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
public class Constructor {
	public static void main(String[] args) {
		// Group group = new Group();
		// group.groupName = "java10班";
		// group.groupStudentNum = 50;
		// group.print("欢迎来到比特， ");
		
		Group group2 = new Group("java10班", 50);
		group2.print("欢迎来到比特， ");
	}
}