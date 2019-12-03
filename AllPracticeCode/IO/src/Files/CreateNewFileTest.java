package Files;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CreateNewFileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("test1.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        /*try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(file));

            String line;
            while(!(line = br.readLine()).equals("123")) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void test2() {
        try {
            File file = new File("test1.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        InputStream in = CreateNewFileTest.class.getClassLoader().getResourceAsStream("test1.txt");
        System.out.println(in);
    }
}
