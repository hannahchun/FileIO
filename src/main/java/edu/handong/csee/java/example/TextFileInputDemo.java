package edu.handong.csee.java.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileInputDemo {

	public static void main(String[] args) {
		TextFileInputDemo reader = new TextFileInputDemo();
		reader.run();
	}

	private void run() {
		String fileName = "out.txt";
		
		Scanner inputStream = null;
		System.out.println("The file " + fileName + "\ncontains the following lines");
		
		try {
			inputStream = new Scanner(new File(fileName));
			//Scanner 클래스의 파라미터로 File instance를 제공 
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		inputStream.close(); //do not forget to close the stream 
	}
}
