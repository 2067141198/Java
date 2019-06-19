// 父类：线性表
class List {
	// 不能直接写成 private，否则子类没有访问权限
	// protected 子类有权限，其他类没权限
	protected int size;
	
	public int getSize() {
		return size;
	}
}

// 顺序表，继承自线性表
class ArrayList extends List {
	private int[] array = new int[100];
	private int size;
	
	public void pushBack(int val) {
		array[size++] = val;
	}
	
	public void setSize(int size) {
		size;		// 形参/局部变量
		this.size;	// 本身属性
		super.size;	// 父类属性
	}
}

// 链表，继承自线性表
class LinkedList extends List {
}


public class CourseInherit {
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		arrayList.pushBack(1);
		arrayList.pushBack(2);
		arrayList.pushBack(3);
		arrayList.pushBack(4);
		
		System.out.println(arrayList.getSize());
	}
}








