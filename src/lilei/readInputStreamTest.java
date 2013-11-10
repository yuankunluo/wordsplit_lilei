package lilei;
import java.io.*;
public class readInputStreamTest {
	public static void main(String[] args) throws IOException{
		FileInputStream in = new FileInputStream("./input/huoche.txt");
		System.out.print(in.available());
	}
}
