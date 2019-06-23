interface List {
	//插入
	void pushFront(int val);
	void pushBack(int val;);
	void insert(int index; int val);
	
	//删除
	void popFront();
	void popBack();
	void earse(int index);
	
	//根据下标访问或者修改
	void get(int index);
	void set(int index, int val);
	
	//返回数据个数
	int size();
}

abstract class abstractList implements List {
	private int size;
	
	@Override
	public void pushFront(int val) {
		insert(0, val);
	}
	
	@Override
	public void pushBack(int val) {
		insert(size, val);
	}
	
	@Override
	public void insert(int index, int val) {
		if(index < 0 || index > size) {
			System.out.println("下标错误！");
			return;
		}
		
		insertInternal(int index, int val);
	}
	
	public void insertInternal(int index, int val);
	
	@Override
	public int size() {
		return size;
	}
}










