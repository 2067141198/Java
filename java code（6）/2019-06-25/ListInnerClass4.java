interface list{
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index, int val);
	
	void popFront();
	void popBack();
	void earse(int index);
	
	int get(int index);
	void set(int index, int val);
	
	int size(); 
}