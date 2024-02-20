package Testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandling {

		
	public static void main(String[] args) {
		ArrayList<String> employees = new ArrayList<>();
		readFile(employees);
		displayEmployees(employees);
		writeFile(employees);
	}
		
	private static void writeFile(ArrayList<String> employees) {
		Path path = Paths.get("C:/JavaProgramming/employees.txt");
		try {
			BufferedWriter bw = Files.newBufferedWriter(path,
					Charset.forName("ISO-8859-1"),
					StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			for(String employee: employees) {
				bw.write(employee);
				bw.newLine();
			}
			bw.close();
		}
		catch(IOException ioe){
			System.out.println("Error reading file.");
			System.exit(0);
		}
	}

	static void displayEmployees(ArrayList<String> employees) {
		for(String employee: employees)
			System.out.println(employee);
	}
		
	static void readFile(ArrayList<String> employees){		
		String line = "";
		Path path = Paths.get("C:/JavaProgramming/employees.txt");
		try {
			BufferedReader fileInput =
					Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
			line = fileInput.readLine();
			while(line != null) {
				employees.add(line);
				line = fileInput.readLine();
			}
			fileInput.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
		}
		catch(EOFException eofe) {
			System.out.println("No more lines to read.");
		}
		catch(IOException ioe) {
			System.out.println("Error reading file.");
		}
	}
}