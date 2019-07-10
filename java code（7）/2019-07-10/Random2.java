import java.util.Random;

public class Random2 {
	public static void main(String[] args) {
		Random r = new Random();
		
		for(int i = 0; i < 100; i++) {
			int num = r.nextInt(10);
		}
	}
}
