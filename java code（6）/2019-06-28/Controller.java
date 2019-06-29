class intSet {
	private int[] ints = new int[100];
	private int index = 0;
	private int next = 0;
	public void add(int e) {
		if(index >= ints.length)
			return; // (In real life, throw exception)
		ints[index++] = e;
	}
	public int getNext() {
		boolean looped = false;
		int start = next;
		do {
			next = (next + 1) % ints.length;
			// See if it has looped to the beginning:
			if(start == next) looped = true;
			// If it loops past start, the list
			// is empty:
			if((next == (start + 1) % ints.length)
			&& looped)
			return null;
		} while(ints[next] == null);
		return ints[next];
	}
	public void removeCurrent() {
		ints[next] = null;
	}
}
public class Controller {
	private intSet es = new intSet();	
	public void addint(int c) { es.add(c); }
	public void run() {
		int e;
		while((e = es.getNext()) != null) {
			if(e.ready()) {
				e.action();
				System.out.println(e.description());
				es.removeCurrent();
			}
		}
	}
}