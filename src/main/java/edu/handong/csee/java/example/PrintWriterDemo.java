package edu.handong.csee.java.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) {
		PrintWriterDemo writer = new PrintWriterDemo();
		writer.run();
	}
	
	//Streams are implemented as objects of special stream classes
	private void run() {
		String fileName = "out.txt"; 
		PrintWriter outputStream = null; //Declare stream variable for referencing the stream 
		try {
			outputStream = new PrintWriter(fileName); //Invoke PrintWriter constructor, pass filename as argument
		}
		catch(FileNotFoundException e) { //Not enough memory to create a file 
			System.out.println("Error opening the file" + fileName);
			System.exit(0);
		}
		
		outputStream.close();
	}
}
