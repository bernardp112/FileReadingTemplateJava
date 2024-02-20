package Testing;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JoinPathDemo {
	
	public static void main(String[] args) {
		Path basicPath = Paths.get("C:/JavaProgramming");
		Path newPath = Paths.get("IO/Logs");
		
		//display the paths to the console
		System.out.println(basicPath.toString());
		System.out.println(newPath.toString());
		
		//add a path not found in it(adds newPath to basicPath)
		Path basicPath2 = basicPath.resolve(newPath.toString());
		//Returns the absolute portion(basicPath)
		Path newPath2 = newPath.resolve(basicPath.toString());
		
		System.out.println(basicPath2.toString());
		System.out.println(newPath2.toString());
	}
}
