package edu.handong.csee.java.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileOutputAppendDemo {

	public static void main(String[] args) {
		TextFileOutputAppendDemo writer = new TextFileOutputAppendDemo();
		writer.run();
	}

	private void run() {
		String fileName = "out.txt";
		PrintWriter outputStream =null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileName,true)); 
			//FileOutputStream 의 instance를 제공(파일 이름과 boolean type 파라미터)
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening the file" + fileName);
			System.exit(0);
		}
		System.out.println ("Enter three lines of text:");
		Scanner keyboard = new Scanner(System.in);
		for(int count=1;count<=3;count++) {
			String line = keyboard.nextLine();
			outputStream.println(count + " " + line);
		}
		keyboard.close();
		outputStream.close();
        System.out.println ("Those lines were written to " + fileName);
	}
}