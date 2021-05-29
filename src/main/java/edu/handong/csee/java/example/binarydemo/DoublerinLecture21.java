package edu.handong.csee.java.example.binarydemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DoublerinLecture21{
	
	ArrayList<Integer> numbersFromBinaryFile = new ArrayList<Integer>();
	
	public static void main(String [] args) {
		DoublerinLecture21 demonstrator = new DoublerinLecture21();
		demonstrator.run();
	}
	
	private void run() {
		String binaryFileName = "numbers.dat";
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(binaryFileName));
			
			int anInteger = stream.readInt();
			while(anInteger >=0) {
				numbersFromBinaryFile.add(anInteger);
				anInteger = stream.readInt();
			}
			stream.close();
			
			ArrayList<Integer> doubledNumbers = doubleIntNumbers();
			
			String finalOutBinaryFile ="numbers_output_ArrayList.dat";
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(finalOutBinaryFile));
			
			for(int currentDoubledInt:doubledNumbers) {
				outStream.writeInt(currentDoubledInt);
			}
			outStream.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	} 
	
	private ArrayList<Integer> doubleIntNumbers(){
		ArrayList<Integer> doubledNumbers = new ArrayList<Integer>();
		
		for(Integer currentInt: numbersFromBinaryFile) {
			doubledNumbers.add(currentInt*2);
		}
		return doubledNumbers;
	}
}
