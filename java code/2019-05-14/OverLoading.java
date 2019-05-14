//contructor
class Tree {
	int height;
	Tree() {
		prt("planting a seeding");
		height = 0;
	}
	Tree(int i) {
		prt("Greating new Tree that is " + i +" feet tall");
		height = i;
	}
	void info() {
		prt("Tree is " + height + " feet tall");
	}
	void info(String s) {
		prt(s + ": Tree is " + height + " feet tall");
	}
	static void prt(String s) {
		System.out.println(s);
	}
}
public class OverLoading {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			Tree t = new Tree(i);
			t.info();
			t.info("OverLoaded method");
		}
		new Tree();
	}
}