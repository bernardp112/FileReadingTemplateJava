package Testing;

import java.io.*;
import java.util.ArrayList;

public class FileReading {
	
	public static void main(String[] args) {
		ArrayList<String> employees = new ArrayList<>();
		readFile(employees);
		displayEmployees(employees);
	}
	
	static void displayEmployees(ArrayList<String> employees) {
		for(String employee: employees)
			System.out.println(employees);
	}
	
	static void readFile(ArrayList<String> employees){		
		String line = "";
		BufferedReader fileInput = null;	
		try {
			fileInput = new BufferedReader(new FileReader(
						new File("C:/JavaProgramming/employees.txt")));
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
