package edu.handong.csee.java.example.binarydemo;

import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class DoubleInputDemo {

	public static void main(String[] args) {
		DoubleInputDemo demonstrator = new DoubleInputDemo();
		demonstrator.run();
	}
	
	private void run() {
		String fileName="numbers_output_ArrayList.dat";
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
			System.out.println("Reading the doubled numbers in the file " + fileName);
			
			int anInteger = inputStream.readInt();
			while(true) {
				System.out.println(anInteger);
				anInteger = inputStream.readInt();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the file " +fileName);
		}
		catch(EOFException e) {
			
			System.out.println("Reached end of the file");
		}
		catch(IOException e) {
			System.out.println("Problem reading the file " +fileName);
		}
	}

}
